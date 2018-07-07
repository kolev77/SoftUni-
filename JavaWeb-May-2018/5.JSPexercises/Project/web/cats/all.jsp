<%@ page import="java.util.List" %>
<%@ page import="org.softuni.fdmc.data.models.Cat" %>
<%@ page import="org.softuni.fdmc.data.repos.CatRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>FDMC</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
    <h1>All Cats</h1>
    <hr />
    <% CatRepository cats = (CatRepository) application.getAttribute("cats"); %>
    <% for(Cat cat : cats.getAllCats()) { %>
        <h3>
            <a href="/cats/profile?catName=<%= cat.getName()%>"><%= cat.getName()%></a>
        </h3>
    <% } %>

    <br />
    <a href="/">Back to Home</a>
</body>
</html>
