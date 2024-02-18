<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h1 style="text-align: center">All users:</h1>
<c:forEach var="u" items="${users}">
    <c:out value="${u}"/>
</c:forEach>
</body>
</html>