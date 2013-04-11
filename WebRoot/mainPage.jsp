<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd"> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.V_RecruitList"%>
<%@ page import="bean.V_RankingList"%>
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>工作宝招聘网站</title>
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
	  // String moreurl = response.encodeURL("recruitServlet?info=rankingList&amp;p2=1"); 
	   String moreurl2 = response.encodeURL("recruitServlet?info=queryRecruiList&amp;p=1");
	   String moreurl = response.encodeURL("recruitServlet?info=areaRankingList&amp;p2=1");	   
	   String detailurl; 
 %> 
 <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>

<jsp:include page="Fragment/Navbar.jsp" ></jsp:include>
 <%List<String> newList=(List<String>)request.getAttribute("newsList");
if(!newList.isEmpty()){
%>
<div class="title"><strong>网站动态</strong></div>
<div class="special p-t-5">
<%
for(String newList1:newList){
 %>

<div class=" m-b-5 p-l-8"><%=newList1 %></div>
<% }
%></div>
<%}%>
<div style="border:0; cellpadding:0; cellspacing:0" >
  <div class="title"><div><strong>小时工工价排行榜</strong><a href="<%=moreurl %>">(点击查看更多)</a></div></div>

<%
List<V_RankingList> list=(List<V_RankingList>)request.getAttribute("rankingList");
if(!list.isEmpty())
for(V_RankingList rankingList1:list){
	detailurl = response.encodeURL("recruitServlet?info=queryLabourInfo&amp;id="+rankingList1.getRecruitInfoID());
%>
	<div class="tit"><a href="<%=detailurl%>" ><%=rankingList1.getCompanyName()%></a>
	<%if(rankingList1.getIsNew()==1) {%><img src="images/newshow.gif" alt="new"/><%} %>
	</div>
    <div class="special">[职位]<%=rankingList1.getJobName()%></div>
    <div class="special"><div class="ep width">[工价]<%if(rankingList1.getPrice()!=0){%><%=rankingList1.getPrice()%>元/时<%}else{ %>面议<%} %></div></div>   
<%}
 else{%>
 	<div class="tit"><div>暂无数据</div></div>
 <%} %>
</div>

 <div style="border:0; cellpadding:0; cellspacing:0" >
  <div class="title"><div><strong>热门招聘</strong><a href="<%=moreurl2%>">(点击查看更多)</a></div></div>

<%
List<V_RecruitList> relist=(List<V_RecruitList>)request.getAttribute("recruitList");
if(!relist.isEmpty())
for(V_RecruitList recruitList1:relist){
	detailurl = response.encodeURL("recruitServlet?info=queryRecruitInfo&amp;id="+recruitList1.getRecruitInfoID());
%>
	<div class="tit"><a href="<%=detailurl%>" ><%=recruitList1.getCompanyName()%></a><%if(recruitList1.getIsNew()==1) {%><img src="images/newshow.gif" alt="new"/><%} %></div>
    <div class="special">[职位]<%=recruitList1.getJobName()%></div>
    <div class="special"><div class="ep width">[收入]<%if(recruitList1.getSalaryRange()!=null&&!recruitList1.getSalaryRange().isEmpty()){%><%=recruitList1.getSalaryRange()%><%}else{ %><%=recruitList1.getBenefits()%><%} %></div></div>   
	<!-- <img src="images/icon_hot.gif" alt="hot"/>-->	
<%}
 else{%>
 	<div class="tit"><div>暂无数据</div></div>
 <%} %>
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
