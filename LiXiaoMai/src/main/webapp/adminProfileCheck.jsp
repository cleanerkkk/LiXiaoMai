<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lixiaomai.backend.entity.Admin" %>
<%@ page import="com.example.lixiaomai.backend.entity.Business" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lixiaomai.backend.entity.Deliverman" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/adminProfileCheck.css" type="text/css">
</head>
<body>
<% Admin admin = (Admin) session.getAttribute("admin"); %>
<h1>账户审查</h1>
<div class="container">
    <h1>欢迎管理员，<%= admin.getUName() %>!</h1>
    <h3>个人信息：</h3>
    <div class="account">
        <p>用户类型：<%=session.getAttribute("userType")%>> 用户姓名：<%=admin.getUName()%>></p>
    </div>
    <div class="account">
        <div class="business">
            <%
                List<Business> businesses = (List<Business>) session.getAttribute("businessList");
                if (businesses != null && !businesses.isEmpty()) {
                %>
            <table>
                <tr>
                    <th>商家名称</th>
                    <th>商店名称</th>
                    <th>商家地址</th>
                    <th>商家电话</th>
                    <th>真实姓名</th>
                    <th>身份证</th>
                    <th>操作</th>
                <%
                    for (Business business : businesses) {
                %>
                <tr>
                    <td><%=business.getShopName()%></td>
                    <td><%=business.getUName()%></td>
                    <td><%=business.getAddress()%></td>
                    <td><%=business.getTelephone()%></td>
                    <td><%=business.getName()%></td>
                    <td><%=business.getIdCard()%></td>
                    <td>
                        <form action="profileCheck" method="post">
                            <input type="radio"  name="flag" value="yes"> 通过
                            <input type="radio"  name="flag"  value="no"> 不通过
                            <button type="submit" name="id" value="<%=business.getId()%>">提交</button>
                            <input type="hidden" name="type" value="business"/>
                        </form>
                    </td>
                </tr>
                <%
                    }
                    } else{
                %>
                <p>商家全部审核完了哦</p>
                <%
                    }
                %>
            </table>
        </div>
        <div class="deliverman">
            <%
                List<Deliverman> delivermen = (List<Deliverman>) session.getAttribute("delivermanList");
                if (delivermen != null && !delivermen.isEmpty()) {
            %>
            <table>
                <tr>
                    <th>骑手姓名</th>
                    <th>骑手名称</th>
                    <th>骑手电话</th>
                    <th>骑手性别</th>
                    <th>骑手车辆种类</th>
                    <th>骑手车辆型号</th>
                    <th>操作</th>
                        <%
                    for (Deliverman deliverman : delivermen) {
                %>
                <tr>
                    <td><%=deliverman.getName()%></td>
                    <td><%=deliverman.getUName()%></td>
                    <td><%=deliverman.getTelephone()%></td>
                    <td><%=deliverman.getGender()%></td>
                    <td><%=deliverman.getVType()%></td>
                    <td><%=deliverman.getVBrand()%></td>
                    <td>
                        <form action="profileCheck" method="post">
                            <input type="radio"  name="flag" value="yes"> 通过
                            <input type="radio"  name="flag"  value="no"> 不通过
                            <button type="submit" name="id" value="<%=deliverman.getId()%>">提交</button>
                            <input type="hidden" name="type" value="deliverman"/>
                        </form>
                    </td>
                </tr>
                    <%
                    }
                    } else{
                %>
                <p>骑手已经全部审核完了哦</p>
                <%}
                %>
        </div>
    </div>
    <a  href="adminIndex.jsp" style="display: flex; bottom: 0">返回主页</a>
</div>

</body>
</html>