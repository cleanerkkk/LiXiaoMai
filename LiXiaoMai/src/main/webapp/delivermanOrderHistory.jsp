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
        Deliverman deliverman = (Deliverman) request.getAttribute("deliverman");
        if (orderList != null && deliverman != null) {
    %>
    <div class="account">
        <p>骑手名称：<%= deliverman.getUName() %> 骑手ID：<%= deliverman.getId() %></p>
    </div>
    <table class="order-history">
        <thead>
        <tr>
            <th>订单ID</th>
            <th>客户ID</th>
            <th>商家ID</th>
            <th>订单总金额</th>
            <th>订单状态</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>商家名称</th>
            <th>客户名称</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Order order : orderList) {
                String orderStatus = null;
                if(order.getStatus()==1){
                    orderStatus="已完成";
                }
                else if(order.getStatus()==0){
                    orderStatus="未完成";
                }
        %>
        <tr>
            <td><%= order.getId() %></td>
            <td><%= order.getCId() %></td>
            <td><%= order.getSId() %></td>
            <td><%= order.getTotal() %>元</td>
            <td><%= orderStatus %></td>
            <td><%= order.getStartTime() %></td>
            <td><%= order.getEndTime() %></td>
            <td><%= order.getSName() %></td>
            <td><%= order.getCName() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <p>没有找到订单历史。</p>
    <% } %>
</div>
<div class="button123">
    <button id="backToDeliverIndex" ><a href="delivermanIndex.jsp">返回主页</a></button>
</div>

</body>
</html>
