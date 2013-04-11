package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

import dao.UserDao;

public class RewriteServlet extends HttpServlet{
	private static final long serialVersionUID = 2534612565267436153L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info = request.getParameter("info");  // 设置String类型对象info，该对象代表着执行不同的方法
		if (info.equals("u")) {
			this.user(request, response);
		}
		if (info.equals("r")) {
			this.recruit(request, response);
		}
	}
	
	public void user (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UserDao data = new UserDao();
		String[] param = new String[1];
		param[0] = id;		
		User usercache = data.user_query("WHERE phone=? ",param);
		if(usercache!=null){
			String name = usercache.getUserName();
			String pw = usercache.getPassword();
			request.getRequestDispatcher("userServlet?info=userLogin&uname="+name+"&upw="+pw).forward(request,response);
		}else{
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}
	
	public void recruit (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UserDao data = new UserDao();
		String[] param = new String[1];
		param[0] = id;		
		User usercache = data.user_query("WHERE phone=? ",param);
		if(usercache!=null){
			String name = usercache.getUserName();
			String pw = usercache.getPassword();
			//这里登录后应该跳到招聘信息页面。
			request.getRequestDispatcher("userServlet?info=userLogin&uname="+name+"&upw="+pw).forward(request,response);
		}else{
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}
	}
}
