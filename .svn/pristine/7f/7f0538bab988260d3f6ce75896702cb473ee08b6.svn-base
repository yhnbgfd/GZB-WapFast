package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import util.JDBConnection;
import bean.CheckIn;

public class CheckInDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private String sql = "";
	
	public boolean checkIn_insert(CheckIn checkIn) {
	
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		boolean succeed=false;
		sql = "INSERT INTO T_CheckIn (CheckInID,FK_RecruitInfoID,FK_UserID,IsConfirm,InsertDate,InsertBy,LastModifyDate,LastModifyBy)" +
							" VALUES (?,?,?,?,?,?,?,?)";
		//设置查询的SQL语句
		connection.addParameter(checkIn.getCheckInID());
		connection.addParameter(checkIn.getFK_RecruitInfoID());
		connection.addParameter(checkIn.getFK_UserID());
		connection.addParameter(String.valueOf(checkIn.getIsConfirm()));
		if(checkIn.getInsertDate()!=null)
			connection.addParameter(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(checkIn.getInsertDate()));
		else 
			connection.addParameter(null);
		connection.addParameter(checkIn.getInsertBy());
		if(checkIn.getLastModifyDate()!=null)
			connection.addParameter(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(checkIn.getLastModifyDate()));
		else 
			connection.addParameter(null);
		connection.addParameter(checkIn.getLastModifyBy());	
		
		if(connection.executeUpdate(sql))
			succeed = true;
		else 
			succeed = false;
		connection.closeConnection();                       // 执行关闭数据库链接的操作
		return succeed;
					
	}
	
	public CheckIn CheckIn_query(String whereSQL,String[] param) {
		CheckIn CheckIn = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		
		sql = "SELECT * FROM T_CheckIn "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++){
//				if(param[i]!=null)
					connection.addParameter(param[i]);
			}
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			
			if (rs.next()) {
				CheckIn = new CheckIn();
				CheckIn.setCheckInID(rs.getString("CheckInID")); 
				CheckIn.setFK_RecruitInfoID(rs.getString("FK_RecruitInfoID"));     // 将数据表中result字段内容进行赋值
				CheckIn.setFK_UserID(rs.getString("FK_UserID")); 
				CheckIn.setIsConfirm(rs.getInt("IsConfirm")); 
				CheckIn.setInsertDate(rs.getTimestamp("InsertDate")); 
				CheckIn.setInsertBy(rs.getString("InsertBy")); 
				CheckIn.setLastModifyDate(rs.getTimestamp("LastModifyDate")); 
				CheckIn.setLastModifyBy(rs.getString("LastModifyBy"));  
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return CheckIn;
	}
}
