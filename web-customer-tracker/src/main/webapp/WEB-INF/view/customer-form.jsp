<%--
  Created by IntelliJ IDEA.
  User: febri
  Date: 2021-02-17
  Time: 11:07 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Save Customer</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action ="saveCustomer" modelAttribute="customer" method = "POST">


<%--            associate data to form field--%>
            <form:hidden path="id"/>

            <table>
                <tbody>

                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>


                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>


                <tr>
                    <td><label>email:</label></td>
                    <td><form:input path="email"/></td>
                </tr>


                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>

                </tbody>
            </table>
        </form:form>


    </div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
    </p>
</div>
</body>
</html>
