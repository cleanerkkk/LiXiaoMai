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
  </style>
</head>
<body>
<nav>
  <ul>
    <li><h3>"理小卖"外卖综合管理平台</h3></li>
    <li data-tab="main">主页</li>
    <li data-tab="nearby">附近商家一览</li>
    <li data-tab="coupon">优惠券促销活动</li>
    <li data-tab="personal">个人中心</li>
  </ul>
</nav>
<p></p>
<p></p>
<p></p>
<div class="container">
  <article id="main">

  </article>
  <article id="nearby">

  </article>
  <article id="coupon">

  </article>
  <article id="personal">

  </article>
</div>
</body>
</html>