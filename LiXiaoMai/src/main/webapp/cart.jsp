<%@ page import="com.example.lixiaomai.backend.entity.Cart" %>
<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="com.example.lixiaomai.backend.entity.Coupon" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang3.tuple.Pair" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="css/cart.css" type="text/css">
    <script>
        function updateMerchantTotalPrice(sId) {
            var total = 0;
            var totalFields = document.getElementsByClassName('product-total-' + sId);
            for (var i = 0; i < totalFields.length; i++) {
                total += parseFloat(totalFields[i].innerText);
            }

            var couponDiscount = parseFloat(document.getElementById('coupon-discount-' + sId).innerText) || 0;
            total -= couponDiscount;

            document.getElementById('merchant-total-' + sId).innerText = total.toFixed(2);
        }

        function showCoupons(sId) {
            var couponSection = document.getElementById('coupon-section-' + sId);

            couponSection.style.display = 'block';
        }

        function applyCoupon(sId) {
            var couponSelect = document.getElementById('coupon-select-' + sId);
            var discount = parseFloat(couponSelect.value);
            var selectedCouponId = couponSelect.options[couponSelect.selectedIndex].getAttribute('data-coupon-id');

            document.getElementById('coupon-discount-' + sId).innerText = discount.toFixed(2);

            var couponIdInput = document.getElementById('coupon-id-' + sId);
            if (!couponIdInput) {
                couponIdInput = document.createElement('input');
                couponIdInput.type = 'hidden';
                couponIdInput.name = 'couponId';
                couponIdInput.id = 'coupon-id-' + sId;
                couponIdInput.value = selectedCouponId;
                document.forms['form-' + sId].appendChild(couponIdInput);
            } else {
                couponIdInput.value = selectedCouponId;
            }

            updateMerchantTotalPrice(sId);
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
        List<Coupon> coupons = (List<Coupon>) request.getAttribute("couponList");
        String gIds;
        String goodNum;

        if (productMap != null) {
            for(Map.Entry<Integer, List<Pair<Product, Integer>>> entry : productMap.entrySet()){
                int nowTotal = 0;
                gIds = "";
                goodNum = "";
                int sId = entry.getKey();
                List<Pair<Product, Integer>> list = entry.getValue();
                List<Product> products = list.stream().map(Pair::getLeft).toList();
                List<Integer> goodsNum = list.stream().map(Pair::getRight).toList();
    %>
    <div class="cutLine">
        <p>    </p>
    </div>
    <p>商家名称:<%= mapName.get(sId) %></p>
    <form action="checkout" method="post" id="form-<%=sId%>">
        <table border="1">
            <tr>
                <th>商品名称</th>
                <th>数量</th>
                <th>单价</th>
                <th>总价</th>
            </tr>
            <%
                for (int i = 0; i < products.size(); ++i) {
                    Product product = products.get(i);
                    int productId = product.getId();
                    String productName = product.getName();
                    int num = goodsNum.get(i);
                    double productPrice = product.getPrice();
                    double pTotal = productPrice * num;
                    if(i != 0){
                        gIds += ",";
                        goodNum += ",";
                    }
                    gIds += productId;
                    goodNum += num;
                    nowTotal += pTotal;
            %>
            <tr>
                <td><%= productName %></td>
                <td>
                    <input type="number" value="<%= num %>" readonly>
                </td>
                <td><%= productPrice %></td>
                <td class="product-total-<%= sId %>"><%= pTotal %></td>
            </tr>
            <% }
            %>
        </table>
        <button type="button" onclick="showCoupons(<%= sId %>)">使用优惠券</button>
        <div id="coupon-section-<%= sId %>" style="display:none;">
            <select id="coupon-select-<%= sId %>" onchange="applyCoupon(<%= sId %>)">
                <option value="0">请选择优惠券</option>
                <% if (coupons != null) {
                    for (Coupon coupon : coupons) {
                        double discount = coupon.getDiscount();
                        int couponId = coupon.getId();
                        String couponName;
                        int limit = coupon.getLimit();
                        if (limit == 0) {
                            couponName = "无门槛券";
                        } else {
                            couponName = "满减券";
                        }
                %>
                <%
                    if(nowTotal >= limit){
                %>
                <option value="<%= discount %>" data-coupon-id="<%= couponId %>"><%= couponName %> - 折扣 <%= discount %> 元</option>
                <%
                    } } } %>
            </select>
        </div>
        <!-- End of Coupon Section -->
        <div>
            <p>商家总价: <span id="merchant-total-<%= sId %>">0.00</span></p>
            <p>优惠券折扣: <span id="coupon-discount-<%= sId %>">0.00</span></p>
        </div>
        <input type = "hidden" name = "sId" value="<%=sId%>">
        <input type = "hidden" name = "gIds" value="<%=gIds%>">
        <input type = "hidden" name = "goodsNum" value="<%=goodNum%>">
        <input type = "hidden" name = "sName" value="<%= mapName.get(sId)%>">
        <input type = "hidden" name= "couponId" id="coupon-id-<%=sId%>">
        <input type = "hidden" name = "discountNum" value="1">
        <input type="submit" value="购物">
    </form>
    <%
        }
    %>
    <% } else { %>
    <p>购物车内暂无信息。</p>
    <% } %>
</div>
<button id="backToMain"><a href="exhibit">返回主页</a></button>
<script>
    // Initialize total price for each merchant on page load
    <% if (productMap != null) {
        for (Map.Entry<Integer, List<Pair<Product, Integer>>> entry : productMap.entrySet()) {
            int sId = entry.getKey();
    %>
    updateMerchantTotalPrice(<%= sId %>);
    <% }
    } %>
</script>
</body>
</html>
