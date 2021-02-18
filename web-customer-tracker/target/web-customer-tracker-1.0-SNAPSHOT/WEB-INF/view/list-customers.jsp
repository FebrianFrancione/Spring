<%--
  Created by IntelliJ IDEA.
  User: febri
  Date: 2021-02-12
  Time: 9:25 p.m.
  To change this template use File | Settings | File Templates.
  
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List customers</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action ="saveCustomer" modelAttribute="customer" method = "POST">
            <table>
                <tbody>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
    </div>
</div>
</body>
</html>
