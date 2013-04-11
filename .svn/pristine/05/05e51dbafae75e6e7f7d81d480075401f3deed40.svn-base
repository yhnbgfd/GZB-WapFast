<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    
    <title>登录-工作宝招聘网站</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<%session.removeAttribute("flag");
      session.removeAttribute("uid");
      session.removeAttribute("uname");
      session.removeAttribute("realname");
	  if(session.getAttribute("version")!=null){ 
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
	<p class="head m-b-10">登录</p>
	<p class="m-b-10 p-l-8 "><a href="index.jsp">返回首页</a>&nbsp;|&nbsp;<a href="register.jsp">注册账号</a></p>
	<%if(request.getAttribute("errMassage")!=null){
 	  String errMassage = (String)request.getAttribute("errMassage");
	 %>
	 <div class="m-b-10 p-l-8" style="color:#E3332F"><%=errMassage %></div>
	 <%} %>
	<div>
	<form class="p-l-8" method="post" action="userServlet?info=userLogin">
	<p> 手机号：<br/><input class="m-b-10" type="text" name="uname" maxlength="18"/></p>
    <p> 密码：<br/><input class="m-b-10" type="password" name="upw" maxlength="18"/></p>
    <p class="m-b-10"><input class="btn-s" type="submit" value="登    陆"/>&nbsp;&nbsp;<a href="forgetPassword.jsp">忘记密码</a></p>     
    </form> 
    </div>
<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
</body>

</html>
