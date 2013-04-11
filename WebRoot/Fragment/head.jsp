<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="text-align:center"><p><a href="index.jsp"><img id="img" src="images/head.gif" width=240 height=100 alt="工作宝招聘网站"/></a></p></div>
<%
String UAinHead = request.getHeader("User-Agent"); 

if(UAinHead!=null && !UAinHead.equals("null") && !UAinHead.equals("")){
	if(UAinHead.indexOf("Mobile")==-1 && UAinHead.indexOf("Android")==-1 && UAinHead.indexOf("iPhone")==-1){
		if(UAinHead.indexOf("MSIE")>-1 ||				//IE
				UAinHead.indexOf("Safari") > -1 ||		//apple
				UAinHead.indexOf("Firefox") > -1 ||	//firefox
				UAinHead.indexOf("Chrome") > -1 ||		//Chrome
				UAinHead.indexOf("Opera") > -1	){		//opera
			//out.print("请用手机登陆wap.igzb.cn");
			//String url = response.encodeURL("http://www.igzb.cn");
			//response.sendRedirect(url);
			//return;
		}
	}else{
		//out.print("这是手机端浏览器");
	}
}
%>