package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bean.V_RankingList;
import util.JDBConnection;

public class V_RankingListDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private List<V_RankingList> list = null;                //定义一个List集合类，并赋值为null
	private final Log log = LogFactory.getLog(getClass()); 
	
	public List<V_RankingList> rankingList_query(String whereSQL,String[] param) {
		V_RankingList rankingList = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		list = new ArrayList<V_RankingList>(); // 将List集合对象进行实例化
		String sql = "SELECT * FROM V_RankingList "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			while (rs.next()) {
				rankingList = new V_RankingList();
				rankingList.setRecruitInfoID(rs.getString("RecruitInfoID")); 
				rankingList.setCompanyName(rs.getString("CompanyName"));      // 将数据表中result字段内容进行赋值
				rankingList.setArea(rs.getString("Area"));
				rankingList.setPrice(rs.getFloat("Price"));
				rankingList.setRecruitingNum(rs.getInt("RecruitingNum")); 
				rankingList.setJobName(rs.getString("JobName")); 
				rankingList.setLocation(rs.getString("Location"));
				//rankingList.setInsertDate(rs.getTimestamp("InsertDate"));
				rankingList.setIsNew(rs.getInt("IsNew")); 
				list.add(rankingList); // 将查询的结果保存在List集合对象中
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return list;
	}
	
	public double rankingList_query_count(String whereSQL,String[] param) {
		connection = new JDBConnection();
		int pmax = 0;
		String sql = "select count(*) from V_RankingList"+whereSQL;
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql);
		try {
			if(rs.next()){
				pmax = rs.getInt(1);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			connection.closeConnection(); 
		}
		return pmax;
	}
}
