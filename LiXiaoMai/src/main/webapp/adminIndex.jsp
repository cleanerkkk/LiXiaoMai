<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lixiaomai.backend.entity.Admin" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/businessIndex.css" type="text/css">
</head>
<body>
<% Admin admin = (Admin) session.getAttribute("admin"); %>
<h1>后台管理界面</h1>
<div class="container">
    <h1>欢迎管理员，<%= admin.getUName() %>!</h1>
    <h3>个人信息：</h3>
    <div class="account">
        <p>用户类型：<%=session.getAttribute("userType")%>> 用户姓名：<%=admin.getUName()%>></p>
    </div>
    <a href="profileCheck">注册管理</a>
    <a href="login.jsp">退出登录</a>
</div>
</body>
</html>