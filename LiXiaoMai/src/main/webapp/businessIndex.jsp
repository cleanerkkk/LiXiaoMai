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
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/businessIndex.css" type="text/css">
</head>
<body>
<h1>商家主页管理</h1>
<div class="container">
    <h1>欢迎，<%= business.getName() %>!</h1>
    <div class="business-info">
        <p>商家名称: <%= business.getShopName()%></p>
        <p>商家地址: <%= business.getAddress() %></p>
        <p>联系方式: <%= business.getTelephone() %></p>
    </div>
    <a href="businessManage.jsp">管理商品</a>
</div>
</body>
</html>
