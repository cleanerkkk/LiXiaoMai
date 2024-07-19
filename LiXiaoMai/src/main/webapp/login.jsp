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
            color: black;;
            padding: 10px;
            background-size: 100% 100%;
            background-position: center;
            background-repeat: no-repeat;
            font-weight: bold;
        }
        h3{
            text-align: center;
            text-decoration: black;
            color:orange;
        }
        nav ul {
            text-align: center;
            list-style-type: none;
            padding: 0;
            overflow: hidden;
        }

        nav ul li {
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
        h1 {
            text-align: center;
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
            alert("请你把所有三项表格填满");
            return false;
        }
    }
    function errorUpdate(){
        var errormessage=session.getAttribute("error");
        if(errormessage!=NULL){
            alert(errormessage);
            return false;
        }
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
</script>
<nav>
    <ul>
        <li data-tab="loginRelated">登录</li>
        <li data-tab="register">注册</li>
    </ul>
</nav>
<div class="container">

    <article id="loginRelated" >
    <h1>“理小卖”外卖综合管理平台登录</h1>
    <form action = "LoginServlet" method = "post">
    <div>
        <label for="user">用户类型:</label>
        <select name="user" id="user">
            <option value="customer">我是用户</option>
            <option value="business">我是商家</option>
            <option value="admin">我是管理员</option>
            <option value="diliverman">我是骑手</option>
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
        <button id = "button" type = "submit">登录</button>
    </div>

    </form>
        <a href="index.jsp">跳转到index.jsp</a>
    </article>
    <article id="register" style="display: none;">

    </article>
</div>
</body>
</html>