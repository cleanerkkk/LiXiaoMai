<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.util.List" %>
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
      width: 1500px;
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
    .merchant {
      display: flex;
      justify-content: space-between;
      margin-bottom: 10px;
      align-items: center;
    }
    .merchant-info {
      flex: 1;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: #fff;
    }
    .merchant-info h4 {
      margin: 0;
      color: #333;
    }
    .merchant-info p {
      margin: 5px 0;
      color: #666;
    }
    .merchant-rating {
      color: #f60;
    }
    .merchant-image {
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

    .icon-bar {
      display: flex;
      justify-content: space-around;
      align-items: center;
      padding: 20px;
      background: #e9ecef;
      border-radius: 10px;
      margin-bottom: 20px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .icon-bar div {
      text-align: center;
    }

    .icon-bar img {
      width: 50px;
      height: 50px;
      margin-bottom: 10px;
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
    List<Product> list = (List<Product>) request.getAttribute("productList");
    Integer currentPage =(Integer) request.getAttribute("currentPage");
    Integer totalPage = (Integer) request.getAttribute("totalPage");
    if (list != null && !list.isEmpty()){
        for (Product product : list){
  %>
      <div class = "business-info">
  //做出你想要的排版，ok？
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
  <li><a herf = ""></a></li>
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
    <!-- 优惠券促销活动内容 -->
  </article>

  <article id="profile" style="display: none;">
    <div class="containerNew">
    <div class="profile-card">
      <img src="profile.jpg" alt="用户头像">
      <div class="profile-info">
        <h2>用户名</h2>
        <p>user@example.com</p>
      </div>
    </div>

    <div class="nav">
      <a href="#">订单历史</a>
      <a href="#">地址管理</a>
      <a href="#">账户设置</a>
      <a href="#">退出登录</a>
    </div>
    <div class="icon-bar">
        <div>
          <img src="favorite.png" alt="收藏">
          <p>收藏</p>
        </div>
        <div>
          <img src="history.png" alt="浏览记录">
          <p>浏览记录</p>
        </div>
        <div>
          <img src="coupon.png" alt="红包卡券">
          <p>红包卡券</p>
        </div>
        <div>
          <img src="coins.png" alt="美团币">
          <p>美团币</p>
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