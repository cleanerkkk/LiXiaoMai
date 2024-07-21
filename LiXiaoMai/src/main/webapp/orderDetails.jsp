<%@ page import="com.example.lixiaomai.backend.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.example.lixiaomai.backend.service.OrderService" %><%--
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

<div class="order-details">
    <%
        // 获取订单ID参数
        String orderId = request.getParameter("id");

        // 根据订单ID查询订单详细信息（假设有一个方法getOrderById）
        OrderService orderService=new OrderService();
        Order order=orderService.getOrderById(Integer.parseInt(orderId));

        if (order != null) {
            int id = order.getId();
            int sId = order.getSId();
            String sName = order.getSName();
            List<Integer> gId = order.getGId();
            List<Integer> goodSum = order.getGoodsNum();
            Timestamp startTime = order.getStartTime();
            double total = order.getTotal();
    %>
    <p><strong>订单ID：</strong><%= id %></p>
    <p><strong>商家ID：</strong><%= sId %></p>
    <p><strong>店铺名称：</strong><%= sName %></p>
    <p><strong>商品信息：</strong></p>
    <ul>
        <%
            for (int i = 0; i < gId.size(); i++) {
        %>
        <li>商品ID: <%= gId.get(i) %> 数量: <%= goodSum.get(i) %></li>
        <%
            }
        %>
    </ul>
    <p><strong>下订单时间：</strong><%= startTime %></p>
    <p><strong>订单总价：</strong><%= total %></p>
    <%
    } else {
    %>
    <p>未找到订单详情。</p>
    <%
        }
    %>
</div>

<button id="backToOrders"><a href="ProfileOrder">返回订单列表</a></button>
</body>
</html>
