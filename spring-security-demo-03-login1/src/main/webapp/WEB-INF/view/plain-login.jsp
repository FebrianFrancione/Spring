<%--
  Created by IntelliJ IDEA.
  User: febri
  Date: 2021-02-22
  Time: 7:35 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Custom Login Page</title>
</head>
<body>
<h3>My Custom Login Page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

    <c:if test="${param.error != null}">
        <i>Sorry! You entered invalid username/password</i>
    </c:if>

    <c:if test="${param.logout != null}">
        <div>
            You have been logged out
        </div>
    </c:if>

    <p>
        User's name: <input type="text" name="username"/>
    </p>
    <p>
        Password: <input type="password" name="password"/>
    </p>
    <input type="submit" value="Login"/>

<%--    mannuallyaddin tokens--%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</body>
</html>
