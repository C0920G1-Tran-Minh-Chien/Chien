<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/25/2020
  Time: 9:39 AM
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
            <a href="contract-details?action=create" class="btn btn-success">Create new Contract</a>
            <a href="/contracts" class="btn btn-secondary">Contract</a>
            <a href="/" class="btn btn-warning">Home</a>

        </div>
        <div class="col-8 form-group">
            <form class="row" action="/contract-details" method="get">
                <button style="margin-left: 350px" class="btn btn-primary col-2" name="action" value="search">Search</button>
                <input type="text" name="name" class="form-control col-5">
            </form>
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Contract Id</th>
            <th>Attach Service Id</th>
            <th>Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contractDetailList}" var="contract">
            <tr>
                <td>${contract.id}</td>
                <td>${contract.contractId}</td>
                <td>${contract.attachService}</td>
                <td>${contract.quantity}</td>
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
