<%@ page import="org.softuni.javaeeblock.models.Tube" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Rostislav Kolev
  Date: 02-Jul-18
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JAVA EE BLOCK</title>
</head>
<body>
<h1>Here are the all tubes</h1>

<%
    List<Tube> allTubes = new ArrayList<Tube>(){{
       add(new Tube("Feel it Steel","Some cool new song...",5412,"Goshi"));
       add(new Tube("NO more","Some shitty new song...",25,"Moshi"));
       add(new Tube("Break ya neck","Some fun new song...",512,"Azis"));
       add(new Tube("NO NO NO","Some old new song...",55,"Petio"));
    }};
%>
<hr/>

<%for (Tube allTube : allTubes){ %>
   <h1><a href="/tubes/details?title="<%= allTube.getTitle() %>><%=allTube.getTitle()%></a></h1>

<% }%>

</body>
</html>
