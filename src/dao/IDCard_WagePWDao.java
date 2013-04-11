package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import util.JDBConnection;
import bean.IDCard_WagePW;
import bean.User;

public class IDCard_WagePWDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private final Log log = LogFactory.getLog(getClass()); 
	
	public IDCard_WagePW wagePW_query(String whereSQL,String[] param) {
		IDCard_WagePW wage = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
	
		String sql = "SELECT * FROM T_IDCard_WagePW "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			if (rs.next()) {
				wage = new IDCard_WagePW();
				//wage.setWageID(rs.getInt("WageID")); 
				wage.setIDCard(rs.getString("IDCard"));      // 将数据表中result字段内容进行赋值
				wage.setPhone(rs.getString("Phone")); 
				wage.setWagePW(rs.getString("wagePW"));
				//wage.setWage(rs.getString("Wage")); 
				//wage.setDate(rs.getDate("Date"));
				//wage.setFactory(rs.getString("Factory"));      
				//wage.setJSON(rs.getString("JSON")); 
			}
		} catch (SQLException e) {
			log.error(e.getMessage());

		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return wage;
	}
	
	public boolean wagePW_insert(IDCard_WagePW wagePW) {
		
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		boolean succeed=false;
		String sql = "INSERT INTO T_IDCard_WagePW(IDCard,Phone,WagePW)" +
							" VALUES (?,?,?)";
		//设置查询的SQL语句
		connection.addParameter(wagePW.getIDCard());
		connection.addParameter(wagePW.getPhone());
		connection.addParameter(wagePW.getWagePW());
		

		if(connection.executeUpdate(sql))
			succeed = true;
		else 
			succeed = false;
		connection.closeConnection();                       // 执行关闭数据库链接的操作
		return succeed;
					
	}
	
public boolean wagePW_update(String updateStr,String[] param,String IDCard) {
		
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		boolean succeed=false;
		String sql = "update T_IDCard_WagePW set "+updateStr+" where IDCard=?";
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		connection.addParameter(IDCard);
		//设置查询的SQL语句

		if(connection.executeUpdate(sql))
			succeed = true;
		else 
			succeed = false;
		connection.closeConnection();                       // 执行关闭数据库链接的操作
		return succeed;
	
	}
}
