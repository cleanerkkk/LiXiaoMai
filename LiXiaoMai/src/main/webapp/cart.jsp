<%@ page import="com.example.lixiaomai.backend.entity.Cart" %>
<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang3.tuple.Pair" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="css/cart.css" type="text/css">
    <script>
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
        Map<Integer, List<Pair<Product, Integer>>> productMap = (Map<Integer, List<Pair<Product, Integer>>>) request.getAttribute("productMap");
        Map<Integer, Integer> mapName = (Map<Integer, Integer>) request.getAttribute("sNameMap");
        if (productMap != null) {
            double total = cart.getTotal();
            for(Map.Entry<Integer, List<Pair<Product, Integer>>> entry : productMap.entrySet()){
                int sId = entry.getKey();
                List<Pair<Product, Integer>> list = entry.getValue();
                List<Product> products = list.stream().map(Pair::getLeft).toList();
                List<Integer> goodsNum = list.stream().map(Pair::getRight).toList();
                %>
                <div class="cutLine">
                    <p>    </p>
                </div>
                <p>商家名称:<%=mapName.get(sId)%></p>
                <form action=" " method="post">
                    <table border="1">
                        <tr>
                            <th>商品名称</th>
                            <th>数量</th>
                            <th>单价</th>
                            <th>总价</th>
                        </tr>
                        <%
                            String exProductName = "[";
                            String exNum = "[";
                            String exPrice = "[";
                            double exTotal = 0;
                            for(int i = 0; i < products.size(); ++i) {
                                Product product = products.get(i);
                                String productName = product.getName();
                                int num = goodsNum.get(i);
                                int productPrice = product.getPrice();
                                double pTotal = productPrice * num;
                                if(i != 0){
                                    exProductName += ",";
                                    exNum += ",";
                                    exPrice += ",";
                                }
                                exProductName += productName;
                                exNum += num;
                                exPrice += productPrice;
                                exTotal += pTotal;
                            }
                            exProductName += "]";
                            exNum += "]";
                            exPrice += "]";
                        %>
                        <tr>
                            <td><%= exProductName %></td>
                            <td><%= exNum %></td>
                            <td><%= exPrice %></td>
                            <td><%= exTotal %></td>
                        </tr>
                    </table>
                    <input type="submit" value="购物">
                </form>
            <%
                }
            %>
        <div>
            <p>总价: <span id="grand-total"><%= total %></span></p>
        </div>
    <%
    } else {
    %>
    <p>购物车内暂无信息。</p>
    <%
        }
    %>
</div>
<button id="backToMain"><a href="exhibit">返回主页</a></button>
</body>
</html>
