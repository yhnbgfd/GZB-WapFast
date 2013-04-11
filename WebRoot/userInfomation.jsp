<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.V_User"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    
    <title>我的信息-工作宝招聘网站</title>
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
  
  <%    V_User userinfo=null;
   if(session.getAttribute("flag")!= null){  
	   userinfo=(V_User)request.getAttribute("userInfo");
	   String mainurl = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
	   String userurl = response.encodeURL("userServlet?info=userInfo");
	   String updateurl = response.encodeURL("userServlet?info=queryUpdateUserinfo");
	   String modifyurl = response.encodeURL("passwordModify.jsp");
	   String inviteurl = response.encodeURL("invitePage.jsp");
	   String wageurl = response.encodeURL("userServlet?info=wage");
 %> 
 <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
 
 <div class="title m-b-10">我的信息</div>
  <div class="p-l-8 m-b-10"><a href="<%=mainurl%>">回到首页</a>&nbsp;|&nbsp;<a href="<%=updateurl%>">修改资料</a>&nbsp;|&nbsp;<a href="<%=modifyurl%>">修改密码</a><br/>
 					 <a href="<%=inviteurl%>">邀请好友</a>&nbsp;|&nbsp;<a href="<%=wageurl%>">工资信息</a></div>
  <%if(request.getAttribute("errMassage")!=null){
 	  String errMassage = (String)request.getAttribute("errMassage");
 %>
 <div class="p-l-8 m-b-10" style="color:#1E9ACA"><%=errMassage %></div>
 <%} %>
  <div class="special p-b-10">
  
  <div class="contentLine m-b-5"><strong>姓名：</strong><%if(userinfo.getRealName()!=null) {%><%=userinfo.getRealName()%><%}else{ %>未填写<%} %></div>
  <div class="contentLine m-b-5"><strong>身份证：</strong><%if(userinfo.getIDcardNum()!=null) {%><%=userinfo.getIDcardNum()%><%}else{ %>未填写<%} %></div>
  <div class="contentLine m-b-5"><strong>手机：</strong><%=userinfo.getPhone()%></div>
  <div class="contentLine m-b-5"><strong>性别：</strong><%if(userinfo.getSex()!=0) {if(userinfo.getSex()==1){%>男<%}else{%>女<%}}else{ %>未填写<%} %></div>
  
  <div class="contentLine m-b-5"><strong>学历：</strong><%if(userinfo.getEducation()!=null){%><%=userinfo.getEducation()%><%}else{ %>未填写<%} %></div>
  <div class="contentLine m-b-5"><strong>最后登录时间：</strong><div><%=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(userinfo.getLastLoginDate())%></div></div>
  <div class="contentLine m-b-5"><strong>最后报名时间：</strong><div><%if(userinfo.getLastCheckDate()!=null) {%><%=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(userinfo.getLastCheckDate())%><%}else{ %>未报名<%} %></div></div>
  <div class="contentLine1 m-b-5"><strong>最后报名信息：</strong><div><%if(userinfo.getLastCheckCompName()!=null){
  																	if(userinfo.getLastCheckIsCasual()==0){%>
  																	<a href="recruitServlet?info=queryRecruitInfo&amp;id=<%=userinfo.getLastCheckRecruitID()%>"><%=userinfo.getLastCheckCompName()%></a>
  																	<%}else{%>
  																	<a href="recruitServlet?info=queryLabourInfo&amp;id=<%=userinfo.getLastCheckRecruitID()%>"><%=userinfo.getLastCheckCompName()%></a>
  																	 <%}%>
  <div class="p-t-5"><strong>集合通知：</strong><div><%if(userinfo.getCentreMsg()!=null){%><%=userinfo.getCentreMsg()%><%}else{ %>一有消息，马上更新<%} %></div></div>																 
  																 <% }else{ %>未报名<%} %></div></div>
  
  </div>
 <% 
   }else{            
 %> 
   <div> 您好&nbsp;游客，[<a href="login.jsp">登录</a>/<a href="register.jsp">注册</a>]</div>
<div>请先登录再进行个人信息管理！</div>
 <%} %>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>

</html>
