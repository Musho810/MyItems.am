<%@ page import="model.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Toshiba
  Date: 13.09.2022
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Items</title>
</head>
<body>

<%
    List<Item> myitemlist = (List<Item>) request.getAttribute("myItems");

%>

<table border="1">
    <tr>
        <th> id</th>
        <th> Նկար</th>
        <th> Անվանում</th>
        <th> Արժեք</th>
        <th> Տեսակ</th>


        <th></th>
    </tr>
    <% for (Item item : myitemlist) {
    %>
    <tr>
        <td><%=item.getId()%>
        </td>
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
        <td><%=item.getCategoryId()%>
        </td>


        <td>
            <a href="/myItems/delete?itemId=<%=item.getId()%>">Ջնջել</a>
            <a href="/myItems/edit?itemId=<%=item.getId()%>">Խմբագրել</a>
        </td>

    </tr>
    <%
        }
    %>

</table>


</body>
</html>
