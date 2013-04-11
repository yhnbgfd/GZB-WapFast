<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd"> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%@ page import="servlet.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
  	<base href="<%=basePath%>" />
    <title>忘记密码-工作宝招聘网站</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
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

  <p class="head m-b-10">找回密码</p>
 
  <form class="p-l-8" method="post" action="userServlet?info=forgetPwd">
  
  	<div class="m-b-10">请输入您的手机号码：</div>
  	<div><input class="m-b-10" type="text" name="uname" maxlength="18" value=""/></div>
  	<%if(request.getAttribute("errMassage")!=null){
 	  String errMassage = (String)request.getAttribute("errMassage");
	 %>
	 <div class="m-b-10" style="color:red"><%=errMassage %></div>
	 <%} %>
  	 	<P class="m-b-10" style="color:#1E9ACA;line-height:24px;">系统将自动发送您的密码到您的注册手机上，请留意短信通知。<br /></P>
  	 	<div class="m-b-10"><input class="btn-s" type="image" src="images/confirm.jpg" alt="确认"/>&nbsp;&nbsp;<a href="login.jsp"><img src="images/back.png" alt="返回"/></a></div>

  </form>

  <jsp:include page="Fragment/footer.jsp" ></jsp:include>
  </body>
</html>
