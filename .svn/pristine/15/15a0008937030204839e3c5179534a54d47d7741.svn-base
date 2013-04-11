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
    <base href="<%=basePath%>" />
    
    <title>修改密码-工作宝招聘网站</title>
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
  <%User userinfo=null;
   if(session.getAttribute("flag")!= null){  
	   userinfo=(User)request.getAttribute("userInfo");
	   String mainurl = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
	   String userurl = response.encodeURL("userServlet?info=userInfo");
	   String updateurl = response.encodeURL("userServlet?info=queryUpdateUserinfo");
	   String actionurl = response.encodeURL("userServlet?info=pwModify");
	   String inviteurl = response.encodeURL("invitePage.jsp");
	   String wageurl = response.encodeURL("userServlet?info=wage");
 %> 
 <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
 
  <div class="title m-b-10">密码修改</div>
  <div class="p-l-8 m-b-10"><a href="<%=mainurl%>">回到首页</a>&nbsp;|&nbsp;<a href="<%=userurl%>">个人信息</a>&nbsp;|&nbsp;<a href="<%=updateurl%>">修改资料</a></div>
 
 <div class="special p-l-8">
 <form method="post" action="<%=actionurl%>">
    <div>
    <%if(session.getAttribute("firstlogin")!=null){
    	if(session.getAttribute("firstlogin").equals("1")){
    	%><p class="m-b-10" style="color:#1E9ACA">建议您更改密码,保证账号安全<br/></p>
    	<%}else{%>   		
    		<div><strong>原始密码：</strong></div>
        	<div class="m-b-10"><input type="password" name="oldpw" maxlength="18"/></div>
    	<%}
    	}else{%>
    		<div><strong>原始密码：</strong></div>
    		<div class="m-b-10"><input type="password" name="oldpw" maxlength="18"/></div>
    <%} %>
    <div><strong>新密码(4-18位)：</strong></div>
    <div class="m-b-10"><input type="password" name="newpw" maxlength="18"/></div>
    <div><strong>确认密码(4-18位)：</strong></div>
    <div class="m-b-5"><input type="password" name="newpw2" maxlength="18"/></div>
    <%if(request.getAttribute("errMassage")!=null){
 	  String errMassage = (String)request.getAttribute("errMassage");
	 %>
	 <div class="m-b-5" style="color:#E3332F"><%=errMassage %></div>
	 <%} %>
	 <div class="m-b-10"><input class="btn-s" type="image" src="images/submitModify.png" alt="完成修改"/>&nbsp;&nbsp;<a href="<%=userurl%>"><img src="images/notModify.png" alt="暂不修改"/></a></div>
     
    </div>
 </form>
 </div>
 <% 
   }else{            
 %> 
   <div>您好&nbsp;游客，[<a href="login.jsp">登录</a>/<a href="register.jsp">注册</a>]</div>
<div>请先登录再进行个人信息管理！</div>
 <%} %>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>

</html>
