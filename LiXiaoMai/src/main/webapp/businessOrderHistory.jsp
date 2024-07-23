<%@ page import="com.example.lixiaomai.backend.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/24
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/businessOrderHistory.css">
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息设置</title>
</head>
<body>
<h2>订单管理</h2>

<div class="account">
    <p>用户类型：${userType} 用户姓名：${name}</p>
</div>
<table>
    <thead>
    <tr>
        <th>订单ID</th>
        <th>店铺名称</th>
        <th>商品名称</th>
        <th>商品数量</th>
        <th>订单时间</th>
        <th>订单总价</th>
    </tr>
    <%
        List<Order> list = (List<Order>) request.getAttribute("orderList");
        Integer totalPage = (Integer) request.getAttribute("totalPages");
        Integer currentPage = (Integer) request.getAttribute("currentPage");
        Map<Integer,List<String>> productMap = (Map<Integer, List<String>>) request.getAttribute("productMap");

        if (list != null && list.size() > 0){
            for (Order order : list){
                int id = order.getId();
                String sName = order.getSName();
                List<Integer> goodSum = order.getGoodsNum();
                List<String> productName = productMap.get(id);
                Timestamp startTime = order.getStartTime();
                double total = order.getTotal();
    %>
    <tr>
        <td><a href="businessOrder?id=<%=id%>"><%=id%></a></td>
        <td><%=sName%></td>
        <td><%=productName%></td>
        <td><%=goodSum%></td>
        <td><%=startTime%></td>
        <td><%=total%></td>
    </tr>

    <%
        }}
    else{
    %>
    <p>还没有订单哦</p>
    <%

        }
    %>

    </thead>

</table>
<%
    if (totalPage != null && currentPage != null && totalPage > 1) {
%>
<nav>
    <ul>
        <%
            for (int i = 1; i <= totalPage; i++) {
                if (i == currentPage) {
        %>
        <li><strong><%= i %></strong></li>
        <%
        } else {
        %>
        <li><a href="businessOrderHistory?page=<%= i %>"><%= i %></a></li>
        <%
            }
            if (i < totalPage) {
        %>
        <li>&nbsp;|&nbsp;</li>
        <%
                }
            }
        %>
    </ul>
</nav>
<%
    }
%>
<button id="backToIndex"><a href="exhibit">返回主页</a></button>
</body>
</html>