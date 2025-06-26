<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Form</title>
</head>
<body>
    <h1>Product Form</h1>
    <form action="/product/save" method="post">
        <label for="id">Product ID:</label>
        <input type="text" id="id" name="id" value="${product.id}" required/><br/><br/>
        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" value="${product.name}" required/><br/><br/>
        <button type="submit">Save</button>
    </form>
</body>
</html>
