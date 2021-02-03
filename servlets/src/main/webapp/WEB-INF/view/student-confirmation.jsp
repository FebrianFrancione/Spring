<%--
  Created by IntelliJ IDEA.
  User: febri
  Date: 02/02/2021
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br>

Country: ${student.country}

<br>

Favorite Language: ${student.favoriteLanguage}

<br>

Operating Systems:

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li> ${temp} </li>
    </c:forEach>

</ul>

</body>
</html>
