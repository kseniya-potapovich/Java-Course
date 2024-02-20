<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create user</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body style="text-align: center">
<c:choose>
    <c:when test="${createUser == true}">
        <h1 style="text-align: center">The user has been successfully added</h1>
    </c:when>
    <c:when test="${createUser == false}">
        <h1>The user has not been added</h1>
    </c:when>
</c:choose>
<br>
<form action="index.jsp">
    <input type="submit" value="continue" class="button">
</form>
</body>
</html>
