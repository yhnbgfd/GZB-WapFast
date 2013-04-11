<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%
  String timeBanner = "您好";
  Calendar cal = Calendar.getInstance();
  int hour = cal.get(Calendar.HOUR_OF_DAY);
  if (hour >= 5 && hour < 11) {
   timeBanner = "上午好";
  } else if (hour >= 11 && hour < 13) {
   timeBanner = "中午好";
  } else if (hour >= 13 && hour < 18) {
   timeBanner = "下午好";
  } else if (hour >= 18 && hour < 23) {
   timeBanner = "晚上好";
  } else {
   timeBanner = "夜深啦";
  }


%>
<div class="m-b-5 p-l-8"><%= timeBanner%>&nbsp;<%=(String)session.getAttribute("realname")%>&nbsp;<a href="loginout.jsp">退出</a></div>
