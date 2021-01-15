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
<div class="container-fluid">
    <h1 class="text-center mt-4 mb-5">List Contract</h1>
    <div class="row">
        <div class="col-4">
            <a href="contracts?action=create" class="btn btn-outline-dark">Create new Contract</a>
            <a href="/contract-details" class="btn btn-secondary">Contract-Details</a>
            <a href="/" class="btn btn-warning">Home</a>

        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Start date</th>
            <th>End date</th>
            <th>Deposit</th>
            <th>Total money</th>
            <th>Customer</th>
            <th>Employee</th>
            <th>Service</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contractList}" var="contract">
            <tr>
                <td>${contract.id}</td>
                <td>${contract.startDate}</td>
                <td>${contract.endDate}</td>
                <td>${contract.deposit}</td>
                <td>${contract.totalMoney}</td>
                <td>${contract.customer}</td>
                <td>${contract.employee}</td>
                <td>${contract.service}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../assets/bootstrap/js/popper.min.js"></script>
<script src="../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>
