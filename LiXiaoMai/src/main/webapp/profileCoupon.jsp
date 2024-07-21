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
<h2>优惠券管理</h2>

<div class="account">
    <p>用户类型：${userType} 用户姓名：${name}</p>
</div>
<table>
    <thead>
    <tr>
        <th>优惠券名称</th>
        <th>优惠券起用金额</th>
        <th>优惠券优惠金额</th>
    </tr>
    <c:forEach var="coupon" items="${couponList}">
    <tr>
        <td>天天爆红包</td>
        <td>${coupon.limit}</td>
        <td>${coupon.discount}</td>
    </tr>
    </c:forEach>
    </tbody>
    </thead>
    <p>红包卡券</p>
</table>
<button id="backToIndex"><a href="index.jsp">返回主页</a></button>
</body>
</html>
