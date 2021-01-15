<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/14/2020
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/discount">
    <label>Status: </label><br/>
    <input type="text" name="status" placeholder="Status" /><br/>
    <label>Price: </label><br/>
    <input type="text" name="price" placeholder="Price" /><br/>
    <label>Discount Percent</label> <br/>
    <input type="number" name="discount"><br>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>
