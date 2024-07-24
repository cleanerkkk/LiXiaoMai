<%@ page import="com.example.lixiaomai.backend.entity.Coupon" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang3.tuple.Pair" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/profileCoupon.css">
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>优惠券界面</title>
</head>
<style>
    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 12px 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
        color: #333;
    }

    tr:hover {
        background-color: #f9f9f9;
    }

    #linker {
        text-align: center;
        margin-top: 20px;
    }

    #linker a {
        display: inline-block;
        margin-right: 20px;
        text-decoration: none;
        color: #333;
        padding: 10px 20px;
        background-color: #f2f2f2;
        border-radius: 5px;
    }

    #linker a:hover {
        background-color: #ddd;
    }
    nav {
        margin-top: 20px;
        text-align: center;
    }
    nav ul {
        list-style-type: none;
        padding: 0;
    }
    nav ul li {
        display: inline;
        margin: 0 5px;
    }
    nav ul li a {
        text-decoration: none;
        color: #007BFF;
    }
    nav ul li a:hover {
        text-decoration: underline;
    }
</style>
<body>
<h2>优惠券管理</h2>

<div class="account">
    <p>用户类型：${userType} 用户姓名：${name}</p>
</div>
<table>
    <thead>
    <tr>
        <th>优惠券名称</th>
        <th>优惠券数量</th>
        <th>优惠券起用金额</th>
        <th>优惠券优惠金额</th>
    </tr>
    <%
        List<Pair<Coupon,Integer>> list = (List<Pair<Coupon,Integer>>) request.getAttribute("couponList");
        Integer totalPage = (Integer) request.getAttribute("totalPages");
        Integer currentPage = (Integer) request.getAttribute("currentPage");
        if (list != null && list.size() > 0){
            for (Pair<Coupon,Integer> pci : list){
                Coupon coupon = pci.getLeft();
                int num = pci.getRight();
                int limit = coupon.getLimit();
                double discount = coupon.getDiscount();
                String name;
                if(limit > 0){
                    name = "满减红包";
                }else{
                    name = "无门槛券";
                }
    %>
    <tr>
        <td><%=name%></td>
        <td><%=num%></td>
        <td><%=limit%></td>
        <td><%=discount%></td>
    </tr>

    <%
        }}
    else{
    %>
    <p>还没有优惠券哦</p>
    <%

        }
    %>

    </thead>

</table>
<%
    if (totalPage != null && currentPage != null && totalPage > 1) {
%>
<nav>
    <ul>
        <%
            for (int i = 1; i <= totalPage; i++) {
                if (i == currentPage) {
        %>
        <li><strong><%= i %></strong></li>
        <%
        } else {
        %>
        <li><a href="ProfileCoupon?page=<%= i %>"><%= i %></a></li>
        <%
            }
            if (i < totalPage) {
        %>
        <li>&nbsp;|&nbsp;</li>
        <%
                }
            }
        %>
    </ul>
</nav>
<%
    }
%>
<button id="backToIndex"><a href="exhibit">返回主页</a></button>
</body>
</html>
