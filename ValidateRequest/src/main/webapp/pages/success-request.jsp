<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>The application has been successfully saved</h1>
<p>Name: <%=request.getParameter("name")%>
</p>
<p>Email: <%=request.getParameter("email")%>
</p>
</body>
</html>
