<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%if(session==null)
{
	response.sendRedirect("toLogin.html");
}else if(session.getAttribute("username") == null)
{
	response.sendRedirect("toLogin.html");
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<link rel="stylesheet" href="css/pure/menu.css">
<link rel="stylesheet" href="css/pure/p.css">
<link rel="stylesheet" href="css/pure/bb.css">
<link rel="stylesheet" href="css/pure/bookshop.css">
<title>Order</title>
</head>
<body>
<div id="layout" style="padding-left:143px">
	<div id="menu">
	<div class="pure-menu pure-menu-open">
            <a class="pure-menu-heading" href="#">e-book</a>
            <ul class="pure-menu-list">
			           <li class="menu-item-divided"><a href="Index.html">首页</a></li>
			           
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
			           <li class="pure-menu-item pure-menu-selected"><a href="showorder">订单</a></li>
			           <li class="pure-menu-item menu-item-divided"><a href="Statistics.jsp">统计</a></li>
			           <li class="pure-menu-item"><a href="Intro.html">说明</a></li>
			 </ul>
        </div>
    </div>
    
    <div id="main">
    
    <div class="header">
	<h1>Orders</h1>
	</div>
	
	<div class="order_content">
	<br>

	<table class="pure-table pure-table-horizontal" width="730">
    <thead>
        <tr>
            <th>Book</th>
            <th>Price</th>
            <th>Num</th>
            <th>Date</th>
        </tr>
    </thead>

    <tbody>
    	<s:iterator value="orders" var="ord">
        	<tr>
            	<td><s:property value="#ord.bookname"/></td>
            	<td><s:property value="#ord.bookprice"/></td>
            	<td><s:property value="#ord.booknum"/></td>
            	<td><s:property value="#ord.timestamp"/></td>
        	</tr>
    	</s:iterator>
    </tbody>
	</table>
	</div>
	
	</div>
</div>
</body>
</html>