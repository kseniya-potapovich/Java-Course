<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <link rel="stylesheet" type="text/css" href="property/style.css">
</head>
<body style="text-align: center">
<form action="changeUser" method="get">
    ID: <input type="text" name="id"><br>
    First name: <input type="text" name="first_name"><br>
    Last name: <input type="text" name="last_name"><br>
    Email: <input type="text" name="email"><br>
    Age: <input type="text" name="age"><br>
    Gender: <input type="text" name="gender"><br>
    <input type="submit" value="Update user">
</form>
<%--<form action="index.jsp">
    <input type="submit" value="continue" class="button">
</form>--%>
</body>
</html>
