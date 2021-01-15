<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/25/2020
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <form action="/contract-details" method="post">
        <div class="form-group row">
            <label class="col-2">ID</label>
            <input class="form-control col-8" type="text" name="id" value="${id}" required>
        </div>
        <div class="form-group row">
            <label class="col-2">Contract Id</label>
            <select class="col-8 form-control" name="contract">
                <c:forEach items="${contractList}" var="contract">
                    <option value="${contract.id}">${contract.id}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-2">Attach Service</label>
            <select class="col-8 form-control" name="attachContract">
                <c:forEach items="${attachContracts}" var="attach">
                    <option value="${attach.id}">${attach.id}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-2">Quantity</label>
            <input class="form-control col-8" type="text" name="quantity" value="${quantity}" required>
        </div>
        <div class="float-right" style="margin-right: 174px">
            <button class="btn btn-success" name="action" value="create">Create</button>
            <a class="btn btn-danger" href="contracts">Back</a>
        </div>

    </form>
</div>
<script src="../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../assets/bootstrap/js/popper.min.js"></script>
<script src="../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>
