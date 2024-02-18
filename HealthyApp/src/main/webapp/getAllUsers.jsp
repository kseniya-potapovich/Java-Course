<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h1 style="text-align: center">All users:</h1>
<ul>
    <c:forEach var="u" items="${users}">
     <%--   ${u.getId}
        ${u.getFirstName}
        ${u.getLastName}
        ${u.getEmail}
        ${u.getAge}
        ${u.getGender}--%>
        <c:out value="${u}"/>
    </c:forEach>
</ul>
</body>
</html>
