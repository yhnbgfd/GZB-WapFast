package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.SendSMS;

import bean.CheckIn;
import bean.V_CheckIn;
import bean.V_User;
import dao.CheckInDao;
import dao.OptionsDao;
import dao.V_CheckInDao;
import dao.V_UserDao;

public class CheckInServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -857980740047162193L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String info = request.getParameter("info");  // 设置String类型对象info，该对象代表着执行不同的方法
		if (info.equals("checkIn")) {
			this.checkIn(request, response);
		}
		if(info.equals("confirm")){
			this.confirm(request, response);
		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {    
		doGet(request,response);    
	} 
	
	public void confirm(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException {
		request.setAttribute("id",request.getParameter("id"));
		request.setAttribute("type",request.getParameter("type"));
		V_UserDao userdata = new V_UserDao(); // 定义V_UserDao类对象
		String[] userparam = new String[1];
		HttpSession session = request.getSession(true);
		userparam[0] = (String) session.getAttribute("uid");
		V_User userInfo = userdata.user_query("WHERE UserID=?",userparam);
		if(userInfo.getLastCheckDate()!=null)
			request.setAttribute("LastCheckDate", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(userInfo.getLastCheckDate()));
		
		request.getRequestDispatcher("checkInConfirm.jsp").forward(request,
				  response);
		return;
	}
	
	public void checkIn(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException {
		String recruitInfoId = request.getParameter("id"); 
		HttpSession session = request.getSession(true);
		String uid = session.getAttribute("uid").toString();
		String uname = session.getAttribute("uname").toString();
		String userurl = response.encodeURL("userServlet?info=userInfo");
		String updateuserurl = response.encodeURL("userServlet?info=queryUpdateUserinfo");
		String inviteurl = response.encodeURL("invitePage.jsp");
		String returl;
		if(request.getParameter("type").equals("0"))
			returl = response.encodeURL("recruitServlet?info=queryRecruitInfo&amp;id="+recruitInfoId);
		else
			returl = response.encodeURL("recruitServlet?info=queryLabourInfo&amp;id="+recruitInfoId);
		if(uid==null){
			String errMassage = "请登录后再进行操作！马上<a href=\"login.jsp\">登录</a>";
			request.setAttribute("errMassage", errMassage);
			request.getRequestDispatcher("MassagePages.jsp").forward(request,
					  response);
			return;
		}else{
			///////////////////////////////////////////////////////////////要改
			V_UserDao userData = null; // 定义UserDao类对象
			userData = new V_UserDao();
			String[] param = new String[1];
			param[0] = uid;
			V_User user = userData.user_query("WHERE UserID=? and IsDelete=0 and ((LastCheckDate is null) or (Now()-DATE_ADD(LastCheckDate,INTERVAL '0 12' DAY_HOUR)>0)) ",param);
			if(user==null){
				String errMassage = "<div class=\"m-b-10\" style=\"color:#E3332F\">系统不允许在12小时内重复报名</div>" +
									"<div>报名相关规则，详细请查看<a href=\"help.jsp\">帮助</a></div>" +
									"<div class=\"m-b-10\">取消报名请联系公司<a href=\"contactus.jsp\">客服</a></div>" +
									"<div><a href=\""+returl+"\"><img src=\"images/back.png\" alt=\"返回\"/></a>" +
									"&nbsp;&nbsp;<a href=\"index.jsp\"><img src=\"images/index.png\" alt=\"首页\"/></a></div>";
				
				request.setAttribute("errMassage", errMassage);			
				request.getRequestDispatcher("MassagePages.jsp").forward(request,
						  response);
				return;
			}else if(user.getIDcardNum()==null||user.getRealName()==null||user.getSex()==0||user.getEducation()==null
					||user.getIDcardNum().isEmpty()||user.getRealName().isEmpty()||user.getEducation().isEmpty()){
				String firstMassage = "您还没完善个人信息呢";
				//填写完返回的url
				returl = response.encodeURL("checkInServlet?info=checkIn&id="+recruitInfoId+"&type="+request.getParameter("type"));
				session.setAttribute("returl", returl);
				request.setAttribute("firstMassage", firstMassage);
				request.getRequestDispatcher(updateuserurl).forward(request,
						  response);
				return;
			}
			else if(user.getUserCredit()<=0){
				String errMassage = "<div class=\"m-b-10\">对不起！您的信用不足！请联系<a href=\"contactus.jsp\">客服</a></div>" +
									"<div><a href=\""+returl+"\"><img src=\"images/back.png\" alt=\"返回\"/></a>" +
									"&nbsp;&nbsp;<a href=\"index.jsp\"><img src=\"images/index.png\" alt=\"首页\"/></a></div>";
				request.setAttribute("errMassage", errMassage);
				request.getRequestDispatcher("MassagePages.jsp").forward(request,
						  response);
				return;
			}else{			
				V_CheckInDao vcheckData = new V_CheckInDao();
				String[] recParam = new String[1];
				recParam[0] = recruitInfoId;
				V_CheckIn v_CheckIn = vcheckData.v_CheckIn_query("WHERE RecruitinfoID=? and IsDelete=0 and IsClose=0",recParam);  
				
				CheckInDao checkData = new CheckInDao();
				String[] checkparam = new String[2];
				checkparam[0] = recruitInfoId;
				checkparam[1] = uid;
				CheckIn CheckIn = checkData.CheckIn_query("WHERE FK_RecruitinfoID=? and FK_UserID=? and IsConfirm=0 ",checkparam);  
				
				if(v_CheckIn==null){
					String errMassage = "<div class=\"m-b-10\">找不到该招聘信息！招聘可能已经过期</div>" +
										"<div><a href=\""+returl+"\"><img src=\"images/back.png\" alt=\"返回\"/></a>" +
										"&nbsp;&nbsp;<a href=\"index.jsp\"><img src=\"images/index.png\" alt=\"首页\"/></a></div>";
					request.setAttribute("errMassage", errMassage);
					request.getRequestDispatcher("MassagePages.jsp").forward(request,
							  response);
					return;
				}else if(v_CheckIn.getSex()!=0&&v_CheckIn.getSex()!=user.getSex()){
					String errMassage = "<div class=\"m-b-10\">对不起！招聘要求性别与您不符！</div>" +
										"<div><a href=\""+returl+"\"><img src=\"images/back.png\" alt=\"返回\"/></a>" +
										"&nbsp;&nbsp;<a href=\"index.jsp\"><img src=\"images/index.png\" alt=\"首页\"/></a></div>";
					request.setAttribute("errMassage", errMassage);
					request.getRequestDispatcher("MassagePages.jsp").forward(request,
							  response);
					return;
				}else if(v_CheckIn.getRemainNum()<=0){
					String errMassage = "<div class=\"m-b-10\">报名人数已满！</div>" +
										"<div><a href=\""+returl+"\"><img src=\"images/back.png\" alt=\"返回\"/></a>" +
										"&nbsp;&nbsp;<a href=\"index.jsp\"><img src=\"images/index.png\" alt=\"首页\"/></a></div>";
					request.setAttribute("errMassage", errMassage);
					request.getRequestDispatcher("MassagePages.jsp").forward(request,
							  response);
					return;
				}else if(CheckIn!=null){
					String errMassage = "<div class=\"m-b-10\">您已报名该公司职位,请留意短信通知!如未收到通知短信，请点击再发送一次短信。</div>" +
										"<div><a href=\""+returl+"\"><img src=\"images/back.png\" alt=\"返回\"/></a>" +
										"&nbsp;&nbsp;<a href=\"sendAgainServlet?info=checkInAgain&phone="+user.getPhone()+"\"><img id=\"img2\" src=\"images/again.png\"/></a></div>";
					session.setAttribute("checkcontent", v_CheckIn.getSendMassage());
					request.setAttribute("errMassage", errMassage);
					request.getRequestDispatcher("MassagePages.jsp").forward(request,
							  response);
					return;
				}else{
					// 插入checkin表记录
					CheckInDao checkinData = new CheckInDao();
					CheckIn checkin = new CheckIn();
					UUID uuid = UUID.randomUUID();
					checkin.setCheckInID(uuid.toString());
					checkin.setFK_RecruitInfoID(recruitInfoId);
					checkin.setFK_UserID(uid);
					checkin.setIsConfirm(0);
					checkin.setInsertDate(new java.util.Date());
					checkin.setInsertBy(uname);
				  
					
					if(checkinData.checkIn_insert(checkin)){
						//发送管理员短信
						OptionsDao optd = new OptionsDao();
						if(optd.admin_sms()){
							String phone = optd.admin_phone();
							String realname = user.getRealName();
							if(!phone.equals("")){
								if(realname == null){
									realname = "";
								}
								String content = "工作宝通知：用户 "+user.getPhone()+" "+realname+" 报名了："+v_CheckIn.getCompanyName()+"的职位。"; 
								SendSMS sms = new SendSMS();
								sms.sendSMS(content,phone, "2", "123", "VIP", null);
							}
						}
						//发送手机短信
						String content = "报名成功!"+v_CheckIn.getSendMassage(); 
						SendSMS sms = new SendSMS();
						sms.sendSMS(content,user.getPhone() , "2", "123", "VIP", null);
						String CheckInMassage = "<div class=\"p-t-5 m-b-10\" style=\"color:#E3332F\">您已成功报名该职位,请留意短信通知集合地点。</div>" +
											//"如未收到通知短信，请点击再发送一次短信<br/>" +
											"<div class=\"m-b-5\" style=\"color:#1E9ACA\">感谢您的报名，祝您工作顺利！</div>" +
											
											"<div class=\"m-b-5\"><a href=\""+userurl+"\">个人信息</a>页面可以查看集中信息</div>" +
											"<div class=\"m-b-5\">乘车路线请点这里：<a href=\"contactus.jsp#route\">乘车路线</a></div>" +
											"<div class=\"m-b-10\">如需帮助,请联系<a href=\"contactus.jsp\" color=\"blue\">客服</a></div>" +
											"<div class=\"m-b-5\" style=\"color:#E3332F\">邀请好友一起报名吧！</div>";
										//	"<form method=\"post\" action=\""+returl+"\">"+
										//	"<div><input class=\"btn-s\" type=\"submit\" value=\"再发一次\"/></div></form>";
					   //String againURL = response.encodeURL("sendAgainServlet?info=checkInAgain&uname="+uname);
					   // request.setAttribute("againURL", againURL);
						request.setAttribute("CheckInMassage", CheckInMassage);
					    request.getRequestDispatcher(inviteurl).forward(request,
							   response);
					    
						return;
						
						
					}else {
						String errMassage = "<div class=\"m-b-10\">网络链接有误,报名失败</div>" +
											"<div><a href=\""+returl+"\"><img src=\"images/back.png\" alt=\"返回\"/></a>" +
											"&nbsp;&nbsp;<a href=\"index.jsp\"><img src=\"images/index.png\" alt=\"首页\"/></a></div>";
						request.setAttribute("errMassage", errMassage);
						request.getRequestDispatcher("MassagePages.jsp").forward(request,
								  response);
						return;
					}
				}
				
			}
			
		}
	
	}
}
