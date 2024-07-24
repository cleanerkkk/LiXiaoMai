<%@ page import="com.example.lixiaomai.backend.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/20
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer=(Customer)session.getAttribute("customer");
%>
<html>
<head>
    <title>用户个人信息维护</title>
    <link rel="stylesheet" href="css/profileSettings.css" type="text/css">
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1>用户个人信息维护</h1>
<article id="register">
    <div class="account">
        <p>用户类型：${userType} 用户姓名：${name}</p>
    </div>
    <form action = "profileSettingsUpdate" method = "post">
        <input type="hidden" name="id" value="<%= customer.getId()%>">
        <label for="name">姓名：</label>
        <input type="text" id="name" name="name" value="<%= customer.getName() %>" required><br>
        <label for="uName">用户名：</label>
        <input type="text" id="uName" name="uName" value="<%= customer.getUName() %>" required><br>
        <label for="password">密码：</label>
        <input type="password" id="password" name="password" value="<%= customer.getPassword() %>" required><br>
        <label for="telephone">电话：</label>
        <input type="text" id="telephone" name="telephone" value="<%= customer.getTelephone() %>" required><br>
        <label for="gender">性别：</label>
        <input type="text" id="gender" name="gender" value="<%= customer.getGender() %>" required><br>
        <label for="birthday">生日：</label>
        <input type="text" id="birthday" name="birthday" value="<%= customer.getBirthday() %>" required><br>
        <label for="address">用户收货地址：</label>
        <input type="text" id="address" name="address" value="<%= customer.getAddress() %>" required><br>
        <button type="submit">更新信息</button>
    </form>
</article>
<button id="back"><a href="exhibit">返回主页</a></button>
</body>
</html>
