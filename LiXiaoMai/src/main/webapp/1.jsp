<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>外卖管理平台</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
    }

    .merchant {
        display: flex;
        background-color: #ffffff;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        overflow: hidden;
    }

    .merchant-image img {
        width: 150px;
        height: 150px;
        object-fit: cover;
    }

    .merchant-info {
        flex: 1;
        padding: 20px;
    }

    .merchant-info h2 {
        margin: 0;
        font-size: 1.5em;
    }

    .merchant-info p {
        margin: 10px 0;
        color: #555;
    }

    .dish-images {
        display: flex;
        gap: 10px;
    }

    .dish-images img {
        width: 80px;
        height: 80px;
        object-fit: cover;
        border-radius: 5px;
    }

</style>
<body>
<div class="container">
    <%-- 示例商家数据 --%>
    <%
        String[][] merchants = {
                {"商家1", "地址1", "img/merchant1.jpg", "img/dish1.jpg", "img/dish2.jpg", "img/dish3.jpg"},
                {"商家2", "地址2", "img/merchant2.jpg", "img/dish1.jpg", "img/dish2.jpg", "img/dish3.jpg"},
                {"商家3", "地址3", "img/merchant3.jpg", "img/dish1.jpg", "img/dish2.jpg", "img/dish3.jpg"}
        };
        for (String[] merchant : merchants) {
    %>
    <div class="merchant">
        <p></p>
        <div class="merchant-image">
            <img src="<%= merchant[2] %>" alt="商家图片">
        </div>
        <div class="merchant-info">
            <h2><%= merchant[0] %></h2>
            <p><%= merchant[1] %></p>
            <div class="dish-images">
                <img src="<%= merchant[3] %>" alt="菜品图片1">
                <img src="<%= merchant[4] %>" alt="菜品图片2">
                <img src="<%= merchant[5] %>" alt="菜品图片3">
            </div>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>
