<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>change user result</title>
    <link rel="stylesheet" type="text/css" href="property/style.css">
</head>
<body style="text-align: center">
<c:choose>
    <c:when test="${updateUser == true}">
        <h1>The user has been successfully updated</h1>
        <c:out value="${updateUser}"/>
    </c:when>
    <c:when test="${updateUser == false}">
        <h1>The user cannot be updated</h1>
    </c:when>
</c:choose>
<br>
<form action="index.jsp">
    <input type="submit" value="continue" class="button">
</form>
</body>
</html>
