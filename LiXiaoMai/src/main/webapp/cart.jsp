<%@ page import="com.example.lixiaomai.backend.entity.Cart" %>
<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/cart.css" type = "text/css">
</head>
<script>
    function increaseQuantity(inputId) {
        var input = document.getElementById(inputId);
        var value = parseInt(input.value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        input.value = value;
    }

    function decreaseQuantity(inputId) {
        var input = document.getElementById(inputId);
        var value = parseInt(input.value, 10);
        value = isNaN(value) ? 0 : value;
        value--;
        if (value < 0) value = 0;
        input.value = value;
    }
</script>
<body>
<h2>购物车</h2>
<div class="account">
    <p>用户姓名：${name}</p>
</div>
<div class="cart-details">
    <%
        Cart cart = (Cart) request.getAttribute("cart");
        List<Product> gList = (List<Product>) request.getAttribute("product");
        List<Integer> gIdList = (List<Integer>) cart.getGId();
        List<Integer> gNumList = (List<Integer>) cart.getGoodsNum();
        double total = cart.getTotal();
        if (cart != null) {
    %>
    <div class="cutLine">
        <p>    </p>
    </div>
    <p></p>
    <p></p>
    <p></p>
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
                    int gNum = gNumList.get(i);
                    Product product = gList.get(i);
                    String productName=product.getName();
                    int productPrice = product.getPrice();
                    int pTotal = productPrice * gNum;
            %>
            <tr>
                <td><%= productName %></td>
                <td><%= gNum %></td>
                <td><%= productPrice%></td>
                <td><%=pTotal%></td>
            </tr>
            <%
                }
            %>
        </table>
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