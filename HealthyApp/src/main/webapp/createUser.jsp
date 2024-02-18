<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 2/18/2024
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<form action="createUser" method="post">
    ID: <input type="text" name="id"><br>
    First name: <input type="text" name="first_name"><br>
    Last name: <input type="text" name="last_name"><br>
    Email: <input type="text" name="email"><br>
    Age: <input type="text" name="age"><br>
    Gender: <input type="text" name="gender"><br>
    <input type="submit" value="create user">
</form>
</body>
</html>
