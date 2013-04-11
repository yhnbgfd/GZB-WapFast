<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.User"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>提示-工作宝招聘网站</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<%if(session.getAttribute("refresh") != null) {
	 	if(session.getAttribute("refresh").equals(1)&&session.getAttribute("refreshURL") != null) {	 	
	%>	
	<meta http-equiv="refresh" content="3;URL=<%=session.getAttribute("refreshURL")%>"/>
	<%session.removeAttribute("refresh");
	  session.removeAttribute("refreshURL");
	}} %>
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
    String errMassage = (String)request.getAttribute("errMassage");	    
    if(session.getAttribute("flag")!= null){ 
     %>
      <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
      <jsp:include page="Fragment/Navbar.jsp" ></jsp:include>
     <%} else{%>
    <!-- <div>您好&nbsp;游客，[<a href="login.jsp">登录</a>/<a href="register.jsp">注册</a>]</div>-->
     <%} %>
      
      <div  class="title m-b-10">提示</div>
     <div class="p-l-8 m-b-10"><%=errMassage %></div>
     <% 
     if(request.getAttribute("againURL")!=null){
     	 String url = response.encodeURL((String)request.getAttribute("againURL"));
 	 %>
 	 <p class="p-l-8">还没收到短信，<a href="<%=url%>">再发一次</a></p>
 	 <p class="p-l-8 m-b-10" style="color:#E3332F">(1分钟内只能发一次)</p>
 	<%}%>
     
     <jsp:include page="Fragment/footer.jsp" ></jsp:include> 
  </body>
</html>
