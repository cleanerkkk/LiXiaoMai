<%@ page import="com.example.lixiaomai.backend.entity.Business" %>
<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/22
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/businessDetails.css" type = "text/css">
</head>
<body>
<h2>商家详情与商品一览表</h2>
<div class="account">
    <p>用户类型：${userType} 用户姓名：${name}</p>
</div>
<div class="order-details">
    <%
        Business business=(Business) request.getAttribute("business");
        List<Product> productForShop=(List<Product>)request.getAttribute("productForShop");
        if (business != null) {
            int id = business.getId();
            String shopName= business.getShopName();
            String address= business.getAddress();
            String telephone= business.getTelephone();
    %>
    <h3><%=shopName%></h3>
    <h4 style="text-align: center">商家地址：<%=address%>     商家电话：<%=telephone%></h4>
    <div class="cutLine">
        <p>    </p>
    </div>
    <p></p>
    <p></p>
    <p></p>
    <table border="1">
        <tr>
            <th>商品ID</th>
            <th>商品名称</th>
            <th>商品类型</th>
            <th>商品描述</th>
            <th>数量</th>
            <th>选择数量</th>
            <th>单价</th>
        </tr>
        <%
            for (int i = 0; i < productForShop.size(); i++) {//第一个td是那个勾选框
                int productID=productForShop.get(i).getId();
                String productName=productForShop.get(i).getName();
                String productType=productForShop.get(i).getType();
                String productDescription=productForShop.get(i).getDescription();
                int productStock=productForShop.get(i).getStock();
                int productPrice=productForShop.get(i).getPrice();
        %>
        <tr>
            <td><%= productID %></td>
            <td><%= productName %></td>
            <td><%= productType%></td>
            <td><%= productDescription%></td>
            <td><%= productStock%></td>
            <td> </td>
            <td><%=productPrice%></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
    } else {
    %>
    <p>未找到订单详情。</p>
    <%
        }
    %>
</div>
<button id="backToMain"><a href="index.jsp">返回主页</a></button>
</body>
</html>
