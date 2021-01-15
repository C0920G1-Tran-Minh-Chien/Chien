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
<div class="container mt-4">
    <h1 class="text-center">Create New Service</h1>
    <form action="/services" method="post">
        <div class="form-group row">
            <label class="col-2">ID </label>
            <input class="form-control col-8" type="text" name="id" value="SV-">
        </div>
        <div class="form-group row">
            <label class="col-2">Name </label>
            <input class="form-control col-8" type="text" name="name">
        </div>
        <div class="form-group row">
            <label class="col-2">Service type</label>
            <select class="col-8 form-control" name="serviceType">
                <option value="1">Villa</option>
                <option value="2">House</option>
                <option value="3">Room</option>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-2">Area </label>
            <input class="form-control col-8" type="text" name="area">
        </div>
        <div class="form-group row">
            <label class="col-2">Cost </label>
            <input class="form-control col-8" type="text" name="cost">
        </div>
        <div class="form-group row">
            <label class="col-2">Rent type</label>
            <select class="col-8 form-control" name="rentType">
                <option value="1">Giờ</option>
                <option value="2">Ngày</option>
                <option value="3">Tuần</option>
                <option value="4">Tháng</option>
                <option value="5">Năm</option>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-2">Max people </label>
            <input class="form-control col-8" type="text" name="maxPeople">
        </div>
        <div class="form-group row">
            <label class="col-2">Standard room </label>
            <input class="form-control col-8" type="text" name="standardRoom">
        </div>
        <div class="form-group row">
            <label class="col-2">Description </label>
            <input class="form-control col-8" type="text" name="description">
        </div>
        <div class="form-group row">
            <label class="col-2">Number of floor </label>
            <input class="form-control col-8" type="text" name="numberOfFloor">
        </div>
        <div class="form-group row">
            <label class="col-2">Pool area </label>
            <input class="form-control col-8" type="text" name="poolArea">
        </div>

        <div class="float-right" style="margin-right: 174px">
            <button class="btn btn-success" name="action" value="create">Create</button>
            <a class="btn btn-danger" href="/services">Back</a>
        </div>
    </form>
    <p style="color: red; margin-left: 16%" ><c:if test="${message != null}">${message}</c:if></p>
</div>
</body>
</html>
