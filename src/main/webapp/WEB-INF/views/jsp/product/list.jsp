<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>etnShop</title>

        <spring:url value="/resources/core/css/hello.css" var="coreCss" />
        <spring:url value="/resources/core/css/bootstrap.min.css"
                    var="bootstrapCss" />
        <link href="${bootstrapCss}" rel="stylesheet" />
        <link href="${coreCss}" rel="stylesheet" />
    </head>

    <div class="container">
        <div id="search" style="float: right;">
            <form action="/etnshop/product/list" method="get">
                <input type="text" name="search"/>
                <input type="submit" value="search"/>
            </form>
        </div>
        <h2>Products</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Serial number</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.serialNumber}</td>
                        <td><a class="btn"  href="/etnshop/product/edit/${product.id}" role="button">Edit</a></td>
                    </tr>	
                </c:forEach>
            </tbody>
        </table>
        
        <a class="btn btn-secondary btn-lg"  href="/etnshop/product/add" role="button">Add product</a>
        
        <hr>
        <footer>
            <p>&copy; Etnetera a.s. 2015</p>
        </footer>
    </div>

    <spring:url value="/resources/core/css/bootstrap.min.js"
                var="bootstrapJs" />

    <script src="${bootstrapJs}"></script>
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>