<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 1/5/2021
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/student/edit" method="post" modelAttribute="student">
    <div>
        <label>ID:</label>
        <form:input type="text" name="id"  path="id"/>
    </div>
    <div>
        <label>Languages:</label>
<%--        <form:checkboxes path="languages" items="${languageList}" />--%>
        <form:select path="languages">
                <c:forEach items="${student.languages}" var="lang">
                    <form:option value="${lang}">${lang}</form:option>
                </c:forEach>
        </form:select>
    </div>
    <div>
        <label>Size:</label>
        <form:select path="gender" >
            <form:option value="0">25</form:option>
            <form:option value="1">50</form:option>
            <form:option value="2">Full</form:option>
        </form:select>
    </div>

    <div>
        <label>Signature:</label>
        <form:textarea rows="5" type="text" name="id"  path="name"/>
    </div>
    <input type="submit" value="Edit">
</form:form>

</body>
</html>
