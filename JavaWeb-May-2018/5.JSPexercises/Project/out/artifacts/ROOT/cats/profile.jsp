<%@ page import="java.util.List" %>
<%@ page import="org.softuni.fdmc.data.models.Cat" %>
<%@ page import="org.softuni.fdmc.data.repos.CatRepository" %>
<%@ page import="org.softuni.fdmc.data.models.Role" %>
<%@ page import="org.softuni.fdmc.data.models.User" %>
<%@ page import="org.softuni.fdmc.data.repos.UserRepository" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<% String catName = request.getParameter("catName"); %>
<% Cat cat = ((CatRepository) application.getAttribute("cats")).getByName(catName);
    cat.setViews(cat.getViews() + 1);%>
<% if (cat != null) { %>
<h1>Cat - <%=cat.getName()%>
</h1>
<hr/>
<h3>Breed: <%= cat.getBreed()%>
</h3>
<h3>Color: <%= cat.getColor()%>
</h3>
<h3>Number Of Legs: <%= cat.getNumberOfLegs()%>
</h3>
<h3>Creator: <%= cat.getCreator().getUsername()%>
</h3>
<h3>Views: <%= cat.getViews()%>
</h3>
<hr/>
<% UserRepository r = (UserRepository) application.getAttribute("users");
    User user = r.getByUsername((String) session.getAttribute("username"));
    if (!user.getRole().equals(Role.ADMIN) && !cat.getOrdered()) { %>
<form method="post" action="/cats/order?catName=<%=catName%>">
    <button type="submit">Order</button>
</form>

<%}%>

<% } else { %>
<h1>Cat, with name <%=catName%> was not found.</h1>
<% } %>

<br/>
<a href="/cats/all">Back</a>
</body>
</html>
