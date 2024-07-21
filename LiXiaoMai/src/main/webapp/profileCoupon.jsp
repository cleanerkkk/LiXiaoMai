<%--
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
    <link rel="stylesheet" href="css/profileCoupon.css">
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>优惠券界面</title>
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
    <c:forEach var="order" items="${orderList}">
    <tr>
        <td>${order.id}</td>
        <td>${order.sId}</td>
        <td>${order.sName}</td>
        <td>${order.gId}</td>
        <td>${order.goodsSum}</td>
        <td>${order.startTime}</td>
        <td>${order.total}</td>
    </tr>
    </c:forEach>
    </tbody>
    </thead>
    <p>查询相关</p>
</table>
<button id="backToIndex"><a href="index.jsp">返回主页</a></button>
</body>
</html>
