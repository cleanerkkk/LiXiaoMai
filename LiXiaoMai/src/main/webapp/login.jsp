<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>理小卖外卖平台:登录&注册</title>
    <link rel="stylesheet" href="css/login.css">
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<script>
    function refreshCaptcha(){
        var captchaImg = document.getElementById('captchaImg');
        var timestamp = new Date().getTime();
        captchaImg.src = "CaptchaServlet?t=" + timestamp;
    }
    function infoVerify(){
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var captcha1 = document.getElementById("captcha").value;

        // 确保三项信息均已填写
        if (!username || !password ||!captcha1) {
            alert("NOT NULL");
            return ;
        }
        document.getElementById("Form").submit();
    }
        function showAlert(message) {
        alert(message);
    }
    document.addEventListener("DOMContentLoaded", function() {
        var tabs = document.querySelectorAll("nav ul li");
        var articles = document.querySelectorAll(".container article");
        function handleTabClick(event) {
            tabs.forEach(function(tab) {
                tab.classList.remove("active");
            });
            articles.forEach(function(article) {
                article.style.display = "none";
            });
            event.target.classList.add("active");
            var selectedTab = event.target.dataset.tab;
            document.querySelector("#" + selectedTab).style.display = "block";
        }
        tabs.forEach(function(tab) {
            tab.addEventListener("click", handleTabClick);
        });
    });
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
        } else{
            document.getElementById("input3").style.display = 'block';
            document.getElementById("input6").style.display = 'block';
        }
    }
</script>
<nav>
    <ul>
        <li><h1>“理小卖”外卖综合管理平台</h1></li>
        <li data-tab="loginRelated">登录</li>
        <li data-tab="register">注册</li>
    </ul>
</nav>
<%
    String error = (String)request.getAttribute("error");
    if (error != null && !error.isEmpty()) { %>
<script>
    showAlert("<%= error %>");
</script>
<% } %>
<div class="container">

    <article id="loginRelated" >
    <h2>“理小卖”外卖综合管理平台登录</h2>
    <form action = "LoginServlet" method = "post" id = "Form">
    <div>
        <label for="user">用户类型:</label>
        <select name="user" id="user">
            <option value="customer">我是用户</option>
            <option value="business">我是商家</option>
            <option value="admin">我是管理员</option>
            <option value="deliverman">我是骑手</option>
        </select>
    </div>
    <div>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username">
    </div>
    <div>
        <label for="password">密码:</label>
        <input type="password" id="password" name="password">
    </div>
        <label for="captcha">验证码:</label>
    <div id = captchaContainer>
        <input type="text" id = "captcha" name="captcha"/>
        <img src = "CaptchaServlet" alt="Captcha" id = "captchaImg" onclick="refreshCaptcha()">
    </div>
    <div>
        <button id = "button" type = "button" onclick="infoVerify()">登录</button>
    </div>

    </form>
    </article>
    <article id="register" style="display: none;">
        <h2>“理小卖”外卖综合管理平台账号注册</h2>
        <form action = "RegisterServlet" method = "post">
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
</div>
</body>
</html>