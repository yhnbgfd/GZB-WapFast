package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBConnection;
import bean.V_News;

public class V_NewsDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private List<String> list = null; 
	private String sql = "";
	
	public List<String> news_query(String whereSQL,String[] param) {
		V_News news = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		list = new ArrayList<String>();
		sql = "SELECT * FROM V_News "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			while(rs.next()) {
				news = new V_News();
				String mark = rs.getString("mark");
				if(mark.equals("checkIn"))
				{
					//news.setUser(rs.getString("User"));
					news.setUser(rs.getString("User").substring(0, 1)+"**"); 
					if(rs.getInt("IsCasual")==0)
						news.setMark("刚刚报名了<a href=\"recruitServlet?info=queryRecruitInfo&amp;id="+rs.getString("RecruitInfoID")+"\">"+rs.getString("JobName")+"</a>"); 
					else
						news.setMark("刚刚报名了<a href=\"recruitServlet?info=queryLabourInfo&amp;id="+rs.getString("RecruitInfoID")+"\">"+rs.getString("JobName")+"</a>"); 
					
				}
				else if(mark.equals("register"))
				{
					news.setUser("手机尾号"+rs.getString("User").substring(7,11)); 
					news.setMark("刚刚加入了工作宝");   
				}
				else if(mark.equals("login"))
				{					
					if(rs.getString("User").length()==11)
						news.setUser("手机尾号"+rs.getString("User").substring(7,11));
					else
						//news.setUser(rs.getString("User"));
						news.setUser(rs.getString("User").substring(0, 1)+"**"); 
					news.setMark("刚刚登陆了工作宝");      
				}
				else if(mark.equals("update"))
				{					
					news.setUser(rs.getString("User").substring(0, 1)+"**"); 
					news.setMark("刚刚更新了个人信息");      
				}
				
				//各种待改。bean，dao这里待修改
				list.add(news.getUser()+news.getMark());
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return list;
	}
}
