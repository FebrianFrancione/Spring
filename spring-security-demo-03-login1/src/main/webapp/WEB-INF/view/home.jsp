<%--
  Created by IntelliJ IDEA.
  User: febri
  Date: 2021-02-21
  Time: 12:57 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Company Home page</title>
</head>
<body>
<h2> Welcome to Home Page</h2>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">

    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
