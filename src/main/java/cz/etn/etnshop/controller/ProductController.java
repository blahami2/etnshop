package cz.etn.etnshop.controller;

import cz.etn.etnshop.dao.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cz.etn.etnshop.service.ProductService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( "/product" )
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping( "/list" )
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView( "product/list" );
        System.out.println( "Count:" + productService.getProducts().size() );
        modelAndView.addObject( "test", "mytest" );
        modelAndView.addObject( "count", productService.getProducts().size() );
        modelAndView.addObject( "products", productService.getProducts() );
        return modelAndView;
    }    
    
    @RequestMapping( "/add" )
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView( "product/add" );
        System.out.println( "Count:" + productService.getProducts().size() );
        modelAndView.addObject( "test", "mytest" );
        modelAndView.addObject( "count", productService.getProducts().size() );
        modelAndView.addObject( "products", productService.getProducts() );
        return modelAndView;
    }

    @RequestMapping( value = "/edit/{id}", method=RequestMethod.GET )
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView( "product/edit" );
        System.out.println( "Count:" + productService.getProducts().size() );
        modelAndView.addObject( "product", productService.getProduct(id) );
        return modelAndView;
    }    
    
    @RequestMapping( value = "/edit" )
    public ModelAndView edit(@ModelAttribute("product") Product product) {
        productService.updateProduct( product );
        return new ModelAndView("redirect:" + "list");
    }
}
