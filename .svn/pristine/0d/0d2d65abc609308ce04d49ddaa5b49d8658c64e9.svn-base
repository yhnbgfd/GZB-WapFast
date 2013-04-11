<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.Wage"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    
    <title>工资管理-工作宝招聘网站</title>
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
  
 <%if(session.getAttribute("flag")!= null){  
	   String mainurl = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
	   String userurl = response.encodeURL("userServlet?info=userInfo");
	   String updateurl = response.encodeURL("userServlet?info=queryUpdateUserinfo");
	   String modifyurl = response.encodeURL("passwordModify.jsp");
	   String inviteurl = response.encodeURL("invitePage.jsp");
	   String detailurl;
 %> 
 <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
 
 <div class="title">工资信息</div>
  <div class="p-l-8 m-b-10"><a href="<%=mainurl%>">回到首页</a>&nbsp;|&nbsp;<a href="<%=userurl%>">个人信息</a>&nbsp;|&nbsp;<a href="<%=updateurl%>">修改资料</a><br/>
  					 <a href="<%=modifyurl%>">修改密码</a>&nbsp;|&nbsp;<a href="<%=inviteurl%>">邀请好友</a></div>

 <%List<Wage> list=(List<Wage>)request.getAttribute("wageList");
if(!list.isEmpty()){
for(Wage wage:list){ 
	detailurl = response.encodeURL("userServlet?info=wageInfo&amp;wageId="+wage.getWageID());
%>
  <div class="special">
  <div class="tit" class="contentLine"><strong>月份：</strong><%if(wage.getDate()!=null) {%><%=wage.getDate()%><%}else{ %>暂未开始发放<%} %></div> 
  <div class="contentLine"><strong>公司：</strong><%=wage.getFactory()%></div>
  <div class="contentLine"><strong>工资：</strong><%if(wage.getWage()!=null) {%><%=wage.getWage()%>&nbsp;&nbsp;&nbsp;<a href="<%=detailurl%>" >工资详情</a><%}else{ %>暂未开始发放<%} %></div>  
  </div>
 <% }
 }else{%>
 	<div class="tit">暂无数据</div>
 <%}
 }else{%> 
   <div> 您好&nbsp;游客，[<a href="login.jsp">登录</a>/<a href="register.jsp">注册</a>]</div>
<div>请先登录再查看工资！</div>
 <%} %>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>

</html>