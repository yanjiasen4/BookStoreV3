<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<script language="javascript" type="text/javascript">
function addtocar(name){
	  <%if(session==null){response.sendRedirect("toLogin.html");} 
	  else if(session.getAttribute("username")==null){response.sendRedirect("toLogin.html");}%>
	  var offset = $("#end").offset();   
	  var addcar = $(name); 
	  var img = addcar.parent().find('img').attr('src'); 
	  var flyer = $('<img class="u-flyer" src="'+img+'">'); 
	  flyer.fly({ 
	   		  start: { 
	                left: event.pageX, //开始位置（必填）#fly元素会被设置成position: fixed 
	                top: event.pageY //开始位置（必填） 
	            }, 
	            end: { 
	                left: offset.left+10, //结束位置（必填） 
	                top: offset.top+10, //结束位置（必填） 
	                width: 0, //结束时宽度 
	                height: 0 //结束时高度 
	            }, 
	            onEnd: function(){ //结束回调 
	                $("#msg").show().animate({width: '250px'}, 200).fadeOut(1000); //提示信息 
	                addcar.css("cursor","default").removeClass('orange').unbind('click'); 
	                this.destory(); //移除dom 
	            } 
	           }); 
	  window.location.href = "add2car.action?bookname="+name.value;
}
</script>

<head>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<link rel="stylesheet" href="css/pure/menu.css">
<link rel="stylesheet" href="css/pure/p.css">
<link rel="stylesheet" href="css/pure/bb.css">
<link rel="stylesheet" href="css/pure/bookshop.css">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/jquery.fly.min.js"></script>

<title>BookStore</title>
</head>
<body>

  
 <script language="javascript">
 function gotoBuy(){
	 var para=document.getElementById("buy");
	 window.location.replace("Buy.jsp");
 }
 </script>
 
<div id="layout" style="padding-left:143px">
	<div id="menu">
	<div class="pure-menu pure-menu-open">
            <a class="pure-menu-heading" href="#">e-book</a>
            <ul class="pure-menu-list">
			           <li class="menu-item-divided pure-menu-selected"><a href="Index.html">首页</a></li>
			           
            			<% if(request.getSession().getAttribute("username") == null)
            				{
            			%>
			           <li class="pure-menu-item"><a href="Login.jsp">登录</a></li>
			           <%  } else 
			               {
			            %>
			           <li class="pure-menu-item"><a href="User.jsp">${sessionScope.username}</a></li>
			           <%  } %>
			           <li class="pure-menu-item"><a href="Register.jsp">注册</a></li>
			           <li class="pure-menu-item"><a href="Manage.jsp">管理</a></li>
			           <li class="pure-menu-item"><a href="showcart">购物车</a></li>
			           <li class="pure-menu-item"><a href="showorder">订单</a></li>
			           <li class="pure-menu-item menu-item-divided"><a href="Statistics.jsp">统计</a></li>
			           <li class="pure-menu-item"><a href="Intro.html">说明</a></li>
			 </ul>
        </div>
    </div>
    
	<div id="main">

	<div class="header">
	<h1>E-book</h1>
	
	<h2>Start your inspiration</h2>
	</div>
	
	
	<div class="content">

	<br>
	<div class="search">
	<form class="pure-form" action="searchbook">
    <fieldset>
        <input type="text" name="input" placeholder="input what you want">
        <button type="submit" class="pure-button pure-button-primary">Search</button>
    </fieldset>
	</form>
	</div>
	
	<s:iterator value="books" var="id">
		<div class="box">
    		<img alt="图片加载失败" height="160" width="160" src="<s:property value="#id.Pic"/>">
    		<h2><s:property value="#id.BookName"/></h2>
    		<h3><s:property value="#id.Author"/></h3>
   			<h4 class="price"><s:property value="#id.Price"/></h4>
 			<button id="buy" class='pure-button pure-button-disabled' type='button' style="float:left  position:absolute; right:300px top:-180px" value="<s:property value="#id.BookName"/>" onclick="gotoBuy()">buy!</button>
    	    <button id="add" class='pure-button' type='button' style="float:left  position:absolute; right:300px top:-180px" value="<s:property value="#id.BookName"/>" onclick="addtocar(this)">Add</button>
        </div> 
    </s:iterator>
	<div style="clear:both;"></div>
	</div>
	</div>

<div class="m-sidebar"> 
    <div class="cart"> 
        <i id="end"></i> 
        <span>购物车</span> 
    </div> 
</div> 
<div id="msg">已成功加入购物车！</div> 

</div>

</body>
</html>
