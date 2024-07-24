<%@ page import="com.example.lixiaomai.backend.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lixiaomai.backend.entity.Deliverman" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>骑手接单界面</title>
  <link rel="stylesheet" href="css/delivermanOrderGet.css" type="text/css">
</head>
<body>
<h1>骑手接单界面</h1>
<div class="order-choose">
  <%
    List<Order> orderList = (List<Order>) request.getAttribute("orderList");
    Deliverman deliverman = (Deliverman) request.getAttribute("deliverman");
    List<String> addressList = (List<String>) request.getAttribute("addressList");
    if (orderList != null && deliverman != null) {
  %>
  <div class="account">
    <p>骑手名称：<%= deliverman.getUName() %> 骑手ID：<%= deliverman.getId() %></p>
  </div>
  <form action="deliverAdd" method="post">
    <table class="order-choose">
      <thead>
      <tr>
        <th>选择</th>
        <th>商家名称</th>
        <th>客户名称</th>
        <th>客户地址</th>
        <th>开始时间</th>
        <th>订单总金额</th>
      </tr>
      </thead>
      <tbody>
      <%
        for (int i = 0; i < orderList.size(); ++i) {
          Order order = orderList.get(i);
          String sName = order.getSName();
          String cUName = order.getCName();
          String address = addressList.get(i);
          Timestamp date = order.getStartTime();
          double total = order.getTotal();
      %>
      <tr>
        <td><input type="checkbox" name="selectedOrders" value="<%=order.getId()%>"></td>
        <td><%=sName%></td>
        <td><%=cUName%></td>
        <td><%=address%></td>
        <td><%=date%></td>
        <td><%=total%></td>
      </tr>
      <%
        }
      %>
      </tbody>
    </table>
    <div class="myButton">
      <button type="submit">提交选中的订单</button>
      <button id="backToDeliverIndex"><a href="delivermanIndex.jsp">返回主页</a></button>
    </div>
  </form>
  <%
  } else {
  %>
  <p>没有可接取的订单!!!!!!!</p>
  <% } %>
</div>
</body>
</html>
