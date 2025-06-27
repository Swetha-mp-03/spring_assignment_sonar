<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
    <title>Product List</title>
    <h1> Products</h1>
</head>
<body>
    <h1>Product List</h1>
    <ul>
        <c:forEach var="product" items="${products}">
            <li>${product.name} - ${product.price}</li>
        </c:forEach>
    </ul>
</body>
</html>
