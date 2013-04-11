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
    <title>工作宝招聘平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="shortcut icon" href="images/favicon.ico" />
  </head>
  
  <body>
  <%@ include file="Fragment/head.jsp"%> 
  <%
  if(session.getAttribute("version")== null)
  		session.setAttribute("version",2);
  String url = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
  response.sendRedirect(url);
  %>
    <p>如无自动跳转，请点击<a href="<%=url%>">首页</a></p>  
  </body>
</html>
