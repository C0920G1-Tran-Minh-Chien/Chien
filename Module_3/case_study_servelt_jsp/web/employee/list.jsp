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
    <title>Employee</title>
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/bootstrap/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid">
    <h1 class="text-center mt-4 mb-5">Employee List</h1>
    <div class="row">
        <div class="col-4">
            <a href="employees?action=create" class="btn btn-outline-dark">Create new Employee</a>
            <a href="/" class="btn btn-warning">Home</a>

        </div>
        <div class="col-8 form-group">
            <form class="row" action="/employees" method="get">
                <button style="margin-left: 350px" class="btn btn-outline-info col-2" name="action" value="search">Search</button>
                <input type="text" name="name" class="form-control col-5">
            </form>
        </div>
    </div>

    <table id="customer_table" class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>ID Card</th>
            <th>Phone number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Salary</th>
            <th>Position</th>
            <th>Education degree</th>
            <th>Division</th>
            <th>User</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.birthday}</td>
                <td>${employee.idCard}</td>
                <td>${employee.phone}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>${employee.salary}</td>
                <td>${employee.position}</td>
                <td>${employee.educationDegree}</td>
                <td>${employee.division}</td>
                <td>${employee.username}</td>
                <td><a href="#" class="btn btn-outline-dark" data-toggle="modal" data-target="#modalUpdate"
                       onclick="onUpdate('${employee.id}','${employee.name}','${employee.birthday}','${employee.idCard}',
                               '${employee.phone}','${employee.email}','${employee.address}','${employee.salary}','${employee.position}',
                               '${employee.educationDegree}','${employee.division}','${employee.username}')">Update</a>
                </td>
                <td><a href="#" class="btn btn-danger" data-toggle="modal" data-target="#modalDelete"
                       onclick="onDelete('${employee.id}')">Delete</a></td>
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
                <form action="/employees" method="post">
                    <input type="hidden" name="id" id="updateId">
                    <div class="form-group row">
                        <label class="col-4">Name </label>
                        <input class="form-control col-8" type="text" name="name" id="updateName" required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Birthday </label>
                        <input class="form-control col-8" type="date" name="birthday" id="updateBirthday" required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">ID Card </label>
                        <input class="form-control col-8" type="text" name="idCard" id="updateIdCard" required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Phone Number </label>
                        <input class="form-control col-8" type="text" name="phone" id="updatePhone" required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Email </label>
                        <input class="form-control col-8" type="text" name="email" id="updateEmail"required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Address </label>
                        <input class="form-control col-8" type="text" name="address" id="updateAddress"required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Salary </label>
                        <input class="form-control col-8" type="text" name="salary" id="updateSalary"required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Position </label>
                        <input class="form-control col-8" type="text" name="position_id" id="updatePosition"required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Education degree </label>
                        <input class="form-control col-8" type="text" name="education_degree_id" id="updateEdu"required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">Division </label>
                        <input class="form-control col-8" type="text" name="division_id" id="division_id"required>
                    </div>
                    <div class="form-group row">
                        <label class="col-4">User </label>
                        <input class="form-control col-8" type="text" name="user_name" id="user_name"required>
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
                <h5 class="modal-title">Delete Customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h2>Are you sure ?</h2>
                <form action="/employees" method="post">
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

<script>
    function onUpdate(id,name,birthday,idCard,phone,email,address,salary,position_id,education_degree_id,division,user_name) {
        document.getElementById("updateId").value = id;
        document.getElementById("updateName").value = name;
        document.getElementById("updateBirthday").value = birthday;
        document.getElementById("updateIdCard").value = idCard;
        document.getElementById("updatePhone").value = phone;
        document.getElementById("updateEmail").value = email;
        document.getElementById("updateAddress").value = address;
        document.getElementById("updateSalary").value = salary;
        document.getElementById("updatePosition").value = position_id;
        document.getElementById("updateEdu").value = education_degree_id;
        document.getElementById("division_id").value = division;
        document.getElementById("user_name").value = user_name;
    }
    function onDelete(id) {
        document.getElementById("deleteId").value = id;
    }
</script>
<script src="../assets/bootstrap/jquery/jquery-3.5.1.min.js"></script>
<script src="../assets/bootstrap/js/popper.min.js"></script>
<script src="../assets/bootstrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assets/bootstrap/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.bundle.js"></script>
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
</html>
