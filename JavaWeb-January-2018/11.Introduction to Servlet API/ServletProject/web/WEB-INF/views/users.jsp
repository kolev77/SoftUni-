<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="users" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <thead>
    <th>Username</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user}</td>
        </tr>
    </c:forEach>
    </tbody>


</table>

</body>
</html>
