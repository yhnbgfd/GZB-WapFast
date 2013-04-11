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
    
    <title>工作宝-工作宝招聘网站</title>
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
	}else{	
  		session.setAttribute("version",2);
  	%>
	<link rel="stylesheet" type="text/css" href="images/styles.css"/>
	<%} %>
	<link rel="shortcut icon" href="images/favicon.ico" />
  </head>
  
  <body>
    <%@ include file="Fragment/head.jsp"%>  
 <%     
  String arearankingurl = response.encodeURL("recruitServlet?info=areaRankingList");
  String rankingurl = response.encodeURL("recruitServlet?info=rankingList&amp;p2=1"); 
  String recruiturl = response.encodeURL("recruitServlet?info=queryRecruiList&amp;p=1");	
  String inviteurl = response.encodeURL("invitePage.jsp");
 %>  
<div class="title">工作宝是什么</div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">工作宝是手机网上招聘平台，属于珠海最大的人力资源公司蓝龙人力资源。在工作宝登记求职跟所有职介所现场求职完全一样！</div>


<div class="p-l-8 special"><a href="login.jsp">登录</a>工作宝就可以免除搭公交、在招聘现场排队的麻烦，在工作宝网站找到称心如意的工作。</div>

<div class="title">我们提供什么</div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special"><a href="<%=recruiturl %>">热门招聘</a>：以世界500强为首的企业男女普工招聘信息<br/>
							<a href="<%=rankingurl %>">高价短期工</a>：我们只提供高于市场价的短期工、小时工，明明白白找工作，请看<a href="<%=arearankingurl %>">短期工竞价排行榜</a><br/>
							<a href="<%=inviteurl %>">邀请好友</a>：人多力量大，有群好友好照应。简单输入好友手机号码，我们就帮你邀请TA一起找工作，一起进好厂。</div>	

<div class="p-l-8 special">不一样的人力资源，是您人生新的起航！</div>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>
</html>
