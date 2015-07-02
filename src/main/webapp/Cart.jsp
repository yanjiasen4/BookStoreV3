<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%if(session==null)
{
	response.sendRedirect("toLogin.html");
} else if(session.getAttribute("username")==null) 
{
	response.sendRedirect("toLogin.html");
}
%>
<html>
<head>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<link rel="stylesheet" href="css/pure/menu.css">
<link rel="stylesheet" href="css/pure/p.css">
<link rel="stylesheet" href="css/pure/bb.css">
<link rel="stylesheet" href="css/pure/bookshop.css">

<title>BookStore-Cart</title>
</head>
<body>
<div id="layout" style="padding-left:143px">
	<a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

	<div id="menu">
	<div class="pure-menu pure-menu-open">
            <a class="pure-menu-heading" href="#">e-book</a>
            <ul>
			           <li class="pure-menu-item"><a href="Index.html">首页</a></li>			          
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
			           <li class="menu-item-divided pure-menu-selected"><a href="showcart">购物车</a></li>
			           <li class="pure-menu-item"><a href="showorder">订单</a></li>
			           <li class="menu-item-divided"><a href="Statistics.jsp">统计</a></li>
			           <li class="pure-menu-item"><a href="Intro.html">说明</a></li>
			 </ul>
        </div>
    </div>

<div id="main">
	<div class="header">
	<h1>Cart</h1>
	</div>
	
    <div class="content">
    <%if(session == null || session.getAttribute("username") == null)
    { %>
    	<H3>请先登录</H3>
   	 <%
    } 
    else
    {
    	if(request.getParameter("empty").equals("1"))
    	{ %>
	    	<p>购物车是空的，去看看有什么自己喜欢的书吧！</p>
    	<% 
    	}
    	else
    	{
    	%>
   		<s:iterator value="carts" var="car">
    		<div class="box">
    			<img alt="图片加载失败" height="160" width="160" src="<s:property value="#car.bookpic"/>">
    			<h2>书名：<s:property value="#car.bookname"/></h2>
   				<h4 class="price">单价：<s:property value="#car.bookprice"/></h4> 
   				<h4>数量：<s:property value="#car.booknum"/></h4>
        	</div>  	
    	</s:iterator>
    	<div style="clear:both;"></div>
    	<div>
    	<h2>合计：${sessionScope.total_price}￥ </h2>
    	<a id="buy" class="pure-button pure-button-primary" href="buy.action">立即购买</a>
    	<a id="clear" class="pure-button pure-button-primary" href="clearcart.action">清空购物车</a>
    	</div>
    	<% 
    	}
    }
    %>
    </div>
    

</div>
</div>

</body>
</html>