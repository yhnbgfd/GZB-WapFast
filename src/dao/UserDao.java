package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBConnection;

import bean.User;

public class UserDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private String sql = "";
	
	public User user_query(String whereSQL,String[] param) {
		User user = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		
		sql = "SELECT * FROM T_User "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			if (rs.next()) {
				user = new User();
				user.setUserID(rs.getString("UserID")); 
				user.setUserName(rs.getString("UserName"));      // 将数据表中result字段内容进行赋值
				user.setRealName(rs.getString("RealName"));
				user.setPhone(rs.getString("Phone")); 
				user.setIDcardNum(rs.getString("IDcardNum")); 
				user.setPassword(rs.getString("Password"));    
				user.setWagePW(rs.getString("WagePW"));  
				user.setSecretQuestion(rs.getString("SecretQuestion")); 
				user.setAnswer(rs.getString("Answer"));      
				user.setSex(rs.getInt("Sex"));
			//	user.setAge(rs.getInt("Age"));      
				user.setEducation(rs.getString("Education")); 
				user.setUserCredit(rs.getInt("UserCredit")); 
				user.setRemark(rs.getString("Remark"));
				//user.setLastCheckDate(rs.getTimestamp("LastCheckDate"));    
				user.setLastLoginDate(rs.getTimestamp("LastLoginDate")); 
				user.setLastModifyDate(rs.getTimestamp("LastModifyDate")); 
				user.setLastModifyBy(rs.getString("LastModifyBy")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return user;
	}
	
	public boolean user_Update(String updateStr,String[] param,String userId){
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		boolean succeed=false;
		sql = "update T_User set "+updateStr+" where UserID=?";
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		connection.addParameter(userId);
				
		if(connection.executeUpdate(sql))
			succeed = true;
		else 
			succeed = false;
		connection.closeConnection();                       // 执行关闭数据库链接的操作
		return succeed;
	}
	
	public boolean user_insert(User user) {
		
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		boolean succeed=false;
		sql = "INSERT INTO T_User(UserID,Phone,UserName,Password,InsertDate,FK_RoleID)" +
							" VALUES (?,?,?,?,now(),'d0fa3358-4247-11e1-b8d4-00145e7f6134')";
		//设置查询的SQL语句
		connection.addParameter(user.getUserID());
		connection.addParameter(user.getPhone());
		connection.addParameter(user.getUserName());
		connection.addParameter(user.getPassword());

		if(connection.executeUpdate(sql))
			succeed = true;
		else 
			succeed = false;
		connection.closeConnection();                       // 执行关闭数据库链接的操作
		return succeed;
					
	}
	
}
