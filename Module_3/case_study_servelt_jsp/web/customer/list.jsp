<%--
  Created by IntelliJ IDEA.
  User: Thanh Long
  Date: 12/22/2020
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/bootstrap/datatables/css/dataTables.bootstrap4.min.css">
    <style>
        body{
            background:wheat;
        }

        @-webkit-keyframes snowflakes-fall{0%{top:-10%}100%{top:100%}}@-webkit-keyframes snowflakes-shake{0%{-webkit-transform:translateX(0px);transform:translateX(0px)}50%{-webkit-transform:translateX(80px);transform:translateX(80px)}100%{-webkit-transform:translateX(0px);transform:translateX(0px)}}@keyframes snowflakes-fall{0%{top:-10%}100%{top:100%}}@keyframes snowflakes-shake{0%{transform:translateX(0px)}50%{transform:translateX(80px)}100%{transform:translateX(0px)}}.snowflake{position:fixed;top:-10%;z-index:9999;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:default;-webkit-animation-name:snowflakes-fall,snowflakes-shake;-webkit-animation-duration:10s,3s;-webkit-animation-timing-function:linear,ease-in-out;-webkit-animation-iteration-count:infinite,infinite;-webkit-animation-play-state:running,running;animation-name:snowflakes-fall,snowflakes-shake;animation-duration:10s,3s;animation-timing-function:linear,ease-in-out;animation-iteration-count:infinite,infinite;animation-play-state:running,running}.snowflake:nth-of-type(0){left:1%;-webkit-animation-delay:0s,0s;animation-delay:0s,0s}.snowflake:nth-of-type(1){left:10%;-webkit-animation-delay:1s,1s;animation-delay:1s,1s}.snowflake:nth-of-type(2){left:20%;-webkit-animation-delay:6s,.5s;animation-delay:6s,.5s}.snowflake:nth-of-type(3){left:30%;-webkit-animation-delay:4s,2s;animation-delay:4s,2s}.snowflake:nth-of-type(4){left:40%;-webkit-animation-delay:2s,2s;animation-delay:2s,2s}.snowflake:nth-of-type(5){left:50%;-webkit-animation-delay:8s,3s;animation-delay:8s,3s}.snowflake:nth-of-type(6){left:60%;-webkit-animation-delay:6s,2s;animation-delay:6s,2s}.snowflake:nth-of-type(7){left:70%;-webkit-animation-delay:2.5s,1s;animation-delay:2.5s,1s}.snowflake:nth-of-type(8){left:80%;-webkit-animation-delay:1s,0s;animation-delay:1s,0s}.snowflake:nth-of-type(9){left:90%;-webkit-animation-delay:3s,1.5s;animation-delay:3s,1.5s}
        /* Demo Purpose Only*/
        .demo {
            font-family: 'Raleway', sans-serif;
            color:#fff;
            display: block;
            margin: 0 auto;
            padding: 15px 0;
            text-align: center;
        }
        .demo a{
            font-family: 'Raleway', sans-serif;
            color: #000;
        }
    </style>

</head>
<body>
<div class="container-fluid" >
    <%
        String username = (String)session.getAttribute("tendangnhap");
        if (session != null){
            out.print("chào" + username);
        } else {
            out.print("chào khách ghé thăm");
        }
    %>
    <h1 class="text-center mt-4 mb-5">List Customer</h1>
    <div class="row">
        <div class="col-4">
            <a href="customers?action=create" class="btn btn-dark">Create new Product</a>
            <a href="/" class="btn btn-outline-dark">Home</a>
        </div>

        <div class="form-group col-8">
            <form class="row" action="/customers" method="get">
                <button style="margin-left: 350px" type="submit" class="btn btn-outline-info col-2" name="action"
                        value="find">Search
                </button>
                <input type="text" class="form-control col-5" placeholder="Name" name="name">
            </form>
        </div>
    </div>
    <table id="customer_table" class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Gender</th>
            <th>ID Card</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Customer type</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>${customer.gender}</td>
                <td>${customer.idCard}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>${customer.customerType}</td>
                <td><a href="#" class="btn btn-outline-dark" data-toggle="modal" data-target="#modalUpdate"
                       onclick="onUpdate('${customer.id}','${customer.name}','${customer.birthday}','${customer.gender}','${customer.idCard}'
                               ,'${customer.phone}','${customer.email}','${customer.address}','${customer.customerType}')">Update</a>
                </td>
                <td><a href="#" class="btn btn-danger" data-toggle="modal" data-target="#modalDelete"
                       onclick="onDelete('${customer.id}')">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--UPDATE--%>
<div class="modal fade" id="modalUpdate" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal update</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="/customers" method="post">
                    <input type="hidden" name="id" id="updateId">
                    <div class="form-group row">
                        <label class="col-4">Name </label>
                        <input class="form-control col-8" type="text" name="name" id="updateName">
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Birthday </label>
                        <input class="form-control col-8" type="date" name="birthday" id="updateBirthday">
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Gender</label>
                        <select class="col-8 form-control" name="gender" id="updateGender">
                            <option value="0">Nam</option>
                            <option value="1">Nữ</option>
                        </select>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">ID Card </label>
                        <input class="form-control col-8" type="text" name="idCard" id="updateIdCard">
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Phone Number </label>
                        <input class="form-control col-8" type="text" name="phone" id="updatePhone">
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Email </label>
                        <input class="form-control col-8" type="text" name="email" id="updateEmail">
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Address </label>
                        <input class="form-control col-8" type="text" name="address" id="updateAddress">
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Customer Type</label>
                        <select class="col-8 form-control" name="customerType" id="updateCustomerType">
                            <c:forEach var="customerType" items="${customerTypeList}" >
                                <option value="${customerType.id}" >${customerType.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" name="action" value="update">Save</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<%--DELETE--%>
<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h2>Are you sure ?</h2>
                <form action="/customers" method="post">
                    <input type="hidden" name="id" id="deleteId">
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger" name="action" value="delete">Delete</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

<script src="../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../assets/bootstrap/js/popper.min.js"></script>
<script src="../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.bundle.js"></script>

<link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/bootstrap/datatables/css/dataTables.bootstrap4.min.css">

<script>
    $(document).ready(function () {
        $('#customer_table').dataTable({
            "dom" : 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>

<script>
    function onUpdate(id, name, birthday, gender, idCard, phone, email, address, customerType) {
        document.getElementById("updateId").value = id;
        document.getElementById("updateName").value = name;
        document.getElementById("updateBirthday").value = birthday;
        if (gender === "Nam") {
            gender = 0;
        } else {
            gender = 1;
        }
        document.getElementById("updateGender").value = gender;
        document.getElementById("updateIdCard").value = idCard;
        document.getElementById("updatePhone").value = phone;
        document.getElementById("updateEmail").value = email;
        document.getElementById("updateAddress").value = address;
        switch (customerType) {
            case "Member":
                customerType = 1;
                break;
            case "Sliver":
                customerType = 2;
                break;
            case "Gold":
                customerType = 3;
                break;
            case "Platinum":
                customerType = 4;
                break;
            case "Diamond":
                customerType = 5;
                break;
        }
        document.getElementById("updateCustomerType").value = customerType;
    }

    function onDelete(id) {
        document.getElementById("deleteId").value = id;
    }

</script>
</html>
