<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/16/2020
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="${pageContext.request.contextPath}/customer?action=create">Create new customer</a>
</p>
<input type="text" name="search">
<button type="submit" name="subName">Find</button>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["customer"]}' var="customer">
        <tr>
            <td><a href="${pageContext.request.contextPath}/customer?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="${pageContext.request.contextPath}/customer?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="${pageContext.request.contextPath}/customer?action=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
