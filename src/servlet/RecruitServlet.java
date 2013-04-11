package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bean.V_RankingList;
import bean.V_RecruitInfo;
import bean.V_RecruitList;
import dao.RecruitInfoDao;
import dao.V_NewsDao;
import dao.V_RankingListDao;
import dao.V_RecruitListDao;

public class RecruitServlet extends HttpServlet{
	private static final long serialVersionUID = -4102772699308363322L;
	private final Log log = LogFactory.getLog(getClass());

	 @Override
		public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {    
				doGet(request,response);    
			} 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String info = request.getParameter("info");  // 设置String类型对象info，该对象代表着执行不同的方法
	    HttpSession session = request.getSession(true);
	    
	    if(info.equals("mainList")){
			//未登录
			if(session.getAttribute("flag")== null){	
				//记录登陆后跳回的url
				String returl = request.getRequestURI();
				returl = returl.substring(request.getContextPath().length()+1);
				returl += "?"+request.getQueryString();
				session.setAttribute("returl", returl);
				
		    	this.queryRecruitList(request, response,2);
				this.queryRankingList(request, response,2);
				this.queryNewsList(request, response);
				String url = response.encodeURL("visiterPage.jsp");
				//response.encodeUrl(arg0);
				request.getRequestDispatcher(url).forward(request,
						response);
				return;
		    }else{
			//会员
				this.queryRecruitList(request, response,5);
				this.queryRankingList(request, response,5);
				this.queryNewsList(request, response);
				String url = response.encodeURL("mainPage.jsp");
				request.getRequestDispatcher(url).forward(request,
						response);
				return;
		    }
		}
	    //未登录点击其他请求
	    if(session.getAttribute("flag")== null){    
	    	//记录登陆后跳回的url
	    	String returl = request.getRequestURI();
	    	returl = returl.substring(request.getContextPath().length()+1);
			returl += "?"+request.getQueryString();			
			session.setAttribute("returl", returl);
			
	    	String errMassage = "<div>请先会员登录,浏览更多信息</div>";
	    	//<div>不是会员?快速注册10秒搞定</div>[<a href=\"login.jsp\">会员登录</a>]/[<a href=\"register.jsp\">快速注册</a>]
		  	   request.setAttribute("errMassage", errMassage);
		  	   request.getRequestDispatcher("login.jsp").forward(request,
						response);
			return;
	    }
		if (info.equals("queryRecruiList")) {
			this.queryRecruitList(request, response,10);
			String url = response.encodeURL("recruitList.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		}
		if(info.equals("rankingList")){
			this.queryRankingList(request, response,5);
			String url = response.encodeURL("rankingList.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		}
		if (info.equals("areaRankingList")) {
			this.queryAreaRankingList(request, response,3);
			String url = response.encodeURL("areaRankingList.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		}
		if (info.equals("queryRecruitInfo")) {
			this.queryRecruitInfo(request, response);
			String url = response.encodeURL("recruitInfo.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		}
		if (info.equals("queryLabourInfo")) {
			this.queryRecruitInfo(request, response);
			String url = response.encodeURL("labourInfo.jsp");
			request.getRequestDispatcher(url).forward(request,
					response);
			return;
		}
		
	}
	
	//查询招聘信息列表
	public void queryRecruitList(HttpServletRequest request,
			HttpServletResponse response,int pageSize) throws ServletException, IOException {
		try {
		int page = 1;
		if(request.getParameter("p")!=null)
			page = Integer.valueOf(request.getParameter("p"));
		V_RecruitListDao data = new V_RecruitListDao(); // 定义V_RecruitListDao类对象
		List<V_RecruitList> list = data.recruitList_query("order by Level DESC,InsertDate DESC limit "+(page-1)*pageSize+","+pageSize,null);  
		request.setAttribute("recruitList", list);
    	double pmax = 1;
    	if(request.getAttribute("pmax")==null){
    		pmax = data.recruitList_query_count("",null);
    		request.setAttribute("pmax", (int)Math.ceil(pmax/pageSize));
    	}	
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	//查询详细招聘信息
	public void queryRecruitInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
		RecruitInfoDao data = new RecruitInfoDao();
		String[] param = new String[1];
		param[0] = request.getParameter("id");
		V_RecruitInfo recruitInfo = data.recruitInfo_query("WHERE RecruitinfoID=? and IsDelete=0 and IsClose=0",param);  
    	request.setAttribute("recruitInfo", recruitInfo);
    	
    	
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	//查询短期工竞价排行榜
	public void queryRankingList(HttpServletRequest request,
			HttpServletResponse response,int pageSize) throws ServletException, IOException {
		try {
		int page = 1;
		if(request.getParameter("p2")!=null)
			page = Integer.valueOf(request.getParameter("p2"));
		V_RankingListDao data = new V_RankingListDao(); // 定义V_RecruitListDao类对象
		List<V_RankingList> list = data.rankingList_query("order by Price DESC,InsertDate DESC limit "+(page-1)*pageSize+","+pageSize,null);  
    	request.setAttribute("rankingList", list);
    	double pmax = 1;
    	if(request.getAttribute("pmax2")==null){
    		pmax = data.rankingList_query_count("",null);
    		request.setAttribute("pmax2", (int)Math.ceil(pmax/pageSize));
    	}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	//地区排行榜
	public void queryAreaRankingList(HttpServletRequest request,
			HttpServletResponse response,int pageSize) throws ServletException, IOException {
//		try {
//		int page = 1; //只要前三条不用翻页
//		V_RankingListDao data = new V_RankingListDao(); // 定义V_RecruitListDao类对象
//		String[] param = new String[1];
//		param[0] = "香洲";
//		List<V_RankingList> list = data.rankingList_query("where Area=? order by Price DESC,InsertDate DESC limit "+(page-1)*pageSize+","+pageSize,param);  
//    	if(list!=null)
//    		request.setAttribute("xiangzhouList", list);
//    	param[0] = "拱北";
//    	list = data.rankingList_query("where Area=? order by Price DESC,InsertDate DESC limit "+(page-1)*pageSize+","+pageSize,param);  
//    	if(list!=null)
//    		request.setAttribute("gongbeiList", list);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
		try {
			int page = 1;
			if(request.getParameter("p2")!=null)
				page = Integer.valueOf(request.getParameter("p2"));
			V_RankingListDao data = new V_RankingListDao(); // 定义V_RecruitListDao类对象
			List<V_RankingList> list = data.rankingList_query("order by Price DESC,InsertDate DESC limit "+(page-1)*pageSize+","+pageSize,null);  
	    	request.setAttribute("rankingList", list);
	    	double pmax = 1;
	    	if(request.getAttribute("pmax2")==null){
	    		pmax = data.rankingList_query_count("",null);
	    		request.setAttribute("pmax2", (int)Math.ceil(pmax/pageSize));
	    	}

			} catch (Exception e) {
				log.error(e.getMessage());
			}
	}
	
	public void queryNewsList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			V_NewsDao data = new V_NewsDao(); // 定义V_RecruitListDao类对象
			List<String> list = data.news_query("",null);  
	    	request.setAttribute("newsList", list);

			} catch (Exception e) {
				log.error(e.getMessage());
			}
	}
}
