<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body style="text-align: center">
<c:choose>
    <c:when test="${deleteUser == true}">
        <h1>The user has been successfully deleted</h1>
    </c:when>
    <c:when test="${deleteUser == false}">
        <h1>The user has not been deleted</h1>
    </c:when>
</c:choose>
<br>
<form action="index.jsp">
    <input type="submit" value="continue" class="button">
</form>
</body>
</html>
