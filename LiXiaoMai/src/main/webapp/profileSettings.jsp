<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/7/20
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/profileSettings.css">
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息设置</title>
</head>
<script>
    function showInput() {
        var selectElement = document.getElementById("registerUser");
        var selectedValue = selectElement.value;

        // 隐藏所有的input
        document.getElementById("input1").style.display = 'none';
        document.getElementById("input2").style.display = 'none';
        document.getElementById("input3").style.display = 'none';
        document.getElementById("input4").style.display = 'none';
        document.getElementById("input5").style.display = 'none';
        document.getElementById("input6").style.display = 'none';

        // 根据选择的值显示相应的input
        if (selectedValue === "business") {
            document.getElementById("input1").style.display = 'block';
            document.getElementById("input2").style.display = 'block';
            document.getElementById("input3").style.display = 'block';
        } else if (selectedValue === "deliverman") {
            document.getElementById("input1").style.display = 'block';
            document.getElementById("input4").style.display = 'block';
            document.getElementById("input5").style.display = 'block';
        } else {
            document.getElementById("input3").style.display = 'block';
            document.getElementById("input6").style.display = 'block';
        }
    }
</script>
<body>
<h2>个人信息设置</h2>
<article id="register">
    <div class="account">
        <p>用户类型：${userType} 用户姓名：${name}</p>
    </div>
    <form action = "" method = "post">
        <div>
            <label for="registerUser">用户类型:</label>
            <select name="registerUser" id="registerUser" onchange="showInput()">
                <option value="choose">请选择用户类型</option>
                <option value="customer">用户</option>
                <option value="business">商家</option>
                <option value="deliverman">骑手</option>
            </select>
        </div>

        <div>
            <label for = "registerUsername">用户名:</label>
            <input type = "text" id = "registerUsername" name = "registerUsername">
        </div>
        <div>
            <label for = "firstPassword">密码:</label>
            <input type = "text" id = "firstPassword" name = "firstPassword">
        </div>
        <div>
            <label for = "secondPassword">确认密码:</label>
            <input type = "text" id = "secondPassword" name = "secondPassword">
        </div>
        <div>
            <label for = "trueName">姓名:</label>
            <input type = "text" id = "trueName" name="trueName">
        </div>
        <div>
            <label for = "gender">性别:</label>
            <input type = "text" id = "gender" name = "gender">
        </div>
        <div>
            <label for = "telephone">手机号:</label>
            <input type = "text" id = "telephone" name = "telephone">
        </div>
        <div id = "input1" style="display:none;">
            <label for = "idCard">身份证号:</label>
            <input type = "text" id = "idCard" name = "idCard">
        </div>
        <div id = "input2" style="display:none;">
            <label for = "storeName">店铺名:</label>
            <input type = "text" id = "storeName" name = "storeName">
        </div>
        <div id = "input3" style="display:none;">
            <label for = "address">地址:</label>
            <input type = "text" id = "address" name = "address">
        </div>

        <div id = "input4" style="display:none;">
            <label for = "vType">车辆类型:</label>
            <input type = "text" id = "vType" name = "vType">
        </div>
        <div id = "input5" style="display:none;">
            <label for = "vBrand">车辆品牌:</label>
            <input type = "text" id = "vBrand" name = "vBrand">
        </div>
        <div id = "input6" style="display: none;">
            <label for="date">日期:</label>
            <input type="date" id="date" name="date" value="1999-09-01">
        </div>
        <div>
            <button id = "butt" type = "submit">注册</button>
        </div>
    </form>
</article>
<button id="back"><a href="index.jsp">返回主页</a></button>
</body>
</html>
