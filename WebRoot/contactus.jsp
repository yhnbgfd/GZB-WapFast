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
    
    <title>客服-工作宝招聘网站</title>
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

<div class="title">服务热线</div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
	 
<div class="p-b-10 p-l-8 special">
<div class="p-t-5 m-b-10">交通指引热线(8:30-17:30)<br/>&nbsp;&nbsp;<font size="4px">8500000接通后按0</font></div>
<div class="m-b-10">招聘资讯热线(8:30-17:30)<br/>&nbsp;&nbsp;<font size="4px">8500000接通后按2</font></div>
<div class="m-b-10">工资服务热线(8:30-17:30)<br/>&nbsp;&nbsp;<font size="4px">8500000接通后按0</font></div>
<div class="p-b-10">24小时综合服务专线<br/>&nbsp;&nbsp;<font size="4px">13676022506</font></div>
</div>

<div class="title">联系方式  </div>
<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
	<div class="p-l-8 special">
<div class="m-b-5">公司地址：珠海市前山明珠南路1999<br/>&nbsp;&nbsp;&nbsp;&nbsp;号5栋28、30、32号一层商铺</div>
<div id="route" class="m-b-5">乘车路线：5、15、42、45、60、204<br/>&nbsp;&nbsp;&nbsp;&nbsp;路到二城广场巴士站下车即到（现因修路原因，改在浮石站或中山亭站下车，向二城广场或明珠商业广场方向走即到）</div>
 <div class="m-b-5">邮　　编：519071</div>
 <div class="m-b-5">传　　真：0756-8500111 </div>
</div>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>
</html>
