<%@ page import="com.example.lixiaomai.backend.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.example.lixiaomai.backend.entity.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="css/businessOrderDetails.css">
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>订单详情</h2>
<div class="account">
    <p>商家姓名：${name}</p>
</div>
<div class="order-details">
    <%
        Order order = (Order) request.getAttribute("order");
        List<String> productName = (List<String>) request.getAttribute("productNameList");
        String deliverName = (String) request.getAttribute("deliverName");
        String customerUName = (String) request.getAttribute("customerUName");
        if (order != null) {
            int id = order.getId();
            String sName = order.getSName();

            List<Integer> goodSum = order.getGoodsNum();
            Timestamp startTime = order.getStartTime();
            double total = order.getTotal();
    %>
    <table border="1">
        <tr>
            <th>店铺名称</th>
            <td><%= sName %></td>
        </tr>
        <tr>
            <th>骑手名称</th>
            <td><%=deliverName%></td>
        </tr>
        <tr>
            <th>消费者名称</th>
            <td><%=customerUName%></td>
        </tr>
        <tr>
            <th>订单时间</th>
            <td><%= startTime %></td>
        </tr>
        <tr>
            <th>订单总价</th>
            <td><%= total %></td>
        </tr>
    </table>
    <div class="cutLine">
        <p>    </p>
    </div>
    <p></p>
    <p></p>
    <p></p>
    <h3>商品信息</h3>
    <table border="1">
        <tr>
            <th>商品名称</th>
            <th>数量</th>
        </tr>
        <%
            for (int i = 0; i < productName.size(); i++) {
        %>
        <tr>
            <td><%= productName.get(i) %></td>
            <td><%= goodSum.get(i) %></td>
        </tr>
        <%
            }
        %>
    </table>
    <div class="comments">
        <%
            Comment customer = (Comment) request.getAttribute("customerComment");
            Comment deliver = (Comment) request.getAttribute("deliverComment");
            Comment business = (Comment) request.getAttribute("businessComment");
            if (customer == null) {
        %>

        <%
        } else{
                if(business == null){
        %>
        <form action="comment" method="post">
            <div>
                <label for = "customer">消费者</label>
                <input type="text" id = "customer" name = "customer">
            </div>
            <div>
                <button type="submit" name = "action" value="businessOrder" action = "businessOrder">提交评论</button>
            </div>
            <input type="hidden" name="deliverId" value="<%=order.getDeliverId()%>">
            <input type="hidden" name="customerId" value="<%=order.getCId()%>">

            <input type="hidden" name="oId" value="<%=order.getId()%>">
            <input type="hidden" name="businessName" value="<%=order.getSName()%>">
            <input type="hidden" name="customerUName" value="<%=customerUName%>">
            <input type="hidden" name="businessShopName" value="<%=sName%>">
        </form>
        <%
            }
        %>
        <table>
            <thead>
            <tr>
                <th></th>
                <th></th>
                <th>赞同数</th>
            </tr>
            </thead>
            <tr>
                <th>消费者评论</th>
                <td><%= customer.getContent() %></td>
                <td><%= customer.getLikes()%></td>
            </tr>
            <tr>
                <th>消费者对骑手评论</th>
                <%
                    if(deliver == null){
                %>
                <td>消费者默认好评</td>
                <%
                    }
                    else{
                %>
                <td><%= deliver.getContent() %></td>
                <%
                    }
                %>
                <td><%= customer.getLikes()%></td>
            </tr>
        </table>
        <%
                if(business != null){
                    %>
                    <table>
                        <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>赞同数</th>
                        </tr>
                        </thead>
                        <tr>
                            <th>商家回复</th>
                            <td><%= business.getContent() %></td>
                            <td><%= business.getLikes()%></td>
                        </tr>
                    </table>
                    <%
                }
            }
        %>
    </div>
    <%
    } else {
    %>
    <p>未找到订单详情。</p>
    <%
        }
    %>
</div>

<button id="backToOrders"><a href="ProfileOrder">返回订单列表</a></button>
</body>
</html>
