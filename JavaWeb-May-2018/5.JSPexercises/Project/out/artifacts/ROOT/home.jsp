<%@ page import="org.softuni.fdmc.data.repos.UserRepository" %>
<%@ page import="org.softuni.fdmc.data.models.User" %>
<%@ page import="org.softuni.fdmc.data.models.Role" %>
<%@ page import="org.softuni.fdmc.data.models.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<h1>Welcome to Fluffy Duffy Munchkin Cats!</h1>
<%=session.getAttribute("username") == null
        ? "<h3>Login if you have an account, or Register if you don't!</h3>"
        : "<h3>Navigate through the application using the links below!</h3>"
%>
<hr/>
<% if (session.getAttribute("username") == null) { %>
<a href="/users/login">Login</a>
<br/>
<a href="/users/register">Register</a>
<% } else { %>
<% UserRepository r = (UserRepository) application.getAttribute("users");
    User user = r.getByUsername((String) session.getAttribute("username"));
    if (user.getRole().equals(Role.ADMIN)) { %>
<a href="/cats/create">Create Cat</a>
<br/>
<h1>All orders </h1>
<% List<Order> orders = (List<Order>) application.getAttribute("allOrders");
    if (orders != null) {
        for (Order order : orders) { %>
<hr/>
<h1><%=order.getClient().getUsername()%>
</h1>
<h1><%=order.getCat().getName()%>
</h1>
<h1><%=order.getMadeOn()%>
</h1>
<hr/>
<%
        }
    }
} else {
%>
<h1>ORDERS : </h1>
<% List<Order> orders = user.getOrders();
    if (!orders.isEmpty()) {
        for (Order order : orders) { %>
<h3>Cat name : <%=order.getCat().getName()%>
</h3>
<h3>Made on : <%=order.getMadeOn().toString().split("T")[0]%>
</h3>

<%
            }
        }
    }
%>
<a href="/cats/all">All Cats</a>
<br/>
<a href="/users/logout">Logout</a>
<% } %>
</body>
</html>
