<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>粒小麦外卖平台</title>
</head>
<body>
<script>
    function refreshCaptcha(){
        var captchaImg = document.getElementById('captchaImg');
        var timestamp = new Date().getTime();
        captchaImg.src = "CaptchaServlet?t=" + timestamp;
    }
</script>

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
    <div id = captchaContainer>
        <label for="captcha">验证码:</label>
        <input type="text" id = "captcha" name="captcha"/>
        <img src = "CaptchaServlet" alt="Captcha" id = "captchaImg" onclick="refreshCaptcha()">
    </div>
    <div>
        <button id = "button" type = "submit">登录</button>
    </div>

</form>

</body>
</html>