<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validate request</title>
</head>
<body>
<form action="../save-request" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
