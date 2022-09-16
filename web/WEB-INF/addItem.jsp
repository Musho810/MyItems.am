<%@ page import="model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Toshiba
  Date: 04.09.2022
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
<% List<Category> categoryList = (List<Category>) request.getAttribute("category");
%>
<h1> Ներմուծեք տվյալները:</h1>
<a href="/homePage">Գլխավոր</a>
<form action="/myItems/add" method="post" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="Անվանում"/><br>
    <input type="number" name="price" placeholder="Արժեք"/><br>
    Տեսակ
    <select name="category">
        <% for (Category category : categoryList) {
        %>
        <option value="<%=category.getId()%>"><%=category.getName()%>
        </option>
        <%
            }
        %>
    </select> <br>
    Նկար <br>
    <input type="file" name="picUrl"><br>
    <input type="submit" value="Ավելացնել">


</form>


</body>
</html>

