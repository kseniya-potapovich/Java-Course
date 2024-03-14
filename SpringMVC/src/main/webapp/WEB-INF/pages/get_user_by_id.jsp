<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Single user</title>
</head>
<body>
<h1>Your user's information</h1>
${user.id}
${user.username}
${user.age}
${user.changed}
${user.created}
${user.userPassword}
</body>
</html>
