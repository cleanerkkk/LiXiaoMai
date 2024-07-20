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
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息设置</title>
    <style>
        body{
            text-align: center;
            font-family: "宋体",sans-serif;
        }
        h2{
            font-size: 32px;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<h2>课程管理</h2>

<div class="account">
    <p>学号：${stuinfo} 姓名：${stuname}</p>
</div>
<table>
    <thead>
    <tr>
        <th>课程序号</th>
        <th>课程名称</th>
        <th>选课人数</th>
        <th>课程性质</th>
    </tr>
    </thead>

</table>
<button id="withdrawButton"><a href="delCourse.jsp">退选课程</a></button>
<button id="courseManagementButton"><a href="addCourse.jsp">新增课程</a></button>
</body>
</html>
