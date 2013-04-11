<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.User"%>
<html xmlns:gzb="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    
    <title>个人信息修改-工作宝招聘网站</title>
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
  <%    User userinfo=null;
   if(session.getAttribute("flag")!= null){  
	   userinfo=(User)request.getAttribute("userInfo");
	   String mainurl = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
	   String userurl = response.encodeURL("userServlet?info=userInfo");
	   String modifyurl = response.encodeURL("passwordModify.jsp");
	   String actionurl = response.encodeURL("userServlet?info=updateUserInfo");
	   String inviteurl = response.encodeURL("invitePage.jsp");
	    String wageurl = response.encodeURL("userServlet?info=wage");
 %> 
 <jsp:include page="Fragment/userLogin.jsp" ></jsp:include>
 
  <div class="title m-b-10">资料修改</div>
 <div class="p-l-8 m-b-10"><a href="<%=mainurl%>">回到首页</a>&nbsp;|&nbsp;<a href="<%=userurl%>">个人信息</a>&nbsp;|&nbsp;<a href="<%=modifyurl%>">修改密码</a><br/>
 					<a href="<%=inviteurl%>">邀请好友</a>&nbsp;|&nbsp;<a href="<%=wageurl%>">工资信息</a></div>
<div class="special p-l-8 m-b-10">
<form method="post" action="<%=actionurl%>">
 <%if(request.getAttribute("firstMassage")!=null){
 	  String firstMassage = (String)request.getAttribute("firstMassage");
 %>
 <div style="color:#1E9ACA"><%=firstMassage %></div>
 <%} else if(userinfo.getRealName()==null||userinfo.getIDcardNum()==null
 			||userinfo.getRealName().isEmpty()||userinfo.getIDcardNum().isEmpty()) {%>
	<font color="#1E9ACA">请完善资料以便工作人员及时通知您招聘信息</font><br/>
	<%} %>
<%if(userinfo.getRealName()==null||userinfo.getIDcardNum()==null
	||userinfo.getRealName().isEmpty()||userinfo.getIDcardNum().isEmpty()) {%>
	<font color="#1E9ACA">个人资料是报名工作与查看工资的重要凭证，不会透露给任何人，请放心填写</font>
	<%} %>
<table>
  <tr><td><strong>姓名：</strong></td><td><input type="text" name="realName" maxlength="10" <%if(userinfo.getRealName()!=null) {%>value="<%=userinfo.getRealName()%>"<%} %>/></td></tr>
  <tr><td><strong>身份证：</strong></td><td><input type="text" name="idcardNum" maxlength="18" <%if(userinfo.getIDcardNum()!=null) {%> value="<%=userinfo.getIDcardNum()%>"<%} %>/></td></tr>
  <tr style="display: none;"><td><strong>手机：</strong></td><td><input type="text" name="phone" maxlength="11" <%if(userinfo.getPhone()!=null) {%> value="<%=userinfo.getPhone()%>" <%}%>/></td></tr>
 
  <tr><td><strong>学历：</strong></td><td><select name="edu" id="edu" >
                                  <option value="未填写" <%if(userinfo.getEducation()==null){%>selected="selected"<%}%>>未填写</option>
                                  <option value="初中以上" <%if(userinfo.getEducation()!=null)if(userinfo.getEducation().equals("初中以上")) {%>selected="selected"<%}%>>初中以上</option>
                                  <option value="中专以上" <%if(userinfo.getEducation()!=null)if(userinfo.getEducation().equals("中专以上")) {%>selected="selected"<%}%>>中专以上</option>
                                  <option value="高中以上" <%if(userinfo.getEducation()!=null)if(userinfo.getEducation().equals("高中以上")) {%>selected="selected"<%}%>>高中以上</option>
                                  <option value="大专以上" <%if(userinfo.getEducation()!=null)if(userinfo.getEducation().equals("大专以上")) {%>selected="selected"<%}%>>大专以上</option>
                                  <option value="本科以上" <%if(userinfo.getEducation()!=null)if(userinfo.getEducation().equals("本科以上")) {%>selected="selected"<%}%>>本科以上</option>
                                  </select></td></tr>
  <tr><td><strong>性别：</strong></td><td><select name="sex" id="sex" >
                                  <option value="1" <%if(userinfo.getSex()==1) {%>selected="selected"<%}%>>男</option>
                                  <option value="2" <%if(userinfo.getSex()==2) {%>selected="selected"<%}%>>女</option>
                                  </select></td></tr>   
                                  <tr><td></td></tr>
  <tr><td colspan="2">
  <%if(request.getAttribute("errMassage")!=null){
 	  String errMassage = (String)request.getAttribute("errMassage");
 %>
 <div style="color:#E3332F"><%=errMassage %></div>
 <%} %>
  </td></tr>
  <tr><td></td></tr>
  <tr><td><input class="btn-s" type="image" src="images/submitModify.png" alt="完成修改"/></td><td><a href="<%=userurl%>"><img src="images/notModify.png" alt="暂不修改"/></a></td></tr>
  
</table>
</form>
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
