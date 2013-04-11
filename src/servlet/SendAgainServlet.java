package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDao;
import util.SendSMS;

public class SendAgainServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5252342527742282745L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String info = request.getParameter("info");  // 设置String类型对象info，该对象代表着执行不同的方法
		if (info.equals("registerAgain")) {
			this.registerAgain(request, response);
		}
		if (info.equals("checkInAgain")) {
			this.checkInAgain(request, response);
		}
	}
	
	//注册 再发一次
	public void registerAgain(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException {
		String uname = request.getParameter("uname"); //用户名被刷不知道对象
		UserDao data = new UserDao(); // 定义UserDao类对象
		String[] param = new String[1];
		param[0] = uname;		
		User usercache = data.user_query("WHERE UserName=? ",param);
    	if(usercache!=null){
    			//发短信,重设时间，验证码
//    			String[] updateparam = new String[1];
//    			updateparam[0] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
//    			String updateStr = "UpdateDate=?";
//    			if(true){
    				String content = "欢迎注册工作宝招聘网，您的账号："+uname+",密码："+usercache.getPassword()+",点击 http://wap.igzb.cn 登录网站浏览第一手招聘信息。[工作宝招聘网]"; 
    				SendSMS sms = new SendSMS();
    				sms.sendSMS(content,usercache.getPhone() , "2", "123", "VIP", null);
    				String errMassage = "密码短信已再次发送到手机"+usercache.getPhone()+"，请稍后！收到后马上<a href=\"login.jsp\">登录</a>。";
        			String againURL = response.encodeURL("sendAgainServlet?info=registerAgain&amp;uname="+uname);
    				request.setAttribute("errMassage", errMassage);
    			    request.setAttribute("againURL", againURL);
    			    request.getRequestDispatcher("MassagePages.jsp").forward(request,
    						response);
//    			}else{
//    				String errMassage = "再次发送短信失败！请<a href=\"register.jsp\">重新发送</a>";
//        			String againURL = response.encodeURL("sendAgainServlet?info=registerAgain&amp;uname="+uname);
//    				request.setAttribute("errMassage", errMassage);
//    			    request.setAttribute("againURL", againURL);
//    			    request.getRequestDispatcher("MassagePages.jsp").forward(request,
//    						response);
//    			}
    	}else{
    		//网页过期
    		String errMassage = "网页已过期，请<a href=\"register.jsp\">重新注册</a>";			
			request.setAttribute("errMassage", errMassage);
		    request.getRequestDispatcher("MassagePages.jsp").forward(request,
					response);
		    return;
    	}
				
	}

	//登记再发一次
	public void checkInAgain(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String phone = request.getParameter("phone");
		String con = (String) session.getAttribute("checkcontent");
		System.out.println(phone+con);
		String content = "您成功报名了工作宝招聘网中的职位!"+con+" [工作宝招聘网]"; 
		SendSMS sms = new SendSMS();
		sms.sendSMS(content,phone, "2", "123", "VIP", null);
		String errMassage = "您成功报名了工作宝招聘网中的职位!通知短信已再次发送，请注意查收。<br /><a href=\"index.jsp\"><img id=\"img\" src=\"images/back.png\"/></a>";
		request.setAttribute("errMassage", errMassage);
		request.getRequestDispatcher("MassagePages.jsp").forward(request,
				response);
	    return;
	}
}
