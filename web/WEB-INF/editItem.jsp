<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Category" %><%--
  Created by IntelliJ IDEA.
  User: Toshiba
  Date: 16.09.2022
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Item</title>
</head>
<body>

<% Item item = (Item) request.getAttribute("itemEdit");
    List<Category> categoryList = (List<Category>) request.getAttribute("category");
%>

<h1> Please edit items data</h1>
<a href="/homePage">Գլխավոր</a>
<form action="/myItems/edit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="itemId" value="<%=item.getId()%>"/>
    <input type="text" name="title" value="<%=item.getTitle()%>"/><br>
    <input type="number" name="price" value="<%=item.getPrice()%>"/><br>
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
    <input type="submit" value="Պահպանել">


</form>


</body>
</html>
