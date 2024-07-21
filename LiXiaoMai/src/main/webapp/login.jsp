<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>理小卖外卖平台</title>
    <meta charset="GBK">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        nav {
            background-color:white;
            color: black;
            padding: 10px;
            background-size: 100% 100%;
            background-position: center;
            background-repeat: no-repeat;
            font-weight: bold;
            text-align: right;
        }
        h1{
            text-align: center;
            text-decoration: black;
            color:orange;
        }
        h2{
            text-align: center;
            font-weight: bold;
            text-decoration: black;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
            overflow: hidden;
        }

        nav ul li {
            text-align: right;
            display: inline;
            margin-right: 20px;
        }

        nav ul li a {
            color: black;
            text-decoration:solid;
        }

        nav ul li:active {
            transition: background-color 0.2s;/*点击时产生一个动态效果*/
            background-color: #ccc;
        }
        .container {
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        input[type="text"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: darkgreen;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: green;
        }
        article {
            font-family: "century gothic",sans-serif;
            font-family: '仿宋',sans-serif;
            font-size: 20px;
            line-height: 1.6;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: rgba(255,255,255,0.1);
            margin-bottom: 20px;
        }
        #captchaContainer {
            display: flex; /* 使用 Flexbox 布局 */
            align-items: center; /* 垂直居中对齐 */
            margin-bottom: 10px; /* 底部间距 */
        }

        #captchaContainer img {
            cursor: pointer; /* 鼠标悬停时显示指针图标 */
            margin-left: 50px; /* 图片与输入框之间的间距 */
        }
        register {
            width: 1175px;
            margin-bottom: 20px;
            overflow: hidden;
            border: 1px solid #ccc;
            background-color: rgba(0, 0, 0, 0.1);
        }
    </style>
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
            return false;
        }
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
    <form action = "LoginServlet" method = "post">
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
        <button id = "button" type = "submit" onclick="infoVerify()">登录</button>
    </div>

    </form>
        <a href="index.jsp">跳转到index.jsp</a>
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