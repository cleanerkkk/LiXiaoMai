<%@ page import="com.example.lixiaomai.backend.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lixiaomai.backend.entity.Business" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>理小卖外卖平台</title>
  <link rel="stylesheet" href="css/index.css" type = "text/css">
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




<a href="cart"> 购物车 </a>




<div class="container">
  <article id="main" display="flex">
  <%
    List<Business> list = (List<Business>) request.getAttribute("BusinessList");
    Map<Integer, List<Product>> productMap = (Map<Integer, List<Product>>) request.getAttribute("ProductMap");
    Integer currentPage =(Integer) request.getAttribute("currentPage");
    Integer totalPage = (Integer) request.getAttribute("totalPages");
    if ((list != null && !list.isEmpty())){
        for (Business business : list){
        String BusinessName=business.getName();
        String BusinessAddress=business.getAddress();
        int BusinessId=business.getId();
        %>
        <div class="merchant" style="display: flex !important;
    background-color: #ffffff !important;
    margin-bottom: 20px !important;
    border: 1px solid #ddd !important;
    border-radius: 5px !important;
    overflow: hidden !important;">
            <div class="merchant-image">
                <img src="./imgsrc.business<%=BusinessId%>.jpg" style="width: 150px;
    height: 150px;
    object-fit: cover;">
            </div>
            <div class="merchant-info" style="    flex: 1;
    padding: 20px;">
                <h2><a href="BusinessDetailsServlet?id=<%=BusinessId%>"> <%=BusinessName%></a></h2>
                <p><%=BusinessAddress%></p>
                <div class="dish-images" style="display: flex;
    gap: 10px;">
                <%
                List<Product> product = productMap.get(business.getId());
                int len=product.size();
                if(len>=3){
                    len=3;
                }
                for(int i=0;i<len;i++){
                    Product product1=new Product();
                    product1=product.get(i);
                    int ID=product1.getId();
                    String ProductName=product1.getName();
                    String ProductDescription=product1.getDescription();
                    %>
                    <img src="<%=product1.getPitcutreUrl() %>" style="width: 80px;
    height: 80px;
    object-fit: cover;
    border-radius: 5px;">
                    <p><%=ProductName%></p>
                    <p><%=ProductDescription%></p>
                    <%
                }%>
                </div>
            </div>
        </div>
<%
        }
  %>

    <%

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
        <div class="cutLine">
            <p>    </p>
        </div>
        <div class="note">
            <h2>个人简介</h2>
            <p>你好，我是小明，一名大四的大学生，目前就读于一所普通的大学，主修计算机科学。我最大的爱好之一就是点外卖。有人可能会觉得点外卖是一件平凡无奇的事，但对我来说，这不仅仅是满足口腹之欲，更是一种生活方式和态度。

                我从小就对美食充满了浓厚的兴趣。小时候，家里开了一家小餐馆，我经常在厨房里帮忙，从洗菜、切菜到炒菜，无所不做。虽然那时候的任务比较简单，但这段经历让我对食物有了深刻的认识。我不仅学会了如何烹饪，还了解了各种食材的搭配和美食背后的文化故事。然而，随着学业的加重，我没有太多时间亲自下厨，这时候，外卖成了我生活中的重要部分。

                说到外卖，我可以算得上是个行家。我喜欢尝试各种不同的美食，从街头小吃到高档餐厅的招牌菜，我都愿意一试。从中餐、西餐、日料到韩餐、泰餐，我都涉猎广泛。我不仅仅是为了吃饱，更是在寻找和体验每一种食物带来的独特味觉享受。

                每当有新的外卖平台或新的餐厅上线，我都会第一时间尝试。在点餐时，我会详细研究每道菜品的介绍，查看用户的评价和推荐，确保每次点的外卖都是一次美食的享受。我还喜欢和朋友们分享我的外卖经验，给他们推荐好吃的店铺和菜品。我的外卖评测和推荐，已经成为朋友圈里的一大热门话题。

                当然，点外卖不仅仅是为了满足口腹之欲，它还给我带来了很多便利。作为一名计算机科学专业的学生，我的学习任务非常繁重，常常需要在实验室或图书馆里待很长时间。点外卖可以节省很多做饭的时间，让我有更多的精力投入到学习中。同时，外卖服务也非常方便，随时随地都可以点餐，无论是在宿舍、教室还是实验室，都能享受到热腾腾的美食。

                点外卖的过程也让我学会了很多生活技能。首先是时间管理。每次点外卖，我都会根据自己的学习和生活安排，合理安排点餐的时间，确保在最需要的时候能够及时拿到饭菜。其次是财务管理。为了控制开支，我会定期统计自己的外卖花费，制定合理的预算，避免过度消费。此外，点外卖还让我学会了如何与外卖员沟通，如何解决订单中的各种问题，这些都是非常实用的生活技能。

                除了享受美食，点外卖还让我有了更多的社交机会。每次点外卖，我都会和宿舍的室友们一起分享，我们会一起讨论哪家餐厅好吃，哪道菜值得推荐。这种交流不仅增进了我们的感情，也让我们的宿舍生活更加丰富多彩。我们还会一起组团点餐，享受各种优惠活动，既省钱又开心。

                作为一名计算机科学专业的学生，我对外卖平台的技术实现也非常感兴趣。我经常研究各大外卖平台的用户界面和功能设计，思考它们背后的技术原理。通过对这些平台的研究，我学到了很多关于用户体验设计、数据分析和算法优化的知识。这些知识不仅对我的专业学习有很大的帮助，也让我对未来的职业发展有了更多的思考和规划。

                总的来说，点外卖已经成为我生活中不可或缺的一部分。它不仅满足了我对美食的追求，也为我的学习和生活提供了很多便利。通过点外卖，我学到了很多生活技能，增加了社交机会，甚至对我的专业学习也有很大的帮助。未来，我会继续探索更多美食，享受点外卖带来的乐趣。同时，我也希望能把我的外卖经验分享给更多人，让大家一起享受美食的美好。</p>
        </div>
    </div>
    </div>
    <div class="footer">
        <footer>
            &copy; 南京理工大学 软件课程设计(I)小组作业 刘宇翔 赵曰程 仇星博 2024.7.25
        </footer>
    </div>
    </section>
  </article>
</div>
</body>
</html>