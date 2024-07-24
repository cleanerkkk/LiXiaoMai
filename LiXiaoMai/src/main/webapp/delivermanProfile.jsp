<%@ page import="com.example.lixiaomai.backend.service.DelivermanService" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/24
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.lixiaomai.backend.entity.Deliverman" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>骑手个人信息维护</title>
    <link rel="stylesheet" href="css/delivermanProfile.css" type="text/css">
</head>
<body>
<h1>骑手个人信息维护</h1>
<%
    Deliverman deliverman = (Deliverman) request.getAttribute("deliverman");
%>
<form action="deliverProfileUpdate" method="post">
    <input type="hidden" name="id" value="<%= deliverman.getId() %>">
    <label for="name">姓名：</label>
    <input type="text" id="name" name="name" value="<%= deliverman.getName() %>" required><br>
    <label for="uName">用户名：</label>
    <input type="text" id="uName" name="uName" value="<%= deliverman.getUName() %>" required><br>
    <label for="password">密码：</label>
    <input type="password" id="password" name="password" value="<%= deliverman.getPassword() %>" required><br>
    <label for="telephone">电话：</label>
    <input type="text" id="telephone" name="telephone" value="<%= deliverman.getTelephone() %>" required><br>
    <label for="gender">性别：</label>
    <input type="text" id="gender" name="gender" value="<%= deliverman.getGender() %>" required><br>
    <label for="vType">车辆类型：</label>
    <input type="text" id="vType" name="vType" value="<%= deliverman.getVType() %>" required><br>
    <label for="vId">车辆ID：</label>
    <input type="text" id="vId" name="vId" value="<%= deliverman.getVId() %>" required><br>
    <label for="vBrand">车辆品牌：</label>
    <input type="text" id="vBrand" name="vBrand" value="<%= deliverman.getVBrand() %>" required><br>
    <label for="status">状态：</label>
    <input type="text" id="status" name="status" value="<%= deliverman.getStatus() %>" required><br>
    <button type="submit">更新信息</button>
</form>
</body>
</html>

