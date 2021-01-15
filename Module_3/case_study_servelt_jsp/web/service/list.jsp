<%--
  Created by IntelliJ IDEA.
  User: Thanh Long
  Date: 12/22/2020
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/bootstrap/datatables/css/dataTables.bootstrap4.min.css">
    <script src="../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
    <script src="../assets/bootstrap/js/popper.min.js"></script>
    <script src="../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.bundle.js"></script>
</head>
<body>
<div class="container-fluid">
    <h1 class="text-center mt-4 mb-5">List Service</h1>
    <div class="row">
        <div class="col-4">
            <a href="services?action=create" class="btn btn-outline-dark">Create new Service</a>
            <a href="/" class="btn btn-warning">Home</a>

        </div>
        <div class="col-8 form-group">
            <form class="row" action="/services" method="get">
                <button style="margin-left: 350px" class="btn btn-outline-info col-2" name="action" value="search">Search</button>
                <input type="text" name="name" class="form-control col-5">
            </form>
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Rent type</th>
            <th>Max people</th>
            <th>Standard room</th>
            <th>Description</th>
            <th>Number of floor</th>
            <th>Pool area</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${serviceList}" var="service">
            <tr>
                <td>${service.id}</td>
                <td>${service.name}</td>
                <td>${service.serviceType}</td>
                <td>${service.area}</td>
                <td>${service.cost}</td>
                <td>${service.rentType}</td>
                <td>${service.serviceMaxPeople}</td>
                <td>${service.standardRoom}</td>
                <td>${service.description}</td>
                <td>${service.numberOfFloor}</td>
                <td>${service.poolArea}</td>
                <td><a href="#" class="btn btn-outline-dark">Update</a></td>
                <td> <a href="#" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
