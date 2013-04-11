<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
  String mainurl = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
  String userurl = response.encodeURL("userServlet?info=userInfo");
  String arearankingurl = response.encodeURL("recruitServlet?info=areaRankingList&amp;p2=1");
  String rankingurl = response.encodeURL("recruitServlet?info=rankingList&amp;p2=1"); 
  String recruiturl = response.encodeURL("recruitServlet?info=queryRecruiList&amp;p=1");	
  String wageurl = response.encodeURL("userServlet?info=wage");
  String inviteurl = response.encodeURL("invitePage.jsp");
  %>
<div class="m-b-2 p-l-8"><a href="<%=mainurl%>">首页</a>&nbsp;|&nbsp;<a href="<%=userurl%>">个人中心</a>&nbsp;|&nbsp;<a href="<%=wageurl%>">工资信息</a>
</div>
<div class="m-b-2 p-l-8"><a href="<%=recruiturl%>">热门招聘</a>&nbsp;|&nbsp;<a href="<%=arearankingurl%>">小时工工价排行榜</a>
</div>
<div class="m-b-5 p-l-8"><a href="<%=inviteurl%>">邀请好友一起找工作</a>
</div>