<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lixiaomai.backend.entity.Business" %>
<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="com.example.lixiaomai.backend.service.ProductService" %>
<%
    // 获取商家对象
    Business business = (Business) session.getAttribute("business");
    ProductService productService=new ProductService();
    List<Product> products = productService.getAllProductBySid(business.getId());
%>
<!DOCTYPE html>
<html>
<head>
    <title>管理商品</title>
    <link rel="stylesheet" type="text/css" href="css/businessManage.css">
</head>
<body>
<h1>欢迎您！${shopName}</h1>
<div class="container">
    <h1>管理商品</h1>
    <form action="businessManage" method="post">
        <input type="hidden" name="action" value="add">
        <input type="text" name="name" placeholder="商品名称">
        <input type="text" name="description" placeholder="商品描述">
        <input type="number" name="price" placeholder="价格">
        <input type="text" name="stock" placeholder="库存">
        <input type="text" name="type" placeholder="类型">
        <input type="url" name="image" placeholder="商品图片">
        <button type="submit" name="add" value="add" action="add">添加商品</button>
    </form>
    <table>
        <tr>
            <th>商品名称</th>
            <th>描述</th>
            <th>价格</th>
            <th>库存</th>
            <th>商品类型</th>
            <th>商品图片</th>
            <th>操作</th>
        </tr>
        <% for (Product product : products) { %>
        <tr>
            <form action="businessManage" method="post">
                <input type="hidden" name="productId" value="<%= product.getId() %>">
                <td><input type="text" name="name" value="<%= product.getName() %>"></td>
                <td><input type="text" name="description" value="<%= product.getDescription() %>"></td>
                <td><input type="number" name="price" value="<%= product.getPrice() %>"></td>
                <td><input type="text" name="stock" value="<%=product.getStock()%>"></td>
                <td><input type="text" name="type" value="<%=product.getType()%>"></td>
                <td><input type="url" name="image" value="<%=product.getPitcutreUrl()%>"></td>
                <td>
                    <button type="submit" name="update" value="update" action="update">更新</button>
                    <button type="submit" name="delete" value="delete" action="delete">删除</button>
                </td>
            </form>
        </tr>
        <% } %>
    </table>
    <a href="businessIndex.jsp">返回商家主页</a>
</div>
</body>
</html>
