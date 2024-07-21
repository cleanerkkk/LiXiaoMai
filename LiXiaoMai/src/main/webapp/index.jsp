<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lixiaomai.backend.entity.Business" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>理小卖外卖平台</title>
  <link rel="stylesheet" href="css/index.css">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<%--      在js里面 当抽奖结束 调用后端进行添加优惠券--%>
      <script src="js/turntable.js?v=1" defer>
      </script>
  </article>

  <article id="profile" style="display: none;">
    <section class="layout">
        <div class="header">
            <div class="profile-card">
                <img src="profile.jpg" alt="用户头像">
                <div class="profile-info">
                    <h2>${name}</h2>
                    <h2>${userType}</h2>
                    <p>${name}@example.com</p>
                </div>
            </div>
        </div>
        <div class="leftSide">
            <div class="section">
                <h3>最近订单</h3>
                <p>这里显示最近的订单信息...</p>
            </div>
        </div>
        <div class="rightSide">
            <div class="section">
                <h3>收藏的餐馆</h3>
                <p>这里显示收藏的餐馆信息...</p>
            </div>
        </div>
    <div class="containerNew">
    <div class="body">
        <div class="nav">
            <div>
                <img src="./imgsrc/settings.png">
                <p></p>
                <a href="ProfileSettings">账户设置</a>
            </div>
            <div>
                <img src="./imgsrc/order.PNG">
                <p></p>
                <a href="ProfileOrder">全部订单</a>
            </div>
            <div>
                <img src="./imgsrc/coupon.PNG">
                <p></p>
                <a href="ProfileCoupon">红包卡券</a>
            </div>
            <div>
                <img src="./imgsrc/exit.png" >
                <p></p>
                <a href="login.jsp">退出登录</a>
            </div>
        </div>
        <div class="note">
            <h2>个人简介</h2>
        </div>
    </div>
    </div>
    </section>
  </article>
</div>
</body>
</html>