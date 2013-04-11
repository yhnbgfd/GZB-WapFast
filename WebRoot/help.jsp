<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>帮助-工作宝招聘网站</title>
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
	}else{	
  		session.setAttribute("version",2);
  	%>
	<link rel="stylesheet" type="text/css" href="images/styles.css"/>
	<%} %>
	<link rel="shortcut icon" href="images/favicon.ico" />
  </head>
  
  <body>
    <%@ include file="Fragment/head.jsp"%> 

<div class="title">1.如何注册成为网站会员&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">返回</a></div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">在首页上方点击“注册”进入注册页面，按照提示填写会员注册信息,系统将会根据您输入的手机发送一条注册验证短信,用户回复短信(只收取基本信息费用),完成会员注册。</div>

<div class="title">2.如何应聘感兴趣的招聘信息&nbsp;&nbsp;<a href="index.jsp">返回</a></div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">点击感兴趣的招聘信息下方的“我要报名”按钮，工作人员通过人工服务方式通知您应聘的相关事宜。（需要完善会员信息并且在登录状态下，才可以进行工作报名）</div>

<div class="title">3.如何完善个人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">返回</a></div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">登录状态下，在首页上方点击“会员中心”进入个人信息页面，根据提示可以完善会员的个人简历信息。完善个人信息可方便您登记招聘。</div>	

<div class="title">4.忘记密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">返回</a></div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">如果您已注册为本网站的会员，但是忘记了密码，可以在登录页面点击“忘记密码”链接，输入您的用户名，系统将自动发送您的密码到您的注册手机上，请注意查收。</div>	

 <div class="title">5.关于12小时重复登记&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">返回</a></div>
 	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">如果您在12小时之内已经登记过一条招聘信息，系统则不允许您登记另外一条招聘信息</div>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>
</html>
