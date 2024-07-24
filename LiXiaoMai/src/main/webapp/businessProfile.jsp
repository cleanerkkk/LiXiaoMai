<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/24
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lixiaomai.backend.entity.Business" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家个人信息维护</title>
    <link rel="stylesheet" href="css/businessProfile.css" type="text/css">
</head>
<body>
<h1>商家个人信息维护</h1>
<%
    Business business= (Business) request.getAttribute("business");
%>
<form action="businessProfileUpdate" method="post">
    <input type="hidden" name="id" value="<%= business.getId() %>">
    <label for="shopName">商家名：</label>
    <input type="text" id="shopName" name="shopName" value="<%= business.getShopName() %>" required><br>
    <label for="uName">用户名：</label>
    <input type="text" id="uName" name="uName" value="<%= business.getUName() %>" required><br>
    <label for="name">真实姓名：</label>
    <input type="text" id="name" name="name" value="<%= business.getName() %>" required><br>
    <label for="address">商家地址：</label>
    <input type="text" id="address" name="address" value="<%= business.getAddress() %>" required><br>
    <label for="password">密码：</label>
    <input type="password" id="password" name="password" value="<%= business.getPassword() %>" required><br>
    <label for="telephone">电话：</label>
    <input type="text" id="telephone" name="telephone" value="<%= business.getTelephone() %>" required><br>
    <label for="idCard">身份证：</label>
    <input type="text" id="idCard" name="idCard" value="<%= business.getIdCard() %>" required><br>
    <label for="status">状态：</label>
    <input type="text" id="status" name="status" value="<%= business.getStatus() %>" required><br>
    <button type="submit">更新信息</button>
</form>
</body>
</html>

