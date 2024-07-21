<%@ page import="com.example.lixiaomai.backend.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.example.lixiaomai.backend.service.OrderService" %>
<%@ page import="com.example.lixiaomai.backend.service.CommentService" %>
<%@ page import="com.example.lixiaomai.backend.entity.Comment" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/20
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="css/orderDetails.css">
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>订单详情</h2>
<div class="account">
    <p>用户类型：${userType} 用户姓名：${name}</p>
</div>
<div class="order-details">
    <%
        Order order = (Order) request.getAttribute("order");
        List<String> productName = (List<String>) request.getAttribute("productNameList");

        if (order != null) {
            int id = order.getId();
            String sName = order.getSName();
            List<Integer> goodSum = order.getGoodsNum();
            Timestamp startTime = order.getStartTime();
            double total = order.getTotal();
    %>
    <table border="1">
        <tr>
            <th>订单ID</th>
            <td><%= id %></td>
        </tr>
        <tr>
            <th>店铺名称</th>
            <td><%= sName %></td>
        </tr>
        <tr>
            <th>订单时间</th>
            <td><%= startTime %></td>
        </tr>
        <tr>
            <th>订单总价</th>
            <td><%= total %></td>
        </tr>
    </table>
    <div class="cutLine">
        <p>    </p>
    </div>
    <p></p>
    <p></p>
    <p></p>
    <h3>商品信息</h3>
    <table border="1">
        <tr>
            <th>商品ID</th>
            <th>数量</th>
        </tr>
        <%
            for (int i = 0; i < productName.size(); i++) {
        %>
        <tr>
            <td><%= productName.get(i) %></td>
            <td><%= goodSum.get(i) %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
    } else {
    %>
    <p>未找到订单详情。</p>
    <%
        }
    %>
</div>
<div class="comments">

</div>
<button id="backToOrders"><a href="ProfileOrder">返回订单列表</a></button>
</body>
</html>
