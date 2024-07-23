<%@ page import="com.example.lixiaomai.backend.entity.Cart" %>
<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="css/cart.css" type="text/css">
    <script>
        function updateQuantity(productId, isIncrement) {
            var quantityField = document.getElementById('quantity-' + productId);
            var quantity = parseInt(quantityField.value);
            var priceField = document.getElementById('price-' + productId);
            var price = parseFloat(priceField.innerText);
            if (isIncrement) {
                quantity++;
            } else if (quantity > 0) {
                quantity--;
            }
            quantityField.value = quantity;

            var totalField = document.getElementById('total-' + productId);
            totalField.innerText = (quantity * price).toFixed(2);

            updateTotalPrice();
        }

        function updateTotalPrice() {
            var total = 0;
            var totalFields = document.getElementsByClassName('product-total');
            for (var i = 0; i < totalFields.length; i++) {
                total += parseFloat(totalFields[i].innerText);
            }
            document.getElementById('grand-total').innerText = total.toFixed(2);
        }
    </script>
</head>
<body>
<h2>购物车</h2>
<div class="account">
    <p>用户姓名：${name}</p>
</div>
<div class="cart-details">
    <%
        Cart cart = (Cart) request.getAttribute("cart");
        List<Product> gList = (List<Product>) request.getAttribute("product");
        if (cart != null) {
            List<Integer> gIdList = cart.getGId();
            List<Integer> gNumList = cart.getGoodsNum();
            double total = cart.getTotal();
    %>
    <div class="cutLine">
        <p>    </p>
    </div>
    <form action=" " method="post">
        <table border="1">
            <tr>
                <th>商品名称</th>
                <th>选择数量</th>
                <th>单价</th>
                <th>总价</th>
            </tr>
            <%
                for (int i = 0; i < gIdList.size(); i++) {
                    int gId = gIdList.get(i);
                    int gNum = gNumList.get(i);
                    Product product = gList.get(i);
                    String productName = product.getName();
                    double productPrice = product.getPrice();
                    double pTotal = productPrice * gNum;
            %>
            <tr>
                <td><%= productName %></td>
                <td>
                    <button type="button" onclick="updateQuantity(<%= gId %>, false)">-</button>
                    <input type="text" id="quantity-<%= gId %>" value="<%= gNum %>" readonly>
                    <button type="button" onclick="updateQuantity(<%= gId %>, true)">+</button>
                </td>
                <td id="price-<%= gId %>"><%= productPrice %></td>
                <td id="total-<%= gId %>" class="product-total"><%= pTotal %></td>
            </tr>
            <%
                }
            %>
        </table>
        <div>
            <p>总价: <span id="grand-total"><%= total %></span></p>
        </div>
        <input type="submit" value="购物">
    </form>
    <%
    } else {
    %>
    <p>购物车内暂无信息。</p>
    <%
        }
    %>
</div>
<button id="backToMain"><a href="index.jsp">返回主页</a></button>
</body>
</html>
