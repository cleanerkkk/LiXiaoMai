<%@ page import="com.example.lixiaomai.backend.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.sql.Time" %>
<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/20
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/profileOrder.css">
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
        <th>商家ID</th>
        <th>店铺名称</th>
        <th>商品名称</th>
        <th>商品数量</th>
        <th>下订单时间</th>
        <th>订单总价</th>
    </tr>
        <%
            List<Order> list = (List<Order>) request.getAttribute("orderList");
            Integer totalPage = (Integer) request.getAttribute("totalPages");
            Integer currentPage = (Integer) request.getAttribute("currentPage");

            if (list != null && list.size() > 0){
            for (Order order : list){
                int id = order.getId();
                int sId = order.getSId();
                String sName = order.getSName();
                List<Integer> gId = order.getGId();
                List<Integer> goodSum = order.getGoodsNum();
                Timestamp startTime = order.getStartTime();
                double total = order.getTotal();
        %>
        <tr>
        <td><%=id%></td>
        <td><%=sId%></td>
        <td><%=sName%></td>
        <td><%=gId%></td>
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
        <li><a href="ProfileOrder?page=<%= i %>"><%= i %></a></li>
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
<p>查询相关</p>
<button id="backToIndex"><a href="index.jsp">返回主页</a></button>
</body>
</html>
