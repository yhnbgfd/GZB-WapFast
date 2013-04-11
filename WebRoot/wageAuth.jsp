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
    
    <title>查看工资-工作宝招聘网站</title>
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
  
  <%    User userinfo=null;
   if(session.getAttribute("flag")!= null){  
	  
	   String actionurl = response.encodeURL("userServlet?info=wageAuth");
	   String notEditurl = response.encodeURL("userServlet?info=wage&amp;Edit=false");
	   // String wageurl = response.encodeURL("userServlet?info=wage");
 %> 
  <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
  <jsp:include page="Fragment/Navbar.jsp" ></jsp:include>
  <div class="title m-b-5">查看工资</div>
  <%if(request.getAttribute("errMassage")!=null){
 	  String errMassage = (String)request.getAttribute("errMassage");
 %>
 <div class="p-l-8 m-b-5" style="color:#E3332F"><%=errMassage %></div>
 <%} %>
  <form method="post" action="<%=actionurl%>">
  <div class="special p-l-8">
  	 <%if(request.getAttribute("firstMassage")!=null){
 	  String firstMassage = (String)request.getAttribute("firstMassage");
	 %>
	 <div style="color:#1E9ACA" class="m-b-10 p-t-5"><%=firstMassage %></div>
	 <%} %>
	 <div style="color:#1E9ACA" class=" p-t-5">初始密码是身份证号码第12位到第17位，一共6个数字</div>
	 <div style="color:#1E9ACA" class="m-b-5 p-t-5">例如：张三身份证号码是450922198809120538，那他的初始密码是912053</div>
    <div><strong>工资密码：</strong></div>
    <input class="m-b-5" type="password" name="wagePW" maxlength="18" />
    <%if(request.getAttribute("firstMassage")!=null){%>
    <div><strong>确认工资密码：</strong></div>
    <input class="m-b-10" type="password" name="wagePW2" maxlength="18" />
    <div class="p-b-10"><input class="btn-s" type="image" src="images/submitModify.png" alt="完成修改"/>&nbsp;&nbsp;<a href="<%=notEditurl%>"><img src="images/notModify.png" alt="暂不修改"/></a></div>
    <%} else{%>   
    <div class="m-b-5"><a href="contactus.jsp">忘记密码?</a></div>
    <div class="p-b-10"><input class="btn-s" type="submit" value="确   认"/></div>
    <%} %>
  
  </div>
 </form>
 <% 
   }else{    
     session.setAttribute("returl", "invitePage.jsp");        
 	 String errMassage = "<div>请先登录,再查看工资！</div>";
	 request.setAttribute("errMassage", errMassage);
 	 request.getRequestDispatcher("login.jsp").forward(request,
						response);
  
  } %>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>

</html>
