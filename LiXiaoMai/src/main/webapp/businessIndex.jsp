<%@ page import="com.example.lixiaomai.backend.entity.Business" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/23
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Business business=(Business)session.getAttribute("business");
    request.setAttribute("business",business);
%>
<html>
<head>
    <title>商家主页管理</title>
    <link rel="stylesheet" href="css/businessIndex.css" type="text/css">
</head>
<body>
<h1>商家主页管理</h1>
<div class="container">
    <h1>欢迎，<%= business.getName() %>!</h1>
    <h3>个人信息：</h3>
    <div class="account">
        <p>用户类型：${userType} 用户姓名：${name}</p>
    </div>
    <div class="business-info">
        <p>商家名称: <%= business.getShopName()%></p>
        <p>商家地址: <%= business.getAddress() %></p>
        <p>联系方式: <%= business.getTelephone() %></p>
    </div>
    <div class="jumpTo" style="text-align: center">
        <a href="businessManage">管理商品</a>
        <a href="businessProfile">个人信息维护</a>
        <a href="businessOrderHistory">商家的历史订单详情</a>
        <a href="login.jsp">退出登录</a>
    </div>
</div>
</body>
</html>
