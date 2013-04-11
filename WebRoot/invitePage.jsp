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
    
    <title>邀请好友-工作宝招聘网站</title>
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
	   userinfo=(User)request.getAttribute("userInfo");
	   String mainurl = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
	   String userurl = response.encodeURL("userServlet?info=userInfo");
	   String updateurl = response.encodeURL("userServlet?info=queryUpdateUserinfo");
	   String modifyurl = response.encodeURL("passwordModify.jsp");
	   String actionurl = response.encodeURL("userServlet?info=invite");
	    String wageurl = response.encodeURL("userServlet?info=wage");
 %> 
  <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
  <jsp:include page="Fragment/Navbar.jsp" ></jsp:include>
  <div class="title p-b-5">邀请好友</div>
  <%if(request.getAttribute("errMassage")!=null){
 	  String errMassage = (String)request.getAttribute("errMassage");
 %>
 <div class="p-l-8 m-b-5" style="color:#E3332F"><%=errMassage %></div>
 <%} %>
  <form method="post" action="<%=actionurl%>">
  <div class="special p-l-8 p-t-5">
  	 <%if(request.getAttribute("CheckInMassage")!=null){
 	  String CheckInMassage = (String)request.getAttribute("CheckInMassage");
	 %>
	 <div class="m-b-10"><%=CheckInMassage %></div>
	 <%} %>
    <p>请输入好友手机号码</p>
    <input class="m-b-10" type="text" name="friendPhone" maxlength="11" />
    <div class="m-b-10" style="color:#1E9ACA">我们将为您发送邀请短信到好友手机<br/>短信不收取任何费用，马上邀请吧</div>
  <p class="p-b-10"><input class="btn-s" type="submit" value="马上发送"/></p>
  </div>
 </form>
 <% 
   }else{    
     session.setAttribute("returl", "invitePage.jsp");        
 	 String errMassage = "<div>请先登录,再邀请好友！</div>";
	 request.setAttribute("errMassage", errMassage);
 	 request.getRequestDispatcher("login.jsp").forward(request,
						response);
  
  } %>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>

</html>
