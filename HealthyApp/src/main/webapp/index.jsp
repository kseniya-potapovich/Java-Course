<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body style="text-align: center">
<h1>Choose what you want to do</h1>
<form action="userId.jsp" method="get">
    <h3>If you want to get user by id click here</h3>
    <input type="submit" value="get user by id" class="button">
</form>
<form action="createUser.jsp" method="post">
    <h1>Else if you want to add user</h1>
    <input type="submit" value="add user" class="button">
</form>
<form action="deleteUserId.jsp" method="get">
    <h1>And you can delete user</h1>
    <input type="submit" value="delete user" class="button">
</form>
<form action="updateUser.jsp" method="get">
    <h1>Or you can update user</h1>
    <input type="submit" value="update user" class="button">
</form>
<form action="getAll" method="get">
    <h1>You can also view all users</h1>
    <input type="submit" value="get all users" class="button">
</form>
</body>
</html>
