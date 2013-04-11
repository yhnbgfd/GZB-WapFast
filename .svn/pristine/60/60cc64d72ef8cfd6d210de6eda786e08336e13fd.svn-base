<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.V_RecruitList"%>
<%@ page import="bean.V_RankingList"%>
<%@ page import="onlineCounterListener.TrafficStatistics"%>
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>工作宝招聘网站</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="蓝龙,珠海,工作宝,招聘,高薪,短期工,热门,劳务派遣,人力资源"/>
	<meta http-equiv="description" content="This is my page"/>
	<%
	if(session.getAttribute("ip")==null){
		session.setAttribute("ip",request.getRemoteAddr());
		TrafficStatistics ts = new TrafficStatistics();
		ts.Statistics((String)session.getAttribute("ip"));
	}
	%>
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
  <div style="text-align:center"><img src="images/propagate.gif" alt="让你用同样的努力  创造出更多的财富!"/></div>

 <%      	
   if(session.getAttribute("flag")!= null){  
   		String userurl = response.encodeURL("userServlet?info=userInfo");
 %> 
  <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
 <% 
   }else{            
 %> 
  <div class="m-b-5 p-l-8">
  <div><p>&gt;&gt;&gt;&nbsp;<a href="introduce.jsp" style="color:blue;">工作宝是什么?</a>&nbsp;&lt;&lt;&lt;</p></div>
  <div>浏览更多信息,请先<a href="login.jsp" style="color:blue;">会员登录</a></div>
  <div>不是会员?马上点击<a href="register.jsp" style="color:blue;">10秒注册</a></div>
  </div>
<%} %>

	<div class="m-b-5 p-l-8"><a href="recruitServlet?info=queryRecruiList&amp;p=1">热门企业招聘</a>&nbsp;|&nbsp;<a href="recruitServlet?info=areaRankingList&amp;p2=1">小时工工价排行榜</a></div>
 <%List<String> newList=(List<String>)request.getAttribute("newsList");
if(!newList.isEmpty()){
%>
<div class="title "><strong>网站动态</strong></div>
<div class="special p-t-5">
<%
for(String newList1:newList){
 %>

<div class="m-b-5 p-l-8"><%=newList1 %></div>
<% }%></div>
<%}%>
 <div>
  <div class="title"><div><strong>小时工工价排行榜</strong><a href="recruitServlet?info=areaRankingList&amp;p2=1">(点击查看更多)</a></div></div>

<%
List<V_RankingList> list=(List<V_RankingList>)request.getAttribute("rankingList");
if(!list.isEmpty()){
for(V_RankingList rankingList1:list){
%>
	<div class="tit"><a href="recruitServlet?info=queryLabourInfo&amp;id=<%=rankingList1.getRecruitInfoID()%>" ><%=rankingList1.getCompanyName()%></a><%if(rankingList1.getIsNew()==1) {%><img src="images/newshow.gif" alt="new"/><%} %></div>
    <div class="special">[职位]<%=rankingList1.getJobName()%></div>
    <div class="special"><div class="ep width">[工价]<%if(rankingList1.getPrice()!=0){%><%=rankingList1.getPrice()%>元/时<%}else{ %>面议<%} %></div></div>   
	
<%}
}else{%>
 	<div class="tit">暂无数据</div>
 <%} %>
</div>
 <div  class="m-b-10">
  <div class="title"><div><strong>热门推荐</strong><a href="recruitServlet?info=queryRecruiList&amp;p=1">(点击查看更多)</a></div></div>

<%
List<V_RecruitList> relist=(List<V_RecruitList>)request.getAttribute("recruitList");
if(!relist.isEmpty()){
for(V_RecruitList recruitList1:relist){
%>
	<div class="tit"><a href="recruitServlet?info=queryRecruitInfo&amp;id=<%=recruitList1.getRecruitInfoID()%>" ><%=recruitList1.getCompanyName()%></a><%if(recruitList1.getIsNew()==1) {%><img src="images/newshow.gif" alt="new"/><%} %></div>
    <div class="special">[职位]<%=recruitList1.getJobName()%></div>
    <div class="special"><div class="ep width">[收入]<%if(recruitList1.getSalaryRange()!=null&&!recruitList1.getSalaryRange().isEmpty()){%><%=recruitList1.getSalaryRange()%><%}else{ %><%=recruitList1.getBenefits()%><%} %></div></div>   
	<!-- 要换省略号 -->
	 
<%}
 }else{%>
 	<div class="tit">暂无数据</div>
 <%} %>
</div>
<div class="m-b-20 p-l-8">*先人一步，<a href="register.jsp" style="color:blue;">马上注册</a>，抢占月入4000的工作机会！</div>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>
</html>

