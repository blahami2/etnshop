package cz.etn.etnshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
//import org.hibernate.search.FullTextSession;
//import org.hibernate.search.Search;
//import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

@Repository( "productDao" )
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    @Override
    public void saveProduct( Product product ) {
        persist( product );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<Product> getProducts() {
        Criteria criteria = getSession().createCriteria( Product.class );
        return (List<Product>) criteria.list();
    }

    @Override
    public List<Product> searchProducts( String text ) {
//        FullTextSession fullTextSession = Search.getFullTextSession( getSession() );
//        QueryBuilder qb = fullTextSession.getSearchFactory()
//                .buildQueryBuilder().forEntity( Product.class ).get();
//        org.apache.lucene.search.Query luceneQuery = qb
//                .keyword()
//                .onFields( "name", "serialNumber" )
//                .matching( text )
//                .createQuery();
//        List<Product> result = fullTextSession.createFullTextQuery( luceneQuery, Product.class ).list();
        SQLQuery query;
        try {
            int num = Integer.parseInt( text );
            query = getSession().createSQLQuery( "SELECT * FROM Product WHERE (  serialNumber = :num OR  name LIKE :needle )" );
            query.setInteger( "num", num );
        } catch ( NumberFormatException ex ) {
            query = getSession().createSQLQuery( "SELECT * FROM Product WHERE ( name LIKE :needle )" );
        }
        query.addEntity( Product.class ).setString( "needle", "%" + text + "%" );
        List<Product> result = (List<Product>) query.list();
        return result;
    }

    @Override
    public void deleteProduct( int productId ) {
        Query query = getSession().createSQLQuery( "delete from Product where id = :id" );
        query.setInteger( "id", productId );
        query.executeUpdate();
    }

    @Override
    public void updateProduct( Product product ) {
        getSession().update( product );

    }

    @Override
    public Product getProduct( int productId ) {
        return (Product) getSession().get( Product.class, productId );
    }

}
