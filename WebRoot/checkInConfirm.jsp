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

    <title>确认报名-工作宝招聘网站</title>
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
  		String returl;
   		if(request.getAttribute("type").equals("0"))
   			returl = response.encodeURL("recruitServlet?info=queryRecruitInfo&amp;id="+request.getAttribute("id"));
   		else 
   			returl = response.encodeURL("recruitServlet?info=queryLabourInfo&amp;id="+request.getAttribute("id"));
   		String checkinurl = response.encodeURL("checkInServlet?info=checkIn&amp;id="+request.getAttribute("id")+"&amp;type="+request.getAttribute("type"));
 %> 
 <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
  <jsp:include page="Fragment/Navbar.jsp" ></jsp:include>
  <div class="title">确认报名</div>
  <div class="special p-l-8">
  <div style="color:#1E9ACA" class="p-t-5">
	  <%if(request.getAttribute("LastCheckDate")!=null) {%><div>上次报名时间：<%=request.getAttribute("LastCheckDate")%></div><%}%>	
	 <div>确认报名后12个小时之内不能再次报名</div>
	  <div>取消报名请拨打免费客服电话:<br/>0756-8500000转828</div>
  </div>
  <form method="post" action="<%=checkinurl%>">
  <div class="p-t-5 p-b-10"><input class="btn-s" type="image" src="images/checkInConfirm.png" alt="确认报名"/>
  					&nbsp;&nbsp;<a href="<%=returl %>"><img id="img" src="images/back.png" alt="返回"/></a></div>
  </form>
  </div>
  <% 
   }else{            
 %> 
   <div>您好&nbsp;游客，[<a href="login.jsp">登录</a>/<a href="register.jsp">注册</a>]</div>
   <div>马上注册即可查看更多更详细的招聘信息！</div>
 <%} %>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>
</html>
