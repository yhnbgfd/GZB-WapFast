<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" import="org.apache.commons.logging.Log,org.apache.commons.logging.LogFactory" %>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>404-工作宝招聘网站</title>
<%if(session.getAttribute("version")!=null){ 
	  if(session.getAttribute("version").equals(2)){
	%>
	<link rel="stylesheet" type="text/css" href="/images/styles.css"/>
	<%}else{%>
	<link rel="stylesheet" type="text/css" href="/images/base.css"/>
	<%}
	}else{session.setAttribute("version",2);
	%>
	<link rel="stylesheet" type="text/css" href="/images/styles.css"/>
	<%} %>
<link rel="shortcut icon" href="/images/favicon.ico" />
</head>
<body>
<%@ include file="Fragment/head.jsp"%>
<%
String userAgent = request.getHeader("User-Agent"); 
Log log = LogFactory.getLog(getClass()); 
//out.print(userAgent+"<br /><br />");
log.error("## The page of 'error.jsp' has been triggered at this time by xx and the UA is : "+userAgent);
%>
<div style="width:240px;text-align:center;">
	<p>系统忙，请稍后再试。</p>
	<p><a href="/index.jsp">点击返回首页</a></p>
</div>

</body>
</html>