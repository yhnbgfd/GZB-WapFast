package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBConnection;

public class OptionsDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private String sql = "";
	
	public boolean admin_sms(){
		boolean succeed=false;
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化
		sql = "SELECT option_value FROM T_Options WHERE option_name = '离开模式' ";
		ResultSet rs = connection.executeQuery(sql);
		try {
			if(rs.next()){
				if(rs.getString("option_value").equals("ON")){
					succeed = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}
		return succeed;
	}
	
	public String admin_phone(){
		String phone = "";
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化
		sql = "SELECT option_value FROM T_Options WHERE option_name = '离开模式管理员手机' ";
		ResultSet rs = connection.executeQuery(sql);
		try {
			if(rs.next()){
				phone = rs.getString("option_value");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}
		return phone;
	}
}
