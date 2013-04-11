package servlet;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.util.UUID;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.*;

public class SMSServlet extends HttpServlet{
	private static final long serialVersionUID = 784318064598055413L;
	private final Log log = LogFactory.getLog(getClass()); 

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		}
		this.receiveSMS(request, response);
	}
	
	/**
	 * 上行短信
	 * @param MobilePhones 用户的手机号码
	 * @param Content 用户上行的短信内容
	 * @param ExNumber 用户上行的扩展码
	 */
	private void receiveSMS(HttpServletRequest request, HttpServletResponse response){
		String MobilePhones = request.getParameter("MobilePhones");
		String Content = request.getParameter("Content");
		try {
			Content = new String(Content.getBytes("GBK"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			log.error(e1.getMessage());
		}
		String ExNumber = request.getParameter("ExNumber");
		log.warn("### Get a SMS : MobilePhones="+MobilePhones+",Content="+Content+",ExNumber="+ExNumber);
		JDBConnection db = new JDBConnection();
		ResultSet rs = null;
		SendSMS sendSMS = new SendSMS();
		RandomNumber rn = new RandomNumber();
		try {
			if(Content.matches("^[0-9]+\\d{3}")){
				rs = db.executeQuery("select MobilePhone,UserName,PassWord,Status,VerificationCode,time_to_sec(timediff(NOW(),UpdateDate)) time from T_UserCache "
						+" where (MobilePhone = '"+MobilePhones+"')");
				if(rs.next()){
					String name = rs.getString("UserName");
					String pwd = rs.getString("PassWord");
					String code = rs.getString("VerificationCode");
					int state = rs.getInt("Status");
					int t = Integer.valueOf(rs.getString("time"));
					
					if(state==1){	//注册验证
						if(t<=300){	//两分钟内  改为5分钟
							if(code.equals(Content)){
								UUID uuid = UUID.randomUUID();
								db.executeUpdate("insert into T_User (UserID,UserName,Phone,Password,UserCredit,FK_RoleID,InsertDate) "
												+"values ('"+uuid+"','"+name+"','"+MobilePhones+"','"+pwd+"',3,'d0fa3358-4247-11e1-b8d4-00145e7f6134',now())");
								db.executeUpdate("delete from T_UserCache where (MobilePhone ='"+MobilePhones+"')");
							}else if(!code.equals(Content)){	//验证码错误
								code = String.valueOf(rn.RandomNumbers(4));
								db.executeUpdate("update T_UserCache set VerificationCode ='"+code+"',UpdateDate = now() where MobilePhone='"+MobilePhones+"'");
								sendSMS.sendSMS("验证码错误，请回复新验证码 "+code+" 重新注册",MobilePhones, "2",String.valueOf(rn.RandomNumbers(3)), "VIP", ExNumber);
							}
						}
					}else if(state==0){//修改手机号
						if(code.equals(Content)){
							
							db.executeUpdate("update T_User set Phone='"+MobilePhones+"' where UserName='"+name+"'");
						}else if(!code.equals(Content)){	//验证码错误
							code = String.valueOf(rn.RandomNumbers(4));
							db.executeUpdate("update T_UserCache set VerificationCode ='"+code+"',UpdateDate = now() where MobilePhone='"+MobilePhones+"'");
							sendSMS.sendSMS("验证码错误，请回复新验证码 "+code+" 重新修改手机号",MobilePhones, "2",String.valueOf(rn.RandomNumbers(3)), "VIP", ExNumber);
						}
					}
					
				}
			}else if((Content.toLowerCase()).equals("pwd")){	//忘记密码
				rs = db.executeQuery("select PassWord from T_User where Phone='"+MobilePhones+"'");
				if(rs.next()){
					String pwd = rs.getString("PassWord");
					sendSMS.sendSMS("您的密码是："+pwd+"，请妥善保管好您的密码。",MobilePhones, "2",String.valueOf(rn.RandomNumbers(3)), "VIP", ExNumber);
				}
			}else{
//				sendSMS.sendSMS("无效短信",MobilePhones, "1","123", "GZB", ExNumber);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			db.closeConnection();
		}
	}
}
