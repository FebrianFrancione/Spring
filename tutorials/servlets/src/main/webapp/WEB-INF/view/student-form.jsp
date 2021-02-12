<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: febri
  Date: 02/02/2021
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

    First Name: <form:input path="firstName" ></form:input>

    <br>

    Last Name:  <form:input path="lastName" ></form:input>

    <br>

    Country:
    <form:select path="country">

        <form:options items="${student.countryOptions}"></form:options>

    </form:select>


    <br>
    Favorite Language:
    Java <form:radiobutton path="favoriteLanguage" value="Java"></form:radiobutton>
    C# <form:radiobutton path="favoriteLanguage" value="C#"></form:radiobutton>
    RUBY <form:radiobutton path="favoriteLanguage" value="RUBY"></form:radiobutton>
    PHP <form:radiobutton path="favoriteLanguage" value="PHP"></form:radiobutton>

<br>

    Operating Systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"></form:checkbox>
    Windows <form:checkbox path="operatingSystems" value="Windows"></form:checkbox>
    Mac <form:checkbox path="operatingSystems" value="Mac"></form:checkbox>
    <br>
    <input type="submit" value="submit">
</form:form>
</body>
</html>
