<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.V_RecruitInfo"%>
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
  <%
	V_RecruitInfo recruitInfo=(V_RecruitInfo)request.getAttribute("recruitInfo");
%>  
    <title><%=recruitInfo.getCompanyName()%>招聘详情-工作宝招聘网站</title>
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
   		String checkinurl = response.encodeURL("checkInServlet?info=confirm&amp;id="+recruitInfo.getRecruitInfoID()+"&amp;type=0");
 %> 
 <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
  <jsp:include page="Fragment/Navbar.jsp" ></jsp:include>
  <div class="title"><%=recruitInfo.getCompanyName()%><%if(recruitInfo.getIsNew()==1) {%><img src="images/newshow.gif" alt="new"/><%} %></div>
  <div class="special p-l-8">
  <div>[招聘职位]：<%=recruitInfo.getJobName()%></div> 
  <%if(recruitInfo.getStartTime().length()!=0){%><div>[开始时间]：<%=recruitInfo.getStartTime()%></div><%} %>
  <%if(recruitInfo.getEndTime().length()!=0){%><div>[结束时间]：<%=recruitInfo.getEndTime()%></div><%} %>
  <div>[招聘人数]：<%=recruitInfo.getRecruitingNum()%></div>
  <div>[剩余人数]：<%if(recruitInfo.getInitRemainNum()!=0&&recruitInfo.getInitRemainNum()<recruitInfo.getRemainNum()){%><%=recruitInfo.getInitRemainNum()%><%}else{ %><%=recruitInfo.getRemainNum()%><%} %></div>
  <div>[性别]：<%if(recruitInfo.getSex()!=0){if(recruitInfo.getSex()==1){%>男<%}else{%>女<%}}else{ %>无限制<%} %></div>
  <%if(recruitInfo.getAge().length()!=0){%><div>[年龄]：<%=recruitInfo.getAge()%></div><%}%>

  <div>[收入]：<%if(recruitInfo.getBenefits().length()!=0){%><%=recruitInfo.getBenefits()%><%}else{ %>面议<%} %></div>
  <%if(recruitInfo.getEducation().length()!=0){%><div>[学历要求]：<%=recruitInfo.getEducation()%></div><%}%>
  <%if(recruitInfo.getRequirement().length()!=0){%><div>[工作要求]：<div><%=recruitInfo.getRequirement()%></div></div><%}%>
  <%if(recruitInfo.getJobContent().length()!=0){%><div>[公司介绍]：<div><%=recruitInfo.getJobContent()%></div></div> <%}%>
  <%if(recruitInfo.getLocation().length()!=0){%><div>[工作地点]：<%=recruitInfo.getLocation()%></div><%}%>
  
  <div>[联系人]：<%if(recruitInfo.getContactBy().length()!=0){%><%=recruitInfo.getContactBy()%><%}else{ %>暂无<%} %></div>
  <div>[联系电话]：<%if(recruitInfo.getContactNum().length()!=0){%><%=recruitInfo.getContactNum()%><%}else{ %>暂无<%} %></div>
  <div> 
  
  <form method="post" action="<%=checkinurl%>">
  <div><input class="btn-s" type="image" src="images/checkin.png" alt="我要报名"/>&nbsp;&nbsp;<a href="invitePage.jsp"><img id="img" src="images/invatef2.png" alt="邀请好友一起报名"/></a></div>
  
  </form>
  </div>
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
