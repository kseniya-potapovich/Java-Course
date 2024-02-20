<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get user by ID</title>
    <link rel="stylesheet" type="text/css" href="property/style.css">
</head>
<body style="text-align: center">
<h1>Your user:</h1>
<c:out value="${user}"/>
<br>
<form action="index.jsp">
    <input type="submit" value="continue" class="button">
</form>
</body>
</html>
