<%--
  Created by IntelliJ IDEA.
  User: febri
  Date: 03/02/2021
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer registration form</title>

    <style>
        .error{color:red}
    </style>
</head>
<body>

<form:form action="processForm" modelAttribute="customer">
    First name: <form:input path="firstName"></form:input>
    <br>
    last name (*): <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"></form:errors>

    <br>
    Free passes: <form:input path="freePasses"></form:input>
    <form:errors path="freePasses" cssClass="error"></form:errors>

    <br>
    Postal Code: <form:input path="postalCode"></form:input>
    <form:errors path="postalCode" cssClass="error"></form:errors>

    <br>

    Course Code: <form:input path="courseCode"></form:input>
    <form:errors path="courseCode" cssClass="error"></form:errors>

    <br>

    <input type="submit" value="Submit">
</form:form>
</body>
</html>
