<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOG IN</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");


%>
<%
    String msg = (String) request.getAttribute("msg");
%>


<%if (msg != null) {%>
<p style=" color: red "><%=msg%>
</p>
<% } %>
<h1> Ներմուծեք Ձեր Էլ․ հասցեն և գաղտնաբառը </h1><br>
<form action="/login" method="post">
    <input type="email" name="email" placeholder="Էլ հասցե"/><br>
    <input type="password" name="password" placeholder="Գաղտնաբառ"/><br>
    <input type="submit" value="Մուտք">
</form>
</body>
</html>
