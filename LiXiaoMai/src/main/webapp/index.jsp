<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lixiaomai.backend.entity.Business" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>理小卖外卖平台</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
    }
    nav {
      background-color: white;
      color: black;
      padding: 10px;
      background-size: 100% 100%;
      background-position: center;
      background-repeat: no-repeat;
      font-weight: bold;
    }
    h3 {
      text-align: center;
      text-decoration: none;
      color: orange;
    }
    .links nav ul {
      text-align: center;
      list-style-type: none;
      padding: 0;
      overflow: hidden;
    }

    .links nav ul li {
      display: inline;
      margin-right: 20px;
    }

    .links nav ul li a {
      color: black;
      text-decoration: none;
    }

    .links nav ul li:active {
      transition: background-color 0.2s;
      background-color: #ccc;
    }
    .container {
      width: 100%;
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
      font-family: "century gothic", sans-serif;
      font-family: '仿宋', sans-serif;
      font-size: 20px;
      line-height: 1.6;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: rgba(255, 255, 255, 0.1);
      margin-bottom: 20px;
    }
    .business {
      display: flex;
      justify-content: space-between;
      margin-bottom: 10px;
      align-items: center;
    }
    .business-info {
      flex: 1;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: #fff;
    }
    .business-info h4 {
      margin: 0;
      color: #333;
    }
    .business-info p {
      margin: 5px 0;
      color: #666;
    }
    .business-info image {
      width: 100px;
      height: 100px;
      object-fit: cover;
      border-radius: 50%;
      margin-right: 10px;
    }
    .profile-card {
      display: flex;
      align-items: center;
      padding: 20px;
      background: #e9ecef;
      border-radius: 10px;
      margin-bottom: 20px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .profile-card img {
      border-radius: 50%;
      width: 80px;
      height: 80px;
      margin-right: 20px;
    }

    .profile-info {
      flex: 1;
    }

    .profile-info h2 {
      margin: 0;
      font-size: 1.5em;
      color: #333;
    }

    .profile-info p {
      margin: 5px 0 0;
      color: #666;
    }

    .nav {
      display: flex;
      justify-content: space-around;
      margin-bottom: 30px;
    }

    .nav a {
      text-decoration: none;
      color: #007bff;
      font-size: 1.1em;
      padding: 10px;
      border-radius: 5px;
      transition: background 0.3s;
    }

    .nav a:hover {
      background: #007bff;
      color: #fff;
    }

    .sections {
      display: flex;
      flex-direction: column;
      gap: 20px;
    }

    .section {
      padding: 20px;
      background: #f9f9f9;
      border-radius: 10px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      margin-bottom: 20px;
    }

    .section h3 {
      margin-top: 0;
      color: #333;
    }

    .none {
        margin: 0;padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        display: none
    }

    .result {
        padding: 0;list-style: none;text-decoration: none;
        text-align: center;
        margin-top: 1%;
        background: #24c7b8;
        color: #fff;
        font-size: 26px
    }

    .wrap {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        width: 700px;
        height: 700px;
        position: relative;
        left: 50%;
        margin-left: -350px;
        top: 50%;
        margin-top: 0px;
        background: #24c7b8;
        border-radius: 50%;
        top: 45%
    }

    .wrap ul {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        width: 90%;
        height: 90%;
        position: absolute;
        left: 50%;
        margin-left: -45%;
        top: 50%;
        margin-top: -45%;
        border-radius: 50%;
        overflow: hidden;
        background: #166dab;
        box-shadow: 0px 0px 12px 2px #152c3c
    }

    .wrap ul li:nth-child(1) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(30deg);
        -moz-transform: rotate(30deg);
        -ms-transform: rotate(30deg);
        -o-transform: rotate(30deg);
        transform: rotate(30deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(2) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(60deg);
        -moz-transform: rotate(60deg);
        -ms-transform: rotate(60deg);
        -o-transform: rotate(60deg);
        transform: rotate(60deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(3) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(90deg);
        -moz-transform: rotate(90deg);
        -ms-transform: rotate(90deg);
        -o-transform: rotate(90deg);
        transform: rotate(90deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(4) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(120deg);
        -moz-transform: rotate(120deg);
        -ms-transform: rotate(120deg);
        -o-transform: rotate(120deg);
        transform: rotate(120deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(5) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(150deg);
        -moz-transform: rotate(150deg);
        -ms-transform: rotate(150deg);
        -o-transform: rotate(150deg);
        transform: rotate(150deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(6) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(180deg);
        -moz-transform: rotate(180deg);
        -ms-transform: rotate(180deg);
        -o-transform: rotate(180deg);
        transform: rotate(180deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(7) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(210deg);
        -moz-transform: rotate(210deg);
        -ms-transform: rotate(210deg);
        -o-transform: rotate(210deg);
        transform: rotate(210deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(8) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(240deg);
        -moz-transform: rotate(240deg);
        -ms-transform: rotate(240deg);
        -o-transform: rotate(240deg);
        transform: rotate(240deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(9) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(270deg);
        -moz-transform: rotate(270deg);
        -ms-transform: rotate(270deg);
        -o-transform: rotate(270deg);
        transform: rotate(270deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(10) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(300deg);
        -moz-transform: rotate(300deg);
        -ms-transform: rotate(300deg);
        -o-transform: rotate(300deg);
        transform: rotate(300deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(11) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(330deg);
        -moz-transform: rotate(330deg);
        -ms-transform: rotate(330deg);
        -o-transform: rotate(330deg);
        transform: rotate(330deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(12) {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        position: absolute;
        left: 50%;
        margin-left: -90px;
        -webkit-transform: rotate(360deg);
        -moz-transform: rotate(360deg);
        -ms-transform: rotate(360deg);
        -o-transform: rotate(360deg);
        transform: rotate(360deg);
        -webkit-transform-origin: center 315px 10px;
        -moz-transform-origin: center 315px 10px;
        -ms-transform-origin: center 315px 10px;
        -o-transform-origin: center 315px 10px;
        transform-origin: center 315px 10px
    }

    .wrap ul li:nth-child(odd):after {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        content: '';
        display: block;
        width: 0;
        height: 0;
        border-left: 89px solid transparent;
        border-right: 89px solid transparent;
        border-top: 308px solid #1b7b54
    }

    .wrap ul li:nth-child(even):after {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        content: '';
        display: block;
        width: 0;
        height: 0;
        border-left: 89px solid transparent;
        border-right: 89px solid transparent;
        border-top: 308px solid #18b373
    }

    .wrap .title {
        padding: 0;list-style: none;text-decoration: none;
        width: 10%;
        color: #fff;
        font-size: 26px;
        font-weight: 600;
        position: absolute;
        left: 50%;
        margin-left: -5%;
        top: 50%;
        margin-top: -65%
    }

    .wrap .pointerDisk {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        width: 20%;
        height: 20%;
        position: absolute;
        left: 50%;
        margin-left: -10%;
        top: 50%;
        margin-top: -10%;
        background: #d0f1dd;
        border-radius: 50%;
        text-align: center;
        line-height: 7rem;
        color: #fff
    }

    .wrap .pointerDisk .internal {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        width: 80%;
        height: 80%;
        position: absolute;
        left: 50%;
        margin-left: -40%;
        top: 50%;
        margin-top: -40%;
        border-radius: 50%;
        background: #1cca69;
        box-shadow: 0px 0px 8px -1px #2a924f;
        cursor: pointer
    }

    .wrap .pointerDisk .triangleUp {
        padding: 0;list-style: none;text-decoration: none;font-size: 17px;
        width: 0;
        height: 0;
        border-left: 15px solid transparent;
        border-right: 15px solid transparent;
        border-bottom: 50px solid #d0f1dd;
        position: absolute;
        top: -45px;
        left: 39%
    }
  </style>
</head>
<body>
<script>
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
<div class="links">
<nav>
  <ul>
    <li><h1>"理小卖"外卖综合管理平台</h1></li>
    <li data-tab="main">主页</li>
    <li data-tab="coupon">优惠券促销活动</li>
    <li data-tab="profile">个人中心</li>
  </ul>
</nav>
</div>
<p></p>
<p></p>
<p></p>
<div class="container">
  <article id="main">
    <div class="business">
  <%
    List<Business> list = (List<Business>) request.getAttribute("BusinessList");
    Map<Integer, List<Product>> productMap = (Map<Integer, List<Product>>) request.getAttribute("ProductMap");
    Integer currentPage =(Integer) request.getAttribute("currentPage");
    Integer totalPage = (Integer) request.getAttribute("totalPages");
    if ((list != null && !list.isEmpty())){
        for (Business business : list){
        List<Product> product = productMap.get(business.getId());
        //去图片库获取信息URL
        //String urlImg="img+i";

  %>
      <div class = "business-info">
          <img src=" "alt=""id="">
      </div>
    <%
            }
    }
        else{
          %>
            <h3>没有找到相关商品</h3>
            <%
              }
            %>
      <%
          if (totalPage != null && currentPage != null && totalPage > 1){
      %>
<nav>
<ul>
<%
for (int i = 1; i <= totalPage; i++){
      if (i == currentPage){
%>
<li><strong><%=i%></strong></li>
<%
      }
      else{
%>
  <li><a href="exhibit?page=<%=i%>"><%=i%></a></li>
  <%
      }
      if (i < totalPage){

      %>
<li>|</li>
<%
      }
      }
%>

</ul>
</nav>
      <%
        }
      %>
    </div>
  </article>

  <article id="coupon" style="display: none;">
      <p class="result none" ></p>
      <div class="wrap">
          <ul class="turntable">
              <li id="num2"> <div class="title">三等奖</div> </li>
              <li id="num3"> <div class="title">二等奖</div> </li>
              <li id="num4"> <div class="title">谢谢参与</div> </li>
              <li id="num5"> <div class="title">三等奖</div> </li>
              <li id="num6"> <div class="title">谢谢参与</div> </li>
              <li id="num7"> <div class="title">二等奖</div> </li>
              <li id="num8"> <div class="title">三等奖</div> </li>
              <li id="num9"> <div class="title">谢谢参与</div> </li>
              <li id="num10"> <div class="title">三等奖</div> </li>
              <li id="num11"> <div class="title">二等奖</div> </li>
              <li id="num12"> <div class="title">一等奖</div> </li>
              <li id="num1"> <div class="title">特等奖</div> </li>
          </ul>
          <div class="pointerDisk">
              <span class="triangleUp"></span>
              <p class="internal">开始抽奖</p>
          </div>
      </div>
      <script src="js/turntable.js?v=1" defer>
      </script>
  </article>

  <article id="profile" style="display: none;">
    <div class="containerNew">
    <div class="profile-card">
      <img src="profile.jpg" alt="用户头像">
      <div class="profile-info">
        <h2>${name}</h2>
        <h2>${userType}</h2>
        <p>${name}@example.com</p>
      </div>
    </div>

    <div class="nav">
      <div>
        <img src="./imgsrc/settings.png" alt="收藏">
        <p></p>
        <a href="profileSettings.jsp">账户设置</a>
      </div>
      <div>
        <img src="./imgsrc/order.PNG" alt="浏览记录">
        <p></p>
        <a href="ProfileOrder">全部订单</a>
      </div>
      <div>
        <img src="./imgsrc/coupon.PNG" alt="红包卡券">
        <p></p>
        <a href="profileCoupon.jsp">红包卡券</a>
      </div>
      <div>
        <img src="./imgsrc/exit.png" alt="美团币">
        <p></p>
        <a href="login.jsp">退出登录</a>
      </div>
    </div>
    <div class="sections">
        <div class="section">
          <h3>最近订单</h3>
          <p>这里显示最近的订单信息...</p>
        </div>
      <div class="section">
          <h3>收藏的餐馆</h3>
          <p>这里显示收藏的餐馆信息...</p>
      </div>
    </div>
    </div>
  </article>
</div>
</body>
</html>