<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
  String mainurl = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
  String helpurl = response.encodeURL("help.jsp");
  String abouturl = response.encodeURL("about.jsp");
  String introduceurl = response.encodeURL("introduce.jsp");
  String contactusurl = response.encodeURL("contactus.jsp");
  String changeurl1 = response.encodeURL("changeVersion.jsp?version=1");
  String changeurl2 = response.encodeURL("changeVersion.jsp?version=2");
  %>
<p></p>
<div style="font-size:14px;">
<div style="border-bottom:1px solid #9B97F8" class="departLine"></div>
<div style="height:8px;"></div>
<div class="p-l-8"><a href="<%=mainurl%>">首页</a>|<a href="<%=abouturl%>">关于</a>|<a href="<%=introduceurl%>">工作宝</a>|<a href="<%=contactusurl%>">客服</a>|<a href="<%=helpurl%>">帮助</a><br/>
&lt;<a href="<%=changeurl1%>">简版</a> | <a href="<%=changeurl2%>">3G炫彩版</a>&gt; <br/>
<span style="color:blue">用户至上  用心服务</span><br/>
<%=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.util.Date())%><br/>
粤ICP备12005917号</div>
</div>