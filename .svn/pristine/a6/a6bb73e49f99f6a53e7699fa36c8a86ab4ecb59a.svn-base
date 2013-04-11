package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBConnection;

import bean.V_CheckIn;

public class V_CheckInDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private String sql = "";
	
	public V_CheckIn v_CheckIn_query(String whereSQL,String[] param) {
		V_CheckIn v_CheckIn = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		
		sql = "SELECT * FROM V_CheckIn "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			if (rs.next()) {
				v_CheckIn = new V_CheckIn();
				v_CheckIn.setRecruitInfoID(rs.getString("RecruitInfoID")); 
				v_CheckIn.setCompanyName(rs.getString("CompanyName"));      // 将数据表中result字段内容进行赋值
				v_CheckIn.setRecruitingNum(rs.getInt("RecruitingNum")); 
				v_CheckIn.setSex(rs.getInt("Sex")); 
				v_CheckIn.setSendMassage(rs.getString("SendMassage")); 
				v_CheckIn.setRemainNum(rs.getInt("RemainNum")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return v_CheckIn;
	}
}
