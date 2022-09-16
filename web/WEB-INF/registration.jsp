<%--
  Created by IntelliJ IDEA.
  User: Toshiba
  Date: 09.09.2022
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Գրանցում</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
%>

<%if (msg != null) {%>
<p style=" color: red "><%=msg%>
</p>
<% } %>

<form action="/registration" method="post">
    <input type="text" name="name" placeholder="Անուն"/><br>
    <input type="text" name="surname" placeholder="Ազգանուն"/><br>
    <input type="email" name="email" placeholder="Էլ․ հասցե"/><br>
    <input type="password" name="password" placeholder="Գաղտնաբառ"/><br>
    <input type="text" name="phone" placeholder="Հեռախոսահամր"/><br>

    <br>

    <input type="submit" value="Գրանցում">


</form>

</body>
</html>
