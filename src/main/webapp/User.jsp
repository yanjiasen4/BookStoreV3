<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<link rel="stylesheet" href="css/pure/menu.css">
<link rel="stylesheet" href="css/pure/p.css">
<link rel="stylesheet" href="css/pure/bb.css">
<link rel="stylesheet" href="css/pure/bookshop.css">

<title>BookStore</title>
</head>
<body>
<div id="layout">
	<a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

	<div id="menu">
	<div class="pure-menu pure-menu-open">
            <a class="pure-menu-heading" href="#">e-book</a>
            <ul>
			           <li class="pure-menu-item"><a href="Index.html">首页</a></li>
			           <li class="menu-item-divided pure-menu-selected"><a href="User.jsp"><%=session.getAttribute("username")%></a></li>
			           <li class="pure-menu-item"><a href="Register.jsp">注册</a></li>
			           <li class="pure-menu-item"><a href="Manage.jsp">管理</a></li>
			           <li class="pure-menu-item"><a href="showcart">购物车</a></li>
			           <li class="pure-menu-item"><a href="showorder">订单</a></li>
			           <li class="pure-menu-item menu-item-divided"><a href="Statistics.jsp">统计</a></li>
			           <li class="pure-menu-item"><a href="Intro.html">说明</a></li>
			 </ul>
        </div>
    </div>
</div>

<div id="main">
<div class="header">
	<h1>User administer</h1>
    <div class="content">
    	<div class="pure-1">
    		<a class="pure-button" href="logoff">注销登录</a>
    	</div>
    	<br>
    	<div class="pure-1">
    		<form class="pure-form pure-form-aligned" action="changepsw">
    			<fieldset>
        			<div class="pure-control-group">
            			<label for="name">New Password</label>
            			<input id="name" type="text" name="npassword">
					</div>
					<div class="pure-controls">
		 				<button type="submit" class="pure-button pure-button-primary">Submit</button>
		 			</div>
		 		</fieldset>
		 	</form>
		</div>
	</div>
</div>
</div>
</body>
</html>