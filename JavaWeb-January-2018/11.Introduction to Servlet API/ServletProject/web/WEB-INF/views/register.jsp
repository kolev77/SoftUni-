<%--@elvariable id="username" type="java.lang.String"--%>
<%--@elvariable id="error" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Form</title>
</head>
<body>
<div style="color: red;">
    ${error}
</div>
<form method="post">
    <div>Username: <input type="text" value="${username}" name="username" placeholder="Enter your username..."/></div>
    <div>Password: <input type="text" name="password" placeholder="Enter your password..."/></div>
    <input type="submit" value="Register">
</form>

</body>
</html>
