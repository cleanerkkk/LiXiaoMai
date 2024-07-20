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

    .wrap ul {
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
        box-shadow: 0px 0px 12px 2px #152c3c;
    }

    .wrap ul li:nth-child(1) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(30deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(2) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(60deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(3) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(90deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(4) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(120deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(5) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(150deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(6) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(180deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(7) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(210deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(8) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(240deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(9) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(270deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(10) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(300deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(11) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(330deg);
        transform-origin: center 315px 10px;
    }

    .wrap ul li:nth-child(12) {
        position: absolute;
        left: 50%;
        margin-left: -90px;
        transform: rotate(360deg);
        transform-origin: center 315px 10px;
    }
    /*  依次类推到第12个... */

    .wrap ul li:nth-child(odd):after {
        content: '';
        display: block;
        width: 0;
        height: 0;
        border-left: 89px solid transparent;
        border-right: 89px solid transparent;
        border-top: 308px solid #1b7b54;
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

      <div class="wrap">
          <ul class="turntable">
              <li id="num2"> <div class="title">2</div> </li>
              <li id="num3"> <div class="title">3</div> </li>
              <li id="num4"> <div class="title">4</div> </li>
              <li id="num5"> <div class="title">5</div> </li>
              <li id="num6"> <div class="title">6</div> </li>
              <li id="num7"> <div class="title">7</div> </li>
              <li id="num8"> <div class="title">8</div> </li>
              <li id="num9"> <div class="title">9</div> </li>
              <li id="num10"> <div class="title">10</div> </li>
              <li id="num11"> <div class="title">11</div> </li>
              <li id="num12"> <div class="title">12</div> </li>
              <li id="num1"> <div class="title">1</div> </li>
          </ul>
          <div class="pointerDisk">
              <span class="triangleUp"></span>
              <p class="internal">开始抽奖</p>
          </div>
      </div>
      <script>
          window.onload = function(){


              function getClassName(tagName, classname) {
                  if (document.getElementsByClassName) {
                      return document.getElementsByClassName(classname);
                  } else {
                      var results = [];
                      var elems = document.getElementsByTagName('*');
                      for (var i = 0; i < elems.length; i++) {
                          if (elems[i].className.indexOf(classname) != -1) {
                              results[results.length] = elems[i];
                          }
                      }
                      return results;
                  }
              }

              var turntable = getClassName('ul','turntable')[0];
              var result = getClassName('p','result')[0];

              function CreateParameter (turntableDom,resultDom){
                  //参数
                  this.turntable = turntableDom;//转盘dom
                  this.result = resultDom;//结果dom
                  this.flag = true;//开关设置
                  this.times = 20;//执行时间
                  this.turns = Math.ceil(Math.random()*3+1);//旋转圈数
                  this.speed = Math.floor(Math.random()*5)+3;//速度
                  this.turnNum = 12;//格子总数
                  this.deg = 360/this.turnNum;//转盘所对应的度数
                  this.initital = 0;//转盘旋转角度
                  this.turnBuffer = this.deg/2-5;//每个格子对应的度数缓冲区
                  this.num = Math.ceil(Math.random() * this.turnNum)-1;//随机抽取的位置
                  this.MathNum = 14;//重新编排编号数字与转盘对应，14是因为i=1时已经减去了一个
                  this.arr =  this.NewArr(this.MathNum,this.deg,this.turnBuffer);//转盘角度参数
                  this.initialDegMini = this.turns*360+this.arr[this.num][2];//初始最小值度数
                  this.initialDegMax = this.turns*360+this.arr[this.num][1];//初始最大值度数
                  this.MathAngle = Math.ceil(Math.random()*(this.initialDegMax-this.initialDegMini) )+this.initialDegMini;//转盘停止的角度
                  this.text ='结果为：'+ this.arr[this.num][0];

                  console.log(this.arr[this.num])
                  console.log(this.speed)
              }

              CreateParameter.prototype.NewArr = function (MathNum,deg,turnBuffer){
                  //计算转盘的各个角度参数
                  var arr = [];
                  for(let i = 1;i<=this.turnNum;i++){
                      let num = MathNum-i;//做倒叙,跳过1
                      if(i==1){num = i}
                      let turnDeg = deg*i-deg;
                      arr.push([num,turnDeg+turnBuffer,turnDeg-turnBuffer]) ;
                  }
                  return arr;
              }

              CreateParameter.prototype.OperatingDom = function(dom){
                  //dom节点操作
                  if(dom == 'rotate'){
                      this.turntable.style.transform ="rotate("+this.initital+"deg)";
                  }

                  if(dom == 'innerHTML'){
                      this.result.innerHTML = this.text;
                  }

              }

              CreateParameter.prototype.judgment = function(){
                  //判断
                  if(this.initital >= this.initialDegMini-420){

                      if(this.speed>0.9){
                          this.speed = this.speed-0.05;
                      }

                  }

                  if(this.initital >= this.MathAngle ){
                      this.OperatingDom('innerHTML')
                      this.reset();
                  }else{
                      //setTimeout内部指针会混乱所以需要外部定义
                      var _this = this;
                      setTimeout(function(){
                          _this.star()
                      },this.times)
                  }
              }

              CreateParameter.prototype.reset = function (){
                  //重置
                  this.initital = this.MathAngle-(parseInt(this.MathAngle/360)*360);
                  this.OperatingDom('rotate')
                  this.num =  Math.ceil(Math.random()*12)-1;
                  this.turns = Math.ceil(Math.random()*5+1);
                  this.speed = Math.floor(Math.random()*3)+3;
                  this.initialDegMini = this.turns*360+this.arr[this.num][2];
                  this.initialDegMax = this.turns*360+this.arr[this.num][1];
                  this.MathAngle = Math.ceil(Math.random()*(this.initialDegMax-this.initialDegMini) )+this.initialDegMini;
                  this.flag = true;
                  this.text ='结果为：'+ this.arr[this.num][0];

              }

              CreateParameter.prototype.star = function(){
                  this.OperatingDom('rotate');//让转盘旋转
                  this.initital+=this.speed;//增加角度
                  this.judgment();//运行判断
              }

              var ProxySingleParameter = (function(){

                  var  instance =  new CreateParameter(turntable,result);//存储参数
                  var flag = instance.flag;//开关判断是否正在运行中

                  return function (turntable,result){
                      if(!flag){
                          instance = new CreateParameter(turntable,result);//更新参数
                          console.log(instance)
                      }
                      return instance;
                  }

              })()
              document.onclick = function(e){
                  var target = e.target || e.srcElement;
                  if(target.className == 'internal'){
                      let Parameter = new ProxySingleParameter(turntable,result);
                      if(Parameter.flag){
                          Parameter.result.classList.remove('none');
                          Parameter.star();
                          Parameter.flag = false;
                      }else{
                          console.log(Parameter.arr[Parameter.num]);
                      }
                  }
              }
          }
      </script>
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
      <div>
        <img src="./imgsrc/settings.png" alt="收藏">
        <p></p>
        <a href="profileSettings.jsp">账户设置</a>
      </div>
      <div>
        <img src="./imgsrc/order.PNG" alt="浏览记录">
        <p></p>
        <a href="profileOrder.jsp">全部订单</a>
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