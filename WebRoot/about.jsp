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
    
    <title>关于-工作宝招聘网站</title>
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

<div class="title">公司介绍 </div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">&nbsp;&nbsp;珠海市蓝龙企业管理咨询有限公司下辖珠海市蓝龙职业培训学校和珠海市蓝龙人力资源市场，成立于2002年尾，
2003年2月正式对外经营，公司本部现有员工40人，外派员工近千人，其中中高级人力资源经营和管理专业人士10人，
专业培训讲师、顾问师10余人，员工宿舍管理专业人员3人，下设三个驻点管理处；营业面积2000多平米，多媒体培训室5个。
现拥有直接客户群10000多家，其中囊括在珠海的绝大多数世界500强，中国500强，广东100强企业。
蓝龙服务产品：劳务派遣（劳务外包）、人力资源供应、员工宿舍配套、企业管理培训、人才猎头、招聘设计等 。</div>

<div class="title">经 营 业 绩  </div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">
<div>珠海市HR市场信息量、人流量、交易量（指蓝领、灰领阶 层）最大的供应商。 </div>
<div>珠海市首家也是唯一 一家通过世界500强企业劳务外包招标中标服务供应商。</div> 
<div>珠海市唯一 一家集人力资源供应、培训、外包于一体的最大综合性民营服务供应商。 </div>
</div>

<div class="title">社 会 业 绩  </div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">
<div>2005年——荣获国家劳动部“中国优秀民营职业介绍机构100佳”称号；</div>
<div>2006年——被光荣接纳为广东省人力资源管理协会、广东省劳动学会理事成员单位； </div> 
<div>2004年至今——历年被珠海市劳动局平为“放心服务单位”。 </div>
</div>

<div class="title">蓝龙专业水平  </div>
	<%if(session.getAttribute("version").equals(1)){%>
	<hr style="line-height:1px;"/>
	<%}%>
<div class="p-l-8 special">
<div>劳务派遣员工到位率（实际及时到位人数/要求到位人数）≥ 100% </div>
<div>劳务派遣员工年离职率（年离职人员数量/已到位人员数量）≤ 40%  </div> 
<div>提供应聘者面试通过率（面试合格人员/提供面试人员数）≥95% </div>
</div>
	<jsp:include page="Fragment/footer.jsp" ></jsp:include>  
  </body>
</html>
