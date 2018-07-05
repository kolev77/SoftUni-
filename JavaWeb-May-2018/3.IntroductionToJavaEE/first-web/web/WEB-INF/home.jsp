<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home JSP</title>
</head>
<body style="color: red;">
<h1>HoME JSP here</h1>
<%
    for (int i = 0; i < 5; i++) {
        System.out.println("<h1>GOSHIII" + i + "</h1>");
    }
%>
</body>
</html>
