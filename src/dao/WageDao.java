package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bean.Wage;
import util.JDBConnection;

public class WageDao {

	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private List<Wage> list = null;                //定义一个List集合类，并赋值为null
	private final Log log = LogFactory.getLog(getClass()); 
	
	public List<Wage> wage_query(String whereSQL,String[] param) {
		Wage wage = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		list = new ArrayList<Wage>(); // 将List集合对象进行实例化
		String sql = "SELECT * FROM T_Wage "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			while (rs.next()) {
				wage = new Wage();
				wage.setWageID(rs.getInt("WageID")); 
				wage.setIDCard(rs.getString("IDCard"));      // 将数据表中result字段内容进行赋值
				wage.setPhone(rs.getString("Phone")); 
				wage.setWage(rs.getString("Wage")); 
				wage.setDate(rs.getDate("Date"));
				wage.setFactory(rs.getString("Factory"));     
				
				//wage.setJSON(rs.getString("JSON")); 
				list.add(wage); 
			}
		} catch (SQLException e) {
			log.error(e.getMessage());

		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return list;
	}
	
	public Wage wageinfo_query(String whereSQL,String[] param) {
		Wage wage = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
	
		String sql = "SELECT * FROM T_Wage "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			if (rs.next()) {
				wage = new Wage();
				wage.setWageID(rs.getInt("WageID")); 
				wage.setIDCard(rs.getString("IDCard"));      // 将数据表中result字段内容进行赋值
				wage.setPhone(rs.getString("Phone")); 
				wage.setWage(rs.getString("Wage")); 
				wage.setDate(rs.getDate("Date"));
				wage.setFactory(rs.getString("Factory")); 
				wage.setAgentInfo(rs.getString("AgentInfo"));
				wage.setJSON(rs.getString("JSON")); 
			}
		} catch (SQLException e) {
			log.error(e.getMessage());

		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return wage;
	}
}
