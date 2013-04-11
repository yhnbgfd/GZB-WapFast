package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import util.JDBConnection;

import bean.V_RecruitList;

public class V_RecruitListDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private List<V_RecruitList> list = null;                //定义一个List集合类，并赋值为null
	private final Log log = LogFactory.getLog(getClass()); 
	
	public List<V_RecruitList> recruitList_query(String whereSQL,String[] param) {
		V_RecruitList recruitList = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		list = new ArrayList<V_RecruitList>(); // 将List集合对象进行实例化
		String sql = "SELECT * FROM V_RecruitList "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			while (rs.next()) {
				recruitList = new V_RecruitList();
				recruitList.setRecruitInfoID(rs.getString("RecruitInfoID")); 
				recruitList.setCompanyName(rs.getString("CompanyName"));      // 将数据表中result字段内容进行赋值
				recruitList.setBenefits(rs.getString("Benefits"));
				recruitList.setSalaryRange(rs.getString("SalaryRange"));
				recruitList.setRecruitingNum(rs.getInt("RecruitingNum")); 
				recruitList.setJobName(rs.getString("JobName")); 
				//recruitList.setLevel(rs.getInt("Level"));
				//recruitList.setInsertDate(rs.getTimestamp("InsertDate"));		
				recruitList.setIsNew(rs.getInt("IsNew")); 
				list.add(recruitList); // 将查询的结果保存在List集合对象中
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return list;
	}
	
	public double recruitList_query_count(String whereSQL,String[] param) {
		connection = new JDBConnection();
		int pmax = 0;
		String sql = "select count(*) from V_RecruitList"+whereSQL;
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
