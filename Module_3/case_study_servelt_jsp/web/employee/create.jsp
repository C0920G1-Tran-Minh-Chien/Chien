
<%--
  Created by IntelliJ IDEA.
  User: Thanh Long
  Date: 12/22/2020
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/bootstrap/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">Create Employee</h1>
    <form action="/employees" method="post">
        <small style="margin-left: 16%; font-size: 100%; color: red">
            <c:if test="${messageId != null}">${messageId}</c:if>
        </small>
        <div class="form-group row">
            <label class="col-2">ID </label>
            <input class="form-control col-8" type="text" name="id" value="EP-${id}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Name </label>
            <input class="form-control col-8" type="text" name="name" value="${name}" required>
        </div>
        <small style="margin-left: 16%; font-size: 100%; color: red"><c:if
                test="${messageBirthday != null}">${messageBirthday}</c:if></small>
        <div class="form-group row">
            <label class="col-2">Birthday </label>
            <input class="form-control col-8" type="date" name="birthday" value="${birthday}" required>
        </div>

        <small style="margin-left: 16%; font-size: 100%; color: red"><c:if
                test="${messageIdCard != null}">${messageIdCard}</c:if></small>
        <div class="form-group row">
            <label class="col-2">ID Card </label>
            <input class="form-control col-8" type="text" name="idCard" value="${idCard}" required>
        </div>
        <small style="margin-left: 16%; font-size: 100%; color: red"><c:if
                test="${messagePhone != null}">${messagePhone}</c:if></small>
        <div class="form-group row">
            <label class="col-2">Phone Number </label>
            <input value="(84)+" class="form-control col-8" type="text" name="phone" value="${phone}" required>
        </div>
        <small style="margin-left: 16%; font-size: 100%; color: red"><c:if
                test="${messageEmail != null}">${messageEmail}</c:if></small>
        <div class="form-group row">
            <label class="col-2">Email </label>
            <input class="form-control col-8" type="text" name="email" value="${email}" required>
        </div>

        <div class="form-group row">
            <label class="col-2">Address </label>
            <input class="form-control col-8" type="text" name="address" value="${address}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Salary </label>
            <input class="form-control col-8" type="text" name="salary" value="${salary}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Position </label>
            <input class="form-control col-8" type="text" name="position_id" value="${position_id}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Education_degree </label>
            <input class="form-control col-8" type="text" name="education_degree_id" value="${education_degree_id}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Division </label>
            <input class="form-control col-8" type="text" name="division_id" value="${division_id}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">User </label>
            <input class="form-control col-8" type="text" name="user_name" value="${user_name}"required >
        </div>
        <div class="float-right" style="margin-right: 174px">
            <button class="btn btn-success" name="action" value="create">Create</button>
            <a class="btn btn-danger" href="/employees">Back</a>
        </div>
    </form>
</div>
</body>
<script src="../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../assets/bootstrap/js/popper.min.js"></script>
<script src="../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.bundle.js"></script>
</html>
