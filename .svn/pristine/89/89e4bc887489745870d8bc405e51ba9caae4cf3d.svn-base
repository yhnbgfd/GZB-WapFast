package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBConnection;
import bean.V_User;

public class V_UserDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private String sql = "";
	
	public V_User user_query(String whereSQL,String[] param) {
		V_User user = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		
		sql = "SELECT * FROM V_User "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			if (rs.next()) {
				user = new V_User();
				user.setUserID(rs.getString("UserID")); 
				user.setUserName(rs.getString("UserName"));      // 将数据表中result字段内容进行赋值
				user.setRealName(rs.getString("RealName"));
				user.setPhone(rs.getString("Phone")); 
				user.setIDcardNum(rs.getString("IDcardNum")); 
				user.setPassword(rs.getString("Password"));      
				user.setSecretQuestion(rs.getString("SecretQuestion")); 
				user.setAnswer(rs.getString("Answer"));      
				user.setSex(rs.getInt("Sex"));
			//	user.setAge(rs.getInt("Age"));      
				user.setEducation(rs.getString("Education")); 
				user.setUserCredit(rs.getInt("UserCredit")); 
				user.setRemark(rs.getString("Remark"));
				user.setLastCheckDate(rs.getTimestamp("LastCheckDate"));
				user.setLastCheckRecruitID(rs.getString("LastCheckRecruitID"));
				user.setLastCheckCompName(rs.getString("LastCheckCompName"));
				user.setLastCheckIsCasual(rs.getInt("LastCheckIsCasual"));
				user.setLastLoginDate(rs.getTimestamp("LastLoginDate")); 
				user.setLastModifyDate(rs.getTimestamp("LastModifyDate")); 
				user.setLastModifyBy(rs.getString("LastModifyBy")); 
				user.setCentreMsg(rs.getString("CentreMsg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return user;
	}
}
