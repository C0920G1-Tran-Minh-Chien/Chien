<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/24/2020
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/bootstrap/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">Create Contract</h1>
    <form action="/contracts" method="post">
        <div class="form-group row">
            <label class="col-2">ID</label>
            <input class="form-control col-8" type="text" name="id" value="${id}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Start Date</label>
            <input class="form-control col-8" type="date" name="startDate" value="${startDate}" >
        </div>
        <div class="form-group row">
            <label class="col-2">End Date</label>
            <input class="form-control col-8" type="date" name="endDate" value="${endDate}">
        </div>
        <div class="form-group row">
            <label class="col-2">Deposit</label>
            <input class="form-control col-8" type="text" name="deposit" value="${deposit}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Total Money</label>
            <input class="form-control col-8" type="text" name="totalMoney" value="${totalMoney}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Customer</label>
            <select class="col-8 form-control" name="customer">
                <c:forEach items="${customerList}" var="customer">
                    <option value="${customer.id.substring(3)}">${customer.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-2">Employee</label>
            <select class="col-8 form-control" name="employee">
                <c:forEach items="${employeeList}" var="employee">
                    <option value="${employee.id.substring(3)}">${employee.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-2">Service</label>
            <select class="col-8 form-control" name="service">
                <c:forEach items="${serviceList}" var="service">
                    <option value="${service.id.substring(3)}">${service.name}</option>
                </c:forEach>
            </select>
        </div>


        <div class="float-right" style="margin-right: 174px">
            <button class="btn btn-success" name="action" value="create">Create</button>
            <a class="btn btn-danger" href="contracts">Back</a>
        </div>

    </form>
    <p style="color: red; margin-left: 16%"><c:if test="${message != null}">${message}</c:if></p>
</div>
<script src="../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../assets/bootstrap/js/popper.min.js"></script>
<script src="../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>