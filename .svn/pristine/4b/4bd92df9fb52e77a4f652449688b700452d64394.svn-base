package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBConnection;

import bean.V_RecruitInfo;

public class RecruitInfoDao {
	private JDBConnection connection = null; //定义数据库连接类JDBConnection对象并赋值为null
	private String sql = "";
	
	public V_RecruitInfo recruitInfo_query(String whereSQL,String[] param) {
		V_RecruitInfo recruitInfo = null;         //设置用户的UserInfo类对象
		connection = new JDBConnection(); //将JDBCOnnection对象进行实例化               
		
		sql = "SELECT * FROM V_RecruitInfo "+whereSQL;
		//设置查询的SQL语句
		if(param!=null)
			for(int i=0;i<param.length;i++)
				connection.addParameter(param[i]);
		ResultSet rs = connection.executeQuery(sql); //执行查询操作，返回结果是ResultSet结果集
		
		try {
			//对结果集对象进行循环数据
			
			if (rs.next()) {
				recruitInfo = new V_RecruitInfo();
				recruitInfo.setRecruitInfoID(rs.getString("RecruitInfoID")); 
				recruitInfo.setCompanyName(rs.getString("CompanyName"));      // 将数据表中result字段内容进行赋值
				recruitInfo.setPrice(rs.getFloat("Price"));
				recruitInfo.setRecruitingNum(rs.getInt("RecruitingNum")); 				
				recruitInfo.setInitRemainNum(rs.getInt("InitRemainNum")); 
				recruitInfo.setRemainNum(rs.getInt("RemainNum")); 
				recruitInfo.setStartTime(rs.getString("StartTime")); 
				recruitInfo.setEndTime(rs.getString("EndTime")); 
				recruitInfo.setJobName(rs.getString("JobName")); 
				recruitInfo.setEducation(rs.getString("Education")); 
				recruitInfo.setRequirement(rs.getString("Requirement")); 
				recruitInfo.setSex(rs.getInt("Sex")); 
				recruitInfo.setAge(rs.getString("Age")); 
				recruitInfo.setJobContent(rs.getString("JobContent")); 
				recruitInfo.setBenefits(rs.getString("Benefits")); 
				recruitInfo.setSalaryRange(rs.getString("SalaryRange"));
				recruitInfo.setLocation(rs.getString("Location")); 
				//recruitInfo.setRoute(rs.getString("Route")); 
				recruitInfo.setContactBy(rs.getString("ContactBy")); 
				recruitInfo.setContactNum(rs.getString("ContactNum")); 
				recruitInfo.setRemark(rs.getString("Remark")); 
				recruitInfo.setIsNew(rs.getInt("IsNew"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();                       // 执行关闭数据库链接的操作
		}			
		return recruitInfo;
	}
}
