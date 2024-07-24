<%@ page import="com.example.lixiaomai.backend.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lixiaomai.backend.entity.Deliverman" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>配送员订单历史</title>
    <link rel="stylesheet" href="css/delivermanOrderHistory.css" type="text/css">
</head>
<body>
<h1>配送员订单历史</h1>
<div class="order-history">
    <%
        List<Order> orderList = (List<Order>) request.getAttribute("orderList");
        Deliverman deliverman=(Deliverman)request.getAttribute("deliverman123");
        if (orderList != null) {
            for (Order order : orderList) {
    %>
    <div class="account">
        <p>骑手名称：<%=deliverman.getUName()%> 骑手id：<%=deliverman.getId()%></p>
    </div>
    <div class="order">
        <p>订单ID: <%= order.getId() %></p>
        <p>客户ID: <%= order.getCId() %></p>
        <p>商家ID: <%= order.getSId() %></p>
        <p>订单总金额: <%= order.getTotal() %>元</p>
        <p>订单状态: <%= order.getStatus() %></p>
        <p>开始时间: <%= order.getStartTime() %></p>
        <p>结束时间: <%= order.getEndTime() %></p>
        <p>商家名称: <%= order.getSName() %></p>
        <p>客户名称: <%= order.getCName() %></p>
    </div>
    <%
        }
    } else {
    %>
    <p>没有找到订单历史。</p>
    <% } %>
</div>
</body>
</html>
