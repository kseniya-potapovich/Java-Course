<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All users</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body style="text-align: center">
<h1 style="text-align: center">All users:</h1>
<table style="text-align: center">
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
                ${u.getId()}
            </td>
            <td>
                ${u.getFirstName()}
            </td>
            <td>
                ${u.getLastName()}
            </td>
            <td>
                ${u.getEmail()}
            </td>
            <td>
                ${u.getAge()}
            </td>
            <td>
                ${u.getGender()}
            </td>
        </tr>
    </c:forEach>
</table>
<form action="index.jsp">
    <input type="submit" value="continue" class="button">
</form>
</body>
</html>
