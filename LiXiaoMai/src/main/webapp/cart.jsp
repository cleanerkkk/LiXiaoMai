<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        .user-info, .cart-items, .order-summary {
            border: 1px solid #ccc;
            padding: 15px;
            margin: 15px 0;
        }
        .cart-items table {
            width: 100%;
            border-collapse: collapse;
        }
        .cart-items table, .cart-items th, .cart-items td {
            border: 1px solid #ccc;
        }
        .cart-items th, .cart-items td {
            padding: 10px;
            text-align: left;
        }
        .cart-items th {
            background-color: #f4f4f4;
        }
        .cart-items img {
            width: 50px;
            height: 50px;
        }
        .order-summary {
            text-align: right;
        }
        .quantity-control {
            display: flex;
            align-items: center;
        }
        .quantity-control button {
            margin: 0 5px;
            padding: 5px 10px;
        }
    </style>
    <script>
        function updateQuantity(productId, quantityChange) {
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'updateCart', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var response = JSON.parse(xhr.responseText);
                    document.getElementById('cart-items').innerHTML = response.cartItemsHtml;
                    document.getElementById('total-price').innerHTML = response.totalPrice;
                }
            };
            xhr.send('productId=' + productId + '&quantityChange=' + quantityChange);
        }
    </script>
</head>
<body>
<div class="container">
    <div class="user-info">
        <h2>用户信息</h2>
        <p>用户名: ${user.name}</p>
        <p>邮箱: ${user.email}</p>
    </div>

    <!-- 商品详细信息 -->
    <div class="cart-items" id="cart-items">
        <h2>购物车商品</h2>
        <table>
            <thead>
            <tr>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>数量</th>
                <th>单价</th>
                <th>小计</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${cartItems}">
                <tr>
                    <td><img src="${item.imageURL}" alt="${item.name}"/></td>
                    <td>${item.name}</td>
                    <td>
                        <div class="quantity-control">
                            <button onclick="updateQuantity(${item.id}, -1)">-</button>
                            <span>${item.quantity}</span>
                            <button onclick="updateQuantity(${item.id}, 1)">+</button>
                        </div>
                    </td>
                    <td><fmt:formatNumber value="${item.price}" type="currency"/></td>
                    <td><fmt:formatNumber value="${item.quantity * item.price}" type="currency"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- 订单总价和提交按钮 -->
    <div class="order-summary">
        <h2>订单总价</h2>
        <p id="total-price"><fmt:formatNumber value="${totalPrice}" type="currency"/></p>
        <form action="checkout" method="post">
            <input type="submit" value="提交订单"/>
        </form>
    </div>
</div>
</body>
</html>
