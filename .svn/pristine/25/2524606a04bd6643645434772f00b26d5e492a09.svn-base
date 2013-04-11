package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlineCounterListener.TrafficStatistics;

import util.IDCard;
import util.RandomNumber;
import util.SendSMS;

import bean.IDCard_WagePW;
import bean.User;
import bean.V_User;
import bean.Wage;
import dao.IDCard_WagePWDao;
import dao.UserDao;
import dao.V_UserDao;
import dao.WageDao;

public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 3668295851139945210L;	
	private String uid;
	private String realname;
	private int bool;
	 public UserServlet() {    
         super();    
	 }    
	 /**    
	  * Destruction of the servlet. <br>    
	  */    
	 @Override
	public void destroy() {    
	         super.destroy(); // Just puts "destroy" string in log    
	         // Put your code here    
	 }    

	 @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {    
			doGet(request,response);    
		} 
	 
	 @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
		 	String info = request.getParameter("info");
			// 根据不同的参数名称，执行不同的方法
			if (info.equals("userLogin")) {
				this.userLogin(request, response);
			}
			if (info.equals("userRegister")) {
				this.userRerister(request, response);
			}
			if (info.equals("userInfo")) {
				this.queryUserinfo(request, response);
			}
			if (info.equals("updateUserInfo")) {
				this.updateUserinfo(request, response);
			}
			if (info.equals("queryUpdateUserinfo")) {
				this.queryUpdateUserinfo(request, response);
			}
			if (info.equals("pwModify")) {
				this.pwModify(request, response);
			}
			if (info.equals("invite")) {
				this.invite(request, response);
			}	
			if (info.equals("forgetPwd")) {
				this.frogetPwd(request, response);
			}	
			if (info.equals("wageAuth")){
				this.wageAuth(request, response);
			}
			if (info.equals("wage")) {
				this.queryWageList(request, response);
			}	
			if (info.equals("wageInfo")) {
				this.queryWageInfo(request, response);
			}
	}

	 //忘记密码
	 private void frogetPwd(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		 String name = request.getParameter("uname"); 
		 if(name != null && !name.equals("")){
			 UserDao data = new UserDao(); // 定义V_RecruitListDao类对象
			 String[] param = new String[2];
			 param[0] = name;
			 param[1] = name;
			 User userInfo = data.user_query("WHERE (UserName=? or Phone=?) and IsDelete=0 ",param); 
			 
			 if(!name.matches("^1[3|5|8]+\\d{9}"))
		  	  {
			   String errMassage = "请输入11位手机号码";
		  	   request.setAttribute("errMassage", errMassage);
		  	   request.getRequestDispatcher("forgetPassword.jsp").forward(request,response);
		  	   return;
		  	   }
			 if(userInfo!=null){
				 String pwd = userInfo.getPassword();
				 String mobilePhones = userInfo.getPhone();
				 String content = "您正在工作宝申请密码找回服务,您的密码是："+pwd+",建议登陆wap.igzb.cn修改您的密码。 [工作宝招聘网]";
				 SendSMS send = new SendSMS();
				 try {
					 send.sendSMS(content,mobilePhones , "2", "123", "VIP", null);
				 } catch (Exception e) {
					
				 }
				 response.sendRedirect("login.jsp"); 
			 }else{
				 String errMassage = "<p>改手机号码还不是本站会员</p>";
			  	 request.setAttribute("errMassage", errMassage);
			  	 request.getRequestDispatcher("forgetPassword.jsp").forward(request,response);
			 }
		 }else{
			 String errMassage = "<p>请输入11位手机号码</p>";
		  	 request.setAttribute("errMassage", errMassage);
		  	 request.getRequestDispatcher("forgetPassword.jsp").forward(request,response);
		 }
	 }
	 
	 //登录
	private void userLogin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		if(request.getParameter("uname") != null && request.getParameter("upw") !=null){               
			  String name = request.getParameter("uname"); 
			  String pw = request.getParameter("upw");                     
			  if(checkLogin(name,pw)){
			  //若用户成功登陆，则设置flag属性值为OK 
			  //则在欢迎页上，根据属性flag值的判定，可以知道用户是否登陆成功了      
				HttpSession session = request.getSession(true);
				//添加流量统计里面访问记录
				TrafficStatistics ts = new TrafficStatistics();
				ts.Statistics((String)request.getRemoteAddr(),name);
			    session.setAttribute("flag","OK");  
			    //可以利用session把用户名传递给欢迎页 
			    session.setAttribute("uid",uid);   
			    session.setAttribute("uname",name); 
			    session.setAttribute("realname",realname);
			    //更新最后登录时间s
			    UserDao userdata = null; 
				  userdata = new UserDao();
				  String[] userparam = new String[1];
				  userparam[0] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
				  String updateStr = "LastLoginDate=?";
				  userdata.user_Update(updateStr, userparam, uid);
			  //登陆成功后，跳转至欢迎页 
				String returl;
				if(bool==0){//第一次登陆
					session.setAttribute("firstlogin","1"); 
					returl = response.encodeURL("passwordModify.jsp");
				}else{
					returl = response.encodeURL("recruitServlet?info=mainList&amp;p=1&amp;p2=1");
					if(session.getAttribute("returl")!=null){
						returl = (String)session.getAttribute("returl");
						session.removeAttribute("returl");
					}
				}
				response.sendRedirect(returl);
			  	}else{ 	
				  String errMassage = "<div>用户名或密码错误</div>";
			  	   request.setAttribute("errMassage", errMassage);
			  	   request.getRequestDispatcher("login.jsp").forward(request,
							response);
			  	}
		}else{
			request.getRequestDispatcher("index.jsp").forward(request,
					response);
		}
	}
	//登录检查
	public boolean checkLogin(String name,String password){
		UserDao data = null; // 定义UserDao类对象
		data = new UserDao();
		String[] param = new String[2];
		param[0] = name;
		//支持手机号登录
		param[1] = name;
		User user = data.user_query("WHERE (UserName=? or Phone=?)and IsDelete=0",param);
		if(user!=null)
			if(user.getPassword().equals(password)){
				bool = 1;
				uid = user.getUserID();    //不好待改
				realname = user.getRealName();
				if(realname==null){
					realname = "";
				} else if(realname.equals("null") || realname.equals("")){
					realname = "";
				}
				if(user.getLastLoginDate() == null){//第一次登陆
					bool = 0;
				}
				return true;
			}		
		return false;
	}
	
	//注册
	private void userRerister(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		if(request.getParameter("uphone") !=null){ 
//			  String name = request.getParameter("uname"); 
			  String name = request.getParameter("uphone");
			  String phone = request.getParameter("uphone");
//			  String pw = request.getParameter("upw");
			  //生成6位动态密码
			  RandomNumber rn = new RandomNumber();
			  String pw = String.valueOf(rn.RandomNumbers(4));
			  request.setAttribute("uname", name);
			  request.setAttribute("uphone", phone);
			  request.setAttribute("upw", pw);
		      //各种查
			  if(!phone.matches("^1[3|5|8]+\\d{9}"))
			  	  {String errMassage = "请输入11位手机号码";
			  	   request.setAttribute("errMassage", errMassage);
			  	   request.getRequestDispatcher("register.jsp").forward(request,
							response);
			  	   return;
			  	   }
//			  if(!pw.matches("^[A-Za-z0-9]\\w{3,17}$"))
//			      {String errMassage = "密码由6~18为字母或数字组成！";
//			       request.setAttribute("errMassage", errMassage);
//			       request.getRequestDispatcher("register.jsp").forward(request,
//							response);
//			       return;
//			      }	
			  UserDao data = new UserDao(); // 定义UserCacheDao类对象
			  String[] param = new String[2];
			  param[0] = phone;
			  param[1] = name;		
			  {   UserDao userdata = null; // 定义UserDao类对象
				  userdata = new UserDao();
				  String[] userparam = new String[2];
				  userparam[0] = phone;	
				  userparam[1] = name;
				  User user = userdata.user_query("WHERE (Phone=? or UserName=?) and IsDelete=0 ",userparam);
				  if(user!=null){				 
					  if(phone.equals(user.getPhone())){
						  String errMassage = "该手机号已是本站会员，请登录";
					      request.setAttribute("errMassage", errMassage);
					      request.getRequestDispatcher("register.jsp").forward(request,
									response);
					      return;
					  }
					  if(name.equals(user.getUserName())){
						  String errMassage = "该用户已是本站会员，请登录";
					      request.setAttribute("errMassage", errMassage);
					      request.getRequestDispatcher("register.jsp").forward(request,
									response);
					      return;
					  }
				  }else{
						  user = new User();
						  UUID uuid = UUID.randomUUID();
						  user.setUserID(String.valueOf(uuid));
						  user.setPhone(phone);
						  user.setUserName(name);
						  user.setPassword(pw);
						  user.setInsertDate(new java.util.Date());
						  if(data.user_insert(user)){
							  //发短信
							  String content = "欢迎注册工作宝招聘网，您的账号："+user.getUserName()+",密码："+pw+",点击 http://wap.igzb.cn/u/"+phone+" 登录网站浏览第一手招聘信息。[工作宝招聘网]";
							  SendSMS sms = new SendSMS();					  
							  sms.sendSMS(content,user.getPhone() , "2", "123", "VIP", null);
							  String errMassage = "<div class=\"m-b-10\">注册成功，马上<a href=\"login.jsp\">登录</a></div>";
							  String againURL = response.encodeURL("sendAgainServlet?info=registerAgain&amp;uname="+name);
							  request.setAttribute("errMassage", errMassage);
						      request.setAttribute("againURL", againURL);
							  request.getRequestDispatcher("MassagePages.jsp").forward(request,
										response);
							  //注册成功后自动登录，不安全，弃用。
//						      request.getRequestDispatcher("userServlet?info=userLogin&uname="+name+"&upw="+pw).forward(request,
//										response);
						      				      
							}else {
								String errMassage = "注册失败";
							    request.setAttribute("errMassage", errMassage);
							    request.getRequestDispatcher("register.jsp").forward(request,
										response);
							}	
					  }				  		  
			  }
			  		 
		}
	}

	//查询个人信息
	public void queryUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		V_UserDao data = new V_UserDao(); // 定义V_RecruitListDao类对象
		String[] param = new String[1];
		HttpSession session = request.getSession(true);
		param[0] = (String) session.getAttribute("uid");
		V_User userInfo = data.user_query("WHERE UserID=?",param);  
    	request.setAttribute("userInfo", userInfo);
    	try {
    		String url = response.encodeURL("userInfomation.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		} catch (Exception e) {

		}
	}
	
	//查询修改个人信息
	public void queryUpdateUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDao data = new UserDao(); // 定义V_RecruitListDao类对象
		String[] param = new String[1];
		HttpSession session = request.getSession(true);
		param[0] = (String) session.getAttribute("uid");
		User userInfo;
		userInfo = data.user_query("WHERE UserID=?",param);  
		if(session.getAttribute("m_reModify")!= null)
		{
			userInfo.setRealName((String) session.getAttribute("m_RealName"));
			userInfo.setIDcardNum((String) session.getAttribute("m_IDcardNum"));
			//userInfo.setPhone((String) session.getAttribute("m_Phone"));
			userInfo.setEducation((String) session.getAttribute("m_Education"));
			userInfo.setSex(Integer.parseInt(session.getAttribute("m_Sex").toString()));
			session.removeAttribute("m_reModify");
			session.removeAttribute("m_RealName");
			session.removeAttribute("m_IDcardNum");
			//session.removeAttribute("m_Phone");
			session.removeAttribute("m_Education");
			session.removeAttribute("m_Sex");
		}
    	request.setAttribute("userInfo", userInfo);
    	try {
    		String url = response.encodeURL("userInfoModify.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		} catch (Exception e) {

		}
	}
	//执行修改操作
	public void updateUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean reModify = false;
		HttpSession session = request.getSession(true);
		String returl = response.encodeURL("index.jsp");
		if(session.getAttribute("returl")!=null){
			returl = (String)session.getAttribute("returl");
			session.removeAttribute("returl");
		}
		String uid = (String)session.getAttribute("uid");
		String uname = (String)session.getAttribute("uname"); 
		//String userurl = response.encodeURL("userServlet?info=userInfo");
		String updateuserurl = response.encodeURL("userServlet?info=queryUpdateUserinfo");
		UserDao data = new UserDao(); // 定义V_RecruitListDao类对象
		String[] param = new String[1];
		param[0] = uid;
		User userInfo = data.user_query("WHERE UserID=?",param);  
				
		String realName = request.getParameter("realName");
		String idcardNum = request.getParameter("idcardNum");
		String edu = request.getParameter("edu");
		int sex=0;		
		sex = Integer.valueOf(request.getParameter("sex"));
		
		String errMassage = "";
		if(realName.isEmpty()){
			errMassage = "请输入中文姓名";
		    reModify = true;
		}else if(realName.length()>10 || realName.length()<2){//长度判断
			errMassage = "中文姓名为2-10个字";
		    reModify = true;
		}else{//中文字符判断
			String source = realName; 
	        String reg_charset = "([\u4E00-\u9FA5])";
	        Pattern pch = Pattern.compile(reg_charset);     
	        Matcher mch = pch.matcher(source);     
	        int chlen = 0;
	        while (mch.find()) {     
	        	//System.out.println(mch.group(1));  
	        	chlen += 1;
	        }
	        if(chlen!=source.length()){
	        	errMassage = "请输入中文姓名";
			    reModify = true;
	        }
		}
		if(sex!=0&&sex!=1&&sex!=2){
			
			errMassage = "性别输入错误";
		   
		    reModify = true;
		}	
//		String phone = request.getParameter("phone");
//		if(!phone.matches("^1[3|4|5|8]+\\d{9}")){
//		  	String errMassage = "请正确输入手机号！";
//		    request.setAttribute("errMassage", errMassage);
//		    request.getRequestDispatcher(updateuserurl).forward(request,
//					response);
//		    return;
//		}
//		String oldphone = userInfo.getPhone();
		//身份证校验
		IDCard checkIDCard = new IDCard();
		String result = checkIDCard.IDCardValidate(idcardNum.toUpperCase());
		
		if(!result.equals("")){
			 errMassage = "请正确输入身份证号码";
		   
		    reModify = true;
			}
		
		if(reModify)
		{
			session.setAttribute("m_reModify",true);
			session.setAttribute("m_RealName",realName);
			session.setAttribute("m_IDcardNum",idcardNum);
			//session.setAttribute("m_Phone",phone);
			session.setAttribute("m_Education",edu);
			session.setAttribute("m_Sex",sex);	
			request.setAttribute("errMassage", errMassage);
		    request.getRequestDispatcher(updateuserurl).forward(request,
					response);
			return;
		}
		
		
		//有没有必要？
		userInfo.setRealName(realName);
		userInfo.setIDcardNum(idcardNum);			
		userInfo.setSex(sex);
//		userInfo.setAge(age);	
		userInfo.setEducation(edu);
		userInfo.setLastModifyBy(uname);			
		userInfo.setLastModifyDate(new java.util.Date());
		//有没有必要？
		
		/************************************************/
		/**************************初始二级密码功能，等着扔掉******/
		IDCard_WagePWDao id_wagedata = new IDCard_WagePWDao(); // 定义V_RecruitListDao类对象
		String[] id_wagedataparam = new String[1];
		id_wagedataparam[0] = userInfo.getIDcardNum();
		IDCard_WagePW id_wageinfo = id_wagedata.wagePW_query("WHERE IDCard=? ",id_wagedataparam);
		if(id_wageinfo == null)
		//if(userInfo.getWagePW() == null || userInfo.getWagePW().isEmpty())
		{
			String[] userParam = new String[7];
			userParam[0] = userInfo.getRealName();
			userParam[1] = userInfo.getIDcardNum();
			userParam[2] = String.valueOf(userInfo.getSex());
//			userParam[3] = String.valueOf(userInfo.getAge());
			userParam[3] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userInfo.getLastModifyDate());
			userParam[4] = userInfo.getLastModifyBy();
			userParam[5] = userInfo.getEducation();
			userParam[6] = userInfo.getIDcardNum().substring(userInfo.getIDcardNum().length()-7, userInfo.getIDcardNum().length()-1);
			String updateStr = "RealName=?,IDcardNum=?,Sex=?,LastModifyDate=?,LastModifyBy=?,Education=?,WagePW=?";
			id_wageinfo = new IDCard_WagePW();
			id_wageinfo.setIDCard(userInfo.getIDcardNum());
			id_wageinfo.setPhone(userInfo.getPhone());
			id_wageinfo.setWagePW(userParam[6]);
			if(data.user_Update(updateStr, userParam, uid)&&id_wagedata.wagePW_insert(id_wageinfo)){
				{
					errMassage = "更新成功,系统正在自动跳转页面<br/>如无自动跳转，请点击<a href=\""+returl+"\">返回</a>";
				    session.setAttribute("refresh", 1);
				    session.setAttribute("refreshURL", returl);
					request.setAttribute("errMassage", errMassage);
				    request.getRequestDispatcher("MassagePages.jsp").forward(request,
							response);
				    return;
				}
			}else{
				errMassage = "更新失败";
			    request.setAttribute("errMassage", errMassage);
			    request.getRequestDispatcher(updateuserurl).forward(request,
						response);
			    return;
			}
			
		}
		
		/*************************************************/
		
		
		String[] userParam = new String[6];
		userParam[0] = userInfo.getRealName();
		userParam[1] = userInfo.getIDcardNum();
		userParam[2] = String.valueOf(userInfo.getSex());
//		userParam[3] = String.valueOf(userInfo.getAge());
		userParam[3] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userInfo.getLastModifyDate());
		userParam[4] = userInfo.getLastModifyBy();
		userParam[5] = userInfo.getEducation();
		String updateStr = "RealName=?,IDcardNum=?,Sex=?,LastModifyDate=?,LastModifyBy=?,Education=?";
		
		
		if(data.user_Update(updateStr, userParam, uid)){
//			if(!phone.equals(oldphone)){
//				    String[] paramPhone = new String[1];
//				    paramPhone[0] = phone;
//					User checkUserPhone = data.user_query("WHERE Phone=?",paramPhone); 
//					if(checkUserPhone!=null)
//					{
//					    String errMassage = "该手机已被使用！";
//					    request.setAttribute("errMassage", errMassage);
//					    request.getRequestDispatcher(updateuserurl).forward(request,
//								response);
//					    return;
//					  }
////				  UserCache usercache = new UserCache();
////				  usercache.setMobilePhone(phone);
////				  usercache.setUserName(uname);			  
////				  usercache.setStatus(0); //1是注册 0是改手机号
////				  RandomNumber rn = new RandomNumber();				  
////				  usercache.setVerificationCode(rn.RandomNumbers(4));
////				  usercache.setUpdateDate(new java.util.Date());
////				  
////				  UserCacheDao userdata = new UserCacheDao();
////				  String[] ucacheparam = new String[1];
////				  ucacheparam[0] = phone;		
////				  UserCache isduplicate = userdata.userCache_query("WHERE MobilePhone=? and TIMESTAMPDIFF(MINUTE,UpdateDate,NOW())<=10",ucacheparam);
////				  if(isduplicate!=null){
////					  if(phone.equals(isduplicate.getMobilePhone()))
////						  {
////						    String errMassage = "该手机10分钟内已更改过！请先回复，或10分钟后再更改。";
////						    request.setAttribute("errMassage", errMassage);
////						    request.getRequestDispatcher(updateuserurl).forward(request,
////									response);
////						    return;
////						  }
////				  }
////				  if(userdata.userCache_insert(usercache)){
////					//发送手机短信;
////					  String content = "您在工作宝招聘网的帐号："+usercache.getUserName()+"申请更换绑定为该手机，请回复验证码："
////	  				   +usercache.getVerificationCode()+"完成更改。[工作宝招聘网]"; 
////					  SendSMS sms = new SendSMS();
////					  sms.sendSMS(content,usercache.getMobilePhone() , "2", "123", "VIP", null);
////					    String errMassage = "更新成功，请等待短信验证手机！如无自动跳转，请点击返回<a href=\""+returl+"\">详细招聘信息</a>";
////					    request.setAttribute("errMassage", errMassage);
////					    request.getRequestDispatcher(userurl).forward(request,
////								response);
////					    return;
////				  }else
//				  {
//					    String errMassage = "手机暂不支持修改！";
//					    request.setAttribute("errMassage", errMassage);
//					    request.getRequestDispatcher(updateuserurl).forward(request,
//								response);
//					    return;
//				  }						
//			}
//			else
			{
				errMassage = "更新成功,系统正在自动跳转页面<br/>如无自动跳转，请点击<a href=\""+returl+"\">返回</a>";
			    session.setAttribute("refresh", 1);
			    session.setAttribute("refreshURL", returl);
				request.setAttribute("errMassage", errMassage);
			    request.getRequestDispatcher("MassagePages.jsp").forward(request,
						response);
			    return;
			}
		}else{
			errMassage = "更新失败";
		    request.setAttribute("errMassage", errMassage);
		    request.getRequestDispatcher(updateuserurl).forward(request,
					response);
		    return;
		}
	}
	
	//修改密码
	public void pwModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String uid = (String)session.getAttribute("uid");
		String oldpw = request.getParameter("oldpw");
		String newpw = request.getParameter("newpw");
		String newpw2 = request.getParameter("newpw2");
		String userModifyurl = response.encodeURL("userServlet?info=queryUpdateUserinfo");
		String indexurl = response.encodeURL("index.jsp");
		String pwurl = response.encodeURL("passwordModify.jsp");
		if(!newpw.matches("^[A-Za-z0-9]\\w{3,17}$")||!newpw2.matches("^[A-Za-z0-9]\\w{3,17}$"))
	      {
	        String errMassage = "密码由4-18为字母或数字组成";
		    request.setAttribute("errMassage", errMassage);
		    request.getRequestDispatcher(pwurl).forward(request,
					response);
		    return;
	      }
		if(!newpw.equals(newpw2))
		  {
		    String errMassage = "两次输入密码不一致";
		    request.setAttribute("errMassage", errMassage);
		    request.getRequestDispatcher(pwurl).forward(request,
					response);
		    return;
		  }
		
		UserDao data = new UserDao(); // 定义V_RecruitListDao类对象
		String[] param = new String[1];
		param[0] = uid;
		User userInfo = data.user_query("WHERE UserID=?",param);  
		if(session.getAttribute("firstlogin")!=null){
			if(session.getAttribute("firstlogin").equals("1")){
				//第一次登陆，不需要就密码
				oldpw = userInfo.getPassword();
			}
		}
		if(!userInfo.getPassword().equals(oldpw)){
				String errMassage = "原始密码错误，请重新输入";
				request.setAttribute("errMassage", errMassage);
				request.getRequestDispatcher(pwurl).forward(request,
					response);
				return;
		}else{
			String updateStr = "Password=?";
			String[] userParam = new String[1];
			userParam[0] = newpw;
			if(data.user_Update(updateStr, userParam, uid)){
				 String errMassage = "修改密码成功,系统将自动帮你跳转<br/>如无自动跳转，请点击<a href=\""+indexurl+"\">返回</a>";
				 if(session.getAttribute("firstlogin")!=null){
					 if(session.getAttribute("firstlogin").equals("1")){//第一次登陆
						 String firstMassage = "修改密码成功，检测到您还没完善个人资料";
						 session.setAttribute("firstlogin", "0");
						 request.setAttribute("firstMassage", firstMassage);
						 request.getRequestDispatcher(userModifyurl).forward(request,
							     response);
						 return;
					 }
					 else{
						 session.setAttribute("refresh", 1);
						 session.setAttribute("refreshURL", indexurl);
					 }
				 }else{
					 session.setAttribute("refresh", 1);
					 session.setAttribute("refreshURL", indexurl);
				 }			 
				 request.setAttribute("errMassage", errMassage);
				 request.getRequestDispatcher("MassagePages.jsp").forward(request,
					     response);
				 return;
			  }else{
				  String errMassage = "修改密码失败";
				  request.setAttribute("errMassage", errMassage);
				  request.getRequestDispatcher(pwurl).forward(request,
						  response);
				  return;
			  }		
		}
		
	}
	//发送邀请短信
	public void invite(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String uname = (String)session.getAttribute("uname");
		String fphone = request.getParameter("friendPhone");
		String inviteurl = response.encodeURL("invitePage.jsp");
		if(!fphone.matches("^1[3|4|5|8]+\\d{9}"))
	  	  {String errMassage = "请输入11位手机号码";
	  	   request.setAttribute("errMassage", errMassage);
	  	   request.getRequestDispatcher(inviteurl).forward(request,
					response);
	  	   return;
	  	   }
		{
			UserDao userdata = null; // 定义UserDao类对象
			userdata = new UserDao();
			String[] userparam = new String[1];
			userparam[0] = fphone;	
			User user = userdata.user_query("WHERE Phone=? and IsDelete=0 ",userparam);
			if(user!=null){				 
				if(fphone.equals(user.getPhone())){
					String errMassage = "您的好友已经是本站会员了";
				    request.setAttribute("errMassage", errMassage);
				    request.getRequestDispatcher(inviteurl).forward(request,
							response);
				    return;
				 }
			}
		}
		
		  UserDao userdata = null; // 定义UserDao类对象
	      userdata = new UserDao();
		  String[] userparam = new String[2];
	 	  userparam[0] = uname;	
	 	  userparam[1] = uname;
		  User user = userdata.user_query("WHERE (UserName=? or Phone=?) and IsDelete=0 ",userparam);
		  String name = uname;
		  if(user!=null)
			  if(user.getRealName()!=null)
				  name=user.getRealName();

		  String content = "您的好友"+name+"(手机"+user.getPhone()+")邀请您免费注册工作宝招聘网站！马上点击链接即可注册:http://wap.igzb.cn [工作宝招聘网]";
		  SendSMS sms = new SendSMS();
		  sms.sendSMS(content,fphone , "2", "123", "VIP", null);

		    String errMassage = "邀请好友成功";
		    request.setAttribute("errMassage", errMassage);
		    request.getRequestDispatcher(inviteurl).forward(request,
					response);
		    return;
	}
	
	//验证工资密码
	public void wageAuth(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//填写完返回的url
		String returl = response.encodeURL("userServlet?info=wageAuth");
		String wageurl = response.encodeURL("userServlet?info=wage");
		//更新个人信息的url
		String updateuserurl = response.encodeURL("userServlet?info=queryUpdateUserinfo");
		
		String wagePW = request.getParameter("wagePW");
		HttpSession session = request.getSession(true);
		String uid = session.getAttribute("uid").toString();
		
		//检测个人信息完整性
		if(uid==null){
			String errMassage = "请登录后再进行操作！马上<a href=\"login.jsp\">登录</a>";
			request.setAttribute("errMassage", errMassage);
			request.getRequestDispatcher("MassagePages.jsp").forward(request,
					  response);
			return;
		}else{
			UserDao userdata = new UserDao(); // 定义V_RecruitListDao类对象
			String[] userparam = new String[1];
			userparam[0] = uid;
			User userInfo = userdata.user_query("WHERE UserID=? ",userparam);
			if(userInfo.getIDcardNum()==null||userInfo.getRealName()==null||userInfo.getSex()==0||userInfo.getEducation()==null
					||userInfo.getIDcardNum().isEmpty()||userInfo.getRealName().isEmpty()||userInfo.getEducation().isEmpty())
			{
				String firstMassage = "您还没完善个人信息呢";			
				session.setAttribute("returl", returl);
				request.setAttribute("firstMassage", firstMassage);
				request.getRequestDispatcher(updateuserurl).forward(request,
						  response);
				return;				
			}
			
			IDCard_WagePWDao id_wagedata = new IDCard_WagePWDao(); // 定义V_RecruitListDao类对象
			String[] id_wagedataparam = new String[1];
			id_wagedataparam[0] = userInfo.getIDcardNum();
			IDCard_WagePW id_wageinfo = id_wagedata.wagePW_query("WHERE IDCard=? ",id_wagedataparam);
			if(wagePW == null || wagePW.isEmpty())
			{	
				if(session.getAttribute("wagePWEdit")!=null&&session.getAttribute("wagePWEdit").equals("true"))
				//if(id_wageinfo.getWagePW().equals(userInfo.getWagePW()))
				//if(userInfo.getWagePW() == null || userInfo.getWagePW().isEmpty())//初始密码为空
				{
					//跳转至设置工资密码
					String errMassage = "确认密码由4-18为字母或数字组成";
					String firstMassage = "您的初始密码是身份证倒数第7到第2位，建议设置新的工资密码<br/>";			
					session.setAttribute("wagePWEdit", "true");
					request.setAttribute("errMassage", errMassage);
					request.setAttribute("firstMassage", firstMassage);
					request.getRequestDispatcher("wageAuth.jsp").forward(request,
							  response);
					return;		
				}
				else//跳转至输入工资密码
				{					
					request.getRequestDispatcher("wageAuth.jsp").forward(request,
							  response);
					return;
				}
			}
			else
			{	//设置密码
				if(session.getAttribute("wagePWEdit")!=null&&session.getAttribute("wagePWEdit").equals("true"))
				//if(id_wageinfo.getWagePW().equals(userInfo.getWagePW()))
				//if(userInfo.getWagePW() == null || userInfo.getWagePW().isEmpty())
				{
					session.removeAttribute("wagePWEdit");
					String wagePW2 = request.getParameter("wagePW2");
					String isEdit = request.getParameter("Edit");
					if(isEdit!=null&&isEdit.equals("false")){
						request.getRequestDispatcher(wageurl).forward(request,
								  response);
						return;
					}
					if(wagePW2 == null || wagePW2.isEmpty())
					{
						String errMassage = "确认密码由4-18为字母或数字组成";
					    String firstMassage = "初始密码是身份证倒数第7到第2位，建议设置新的工资密码<br/>";			
					    request.setAttribute("firstMassage", firstMassage);
					    request.setAttribute("errMassage", errMassage);
					    session.setAttribute("wagePWEdit", "true");
					    request.getRequestDispatcher("wageAuth.jsp").forward(request,
								response);
					    return;
					}
					if(!wagePW.equals(wagePW2))
					  {
						String errMassage = "两次密码输入不一致";
					    String firstMassage = "初始密码是身份证倒数第7到第2位，建议设置新的工资密码<br/>";			
					    request.setAttribute("firstMassage", firstMassage);
					    request.setAttribute("errMassage", errMassage);
					    session.setAttribute("wagePWEdit", "true");
					    request.getRequestDispatcher("wageAuth.jsp").forward(request,
								response);
					    return;
					  }
					userparam[0] = wagePW;
					String updateStr = "WagePW=?";
					//userdata.user_Update(updateStr, userparam, uid);				
					id_wagedata.wagePW_update(updateStr, userparam, userInfo.getIDcardNum());
					
					session.setAttribute("wagePW", "OK");
					request.getRequestDispatcher(wageurl).forward(request,
							  response);
					return;	
				}
				else	//检验密码
				{
					if(wagePW.equals(id_wageinfo.getWagePW()))
					{
						session.setAttribute("wagePW", "OK");
						if(id_wageinfo.getWagePW().equals(userInfo.getWagePW())){						
						    String firstMassage = "您的初始密码是身份证倒数第7到第2位，建议设置新的工资密码<br/>";			
						    request.setAttribute("firstMassage", firstMassage);
						    session.setAttribute("wagePWEdit", "true");
						    request.getRequestDispatcher("wageAuth.jsp").forward(request,
									response);
							return;	
						}else{
							request.getRequestDispatcher(wageurl).forward(request,
									  response);
							return;
						}
						
						
					}
					else
					{
						String errorMassage = "工资密码错误，请重新输入";				
						request.setAttribute("errMassage", errorMassage);
						request.getRequestDispatcher("wageAuth.jsp").forward(request,
								  response);
						return;	
					}
				}
			}
	/*******************下面是首次查询，自己设置密码的方法********************/
//			if(wagePW == null || wagePW.isEmpty())
//			{	
//				if(id_wageinfo == null)
//				//if(userInfo.getWagePW() == null || userInfo.getWagePW().isEmpty())//初始密码为空
//				{
//					//跳转至设置工资密码
//					String firstMassage = "您是首次查询工资，请设置工资密码<br/>" +
//										"工资密码修改请联系<a href=\"contactus.jsp\" color=\"blue\">客服</a>";			
//					
//					request.setAttribute("firstMassage", firstMassage);
//					request.getRequestDispatcher("wageAuth.jsp").forward(request,
//							  response);
//					return;		
//				}
//				else//跳转至输入工资密码
//				{					
//					request.getRequestDispatcher("wageAuth.jsp").forward(request,
//							  response);
//					return;
//				}
//			}
//			else
//			{	//设置密码
//				if(id_wageinfo == null)
//				//if(userInfo.getWagePW() == null || userInfo.getWagePW().isEmpty())
//				{
//					String wagePW2 = request.getParameter("wagePW2");
//					if(wagePW2 == null || wagePW2.isEmpty())
//					{
//						String errMassage = "确认密码由4-18为字母或数字组成";
//					    String firstMassage = "您是首次查询工资，请设置工资密码<br/>" +
//						"工资密码修改请联系<a href=\"contactus.jsp\" color=\"blue\">客服</a>";			
//					    request.setAttribute("firstMassage", firstMassage);
//					    request.setAttribute("errMassage", errMassage);
//					    request.getRequestDispatcher("wageAuth.jsp").forward(request,
//								response);
//					    return;
//					}
//					if(!wagePW.equals(wagePW2))
//					  {
//					    String errMassage = "两次输入密码不一致";
//					    String firstMassage = "您是首次查询工资，请设置工资密码<br/>" +
//						"工资密码修改请联系<a href=\"contactus.jsp\" color=\"blue\">客服</a>";				
//					    request.setAttribute("firstMassage", firstMassage);
//					    request.setAttribute("errMassage", errMassage);
//					    request.getRequestDispatcher("wageAuth.jsp").forward(request,
//								response);
//					    return;
//					  }
//					userparam[0] = wagePW;
//					String updateStr = "WagePW=?";
//					userdata.user_Update(updateStr, userparam, uid);
//					
//					id_wageinfo = new IDCard_WagePW();
//					id_wageinfo.setIDCard(userInfo.getIDcardNum());
//					id_wageinfo.setPhone(userInfo.getPhone());
//					id_wageinfo.setWagePW(wagePW);
//					id_wagedata.wagePW_insert(id_wageinfo);
//					
//					session.setAttribute("wagePW", "OK");
//					request.getRequestDispatcher(wageurl).forward(request,
//							  response);
//					return;	
//				}
//				else	//检验密码
//				{
//					if(wagePW.equals(id_wageinfo.getWagePW()))
//					{
//						session.setAttribute("wagePW", "OK");
//						request.getRequestDispatcher(wageurl).forward(request,
//								  response);
//						return;	
//					}
//					else
//					{
//						String errorMassage = "工资密码错误，请重新输入";				
//						request.setAttribute("errorMassage", errorMassage);
//						request.getRequestDispatcher("wageAuth.jsp").forward(request,
//								  response);
//						return;	
//					}
//				}
//			}
		}
		
	}

	//查询个人工资列表
	public void queryWageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//填写完返回的url
		String returl = response.encodeURL("userServlet?info=wageAuth");

		HttpSession session = request.getSession(true);
		String uid = session.getAttribute("uid").toString();
		if(session.getAttribute("wagePW") != null && session.getAttribute("wagePW").equals("OK"))
		{
			//开始查询
			
			UserDao userdata = new UserDao(); // 定义V_RecruitListDao类对象
			String[] userparam = new String[1];
			userparam[0] = uid;
			User userInfo = userdata.user_query("WHERE UserID=? ",userparam);
			
			WageDao data = new WageDao(); // 定义V_RecruitListDao类对象
			String[] param = new String[1];
			param[0] = userInfo.getIDcardNum();
			List<Wage> list = data.wage_query("WHERE IDCard=? order by Date",param);  
			request.setAttribute("wageList", list);
			String url = response.encodeURL("wageList.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		}
		else
		{
			request.getRequestDispatcher(returl).forward(request,
					response);
			return;
		}
	}

	//查询个人工资详情
	public void queryWageInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//填写完返回的url
		String returl = response.encodeURL("userServlet?info=wageAuth");

		HttpSession session = request.getSession(true);
		String uid = session.getAttribute("uid").toString();
		if(session.getAttribute("wagePW") != null && session.getAttribute("wagePW").equals("OK"))
		{
			UserDao userdata = new UserDao(); // 定义V_RecruitListDao类对象
			String[] userparam = new String[1];
			userparam[0] = uid;
			User userInfo = userdata.user_query("WHERE UserID=? ",userparam);
			
			WageDao data = new WageDao(); // 定义V_RecruitListDao类对象
			String[] param = new String[2];
			param[0] = userInfo.getIDcardNum();
			param[1] = (String) request.getParameter("wageId");
			Wage wage = data.wageinfo_query("WHERE IDCard=? and WageID=?",param);  
			request.setAttribute("wage", wage);
			String url = response.encodeURL("wage.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		}
		else
		{
			request.getRequestDispatcher(returl).forward(request,
					response);
			return;
		}

	}
}

