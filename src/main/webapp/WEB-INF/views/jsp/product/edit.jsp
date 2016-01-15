<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <h2>Edit product</h2>
        <form:form action="/etnshop/product/edit" commandName="product">
            <table class="table">
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td><form:input path="id"  readonly="true" value="${product.id}"/></td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td><form:input path="name" value="${product.name}"/></td>
                    </tr>
                    <tr>
                        <th>Serial number</th>
                        <td><form:input path="serialNumber" value="${product.serialNumber}"/></td>
                    </tr>
                    <tr>
                        <td><a class="btn"  href="/etnshop/product/list" role="button">cancel</a></td>
                        <td><input class="btn" type="submit" value="confirm"/></td>
                    </tr>
                </tbody>
            </table>

        </form:form>

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