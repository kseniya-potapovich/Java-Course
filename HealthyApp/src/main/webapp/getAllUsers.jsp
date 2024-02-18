<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h1 style="text-align: center">All users:</h1>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>
                <c:out value="${u.getId}"/>
            </td>
            <td>
                <c:out value="${u.getFirstName}"/>
            </td>
            <td>
                <c:out value="${u.getLastName}"/>
            </td>
            <td>
                <c:out value="${u.getEmail}"/>
            </td>
            <td>
                <c:out value="${u.getAge}"/>
            </td>
            <td>
                <c:out value="${u.getGender}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
