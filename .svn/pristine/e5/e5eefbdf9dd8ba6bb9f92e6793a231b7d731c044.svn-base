<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>注册-工作宝招聘网站</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<%if(session.getAttribute("version")!=null){ 
	  if(session.getAttribute("version").equals(2)){
	%>
	<link rel="stylesheet" type="text/css" href="images/styles.css"/>
	<%}else{%>
	<link rel="stylesheet" type="text/css" href="images/base.css"/>
	<%}
	}else{session.setAttribute("version",2);
	%>
	<link rel="stylesheet" type="text/css" href="images/styles.css"/>
	<%} %>
	
	<link rel="shortcut icon" href="images/favicon.ico" />	
	
  </head>
  
  <body>
  <%@ include file="Fragment/head.jsp"%>   
  <%    
   if(session.getAttribute("flag")!= null){ 
 %> 
   <p>欢迎<a href="userServlet?info=userInfo"><%= (String)session.getAttribute("uname") %></a>光临！ <a href="loginout.jsp">注销</a></p>
   <p>您已登录，请先注销再进行注册</p>
 <% 
   }else{            
 %> 
 <p class="head m-b-10">注册</p>
 <p class="m-b-10 p-l-8">如果您已注册，请<a href="login.jsp">登录</a></p>

<form class="p-l-8" method="post" action="userServlet?info=userRegister">
<div>
  	<p class="m-b-10">输入手机号码：<br/></p>
    <input class="m-b-10" type="text" name="uphone" maxlength="11" <%if(request.getAttribute("uphone")!=null){%>value="<%=request.getAttribute("uphone")%>"<%} %>/><br />
     <%if(request.getAttribute("errMassage")!=null){
 	  String errMassage = (String)request.getAttribute("errMassage");
	 %>
	 <div class="m-b-10" style="font-size:13px; color:#E3332F"><%=errMassage %></div>
	 <%} %>
    <p class="m-b-10" style="line-height:24px; color:#1E9ACA">手机号码将作为您的登录账号 <br/>
 		系统将发送密码到您的手机 <br/>
 		请留意短信通知</p>
  <p class="m-b-10"><input class="btn-s" type="submit" value="注    册"/></p>
</div>
</form>
<%} %>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>
</html>
