<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Toshiba
  Date: 09.09.2022
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <meta charset="UTF-8">
    <%User user = (User) session.getAttribute("active");%>
</head>
<body>
<header>
    <h1>Հիմնական էջ</h1>
    <h2> Բարև <%=user.getName()%>
    </h2>
    <a href="/logout">Ելք</a>
</header>

<a href="/homePage">Գլխավոր</a>
<a href="/myItems">Իմ հայտարարությունները</a>
<a href="/myItems/add">Ավելացնել Հայտարարություն</a>


</body>
</html>
