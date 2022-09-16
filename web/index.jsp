<%@ page import="manager.CategoryManager" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Category" %>
<%@ page import="model.Item" %><%--
  Created by IntelliJ IDEA.
  User: Toshiba
  Date: 04.09.2022
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% CategoryManager categoryManager = new CategoryManager();
    List<Category> categoryList = categoryManager.getAll();%>
<head>
    <title>My Items</title>
    <meta charset="UTF-8">
</head>
<body>
<header>
    <a href="/login"> ՄՈՒՏՔ</a>
    <br>
    <a href="/registration"> ԳՐԱՆՑՈՒՄ</a>

</header>
<a href="/items/show?categoryId=0"> Գլխավոր </a>
<% for (Category category : categoryList) {%>
<a href="/items/show?categoryId=<%=category.getId()%>"><%=category.getName()%>
</a>
<%}%>
<% List<Item> itemslist = (List<Item>) request.getAttribute("itemslist");
    if (itemslist == null) {%>

<%} else { %>
<table border="1">
    <tr>
        <th> Նկար</th>
        <th> Անվանում</th>
        <th> Արժեք</th>
    </tr>
    <% for (Item item : itemslist) {
    %>
    <tr>
        <td>
            <% if (item.getPicUrl() == null || item.getPicUrl().length() == 0) { %>
            <img src="/image/default.jpg" width="50">
            <% } else { %>
            <img src="/getItemImage?picUrl=<%=item.getPicUrl()%>" width="50">
            <% } %>
        </td>
        <td><%=item.getTitle()%>
        </td>
        <td><%=item.getPrice()%>
        </td>

    </tr>
    <%
        }
    %>
    <%
        }
    %>

</table>

</body>
</html>
