<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get all Users</title>
</head>
<body>
<c:forEach items="${users}" var="user">
<tr>
    <td>${user.id}</td>
    <td>${user.username}</td>
    <td>${user.age}</td>
    <td>${user.changed}</td>
    <td>${user.created}</td>
    <td>${user.userPassword}</td>
</tr>
</c:forEach>
</body>
</html>
