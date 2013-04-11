package bean;

import java.util.Date;

public class V_RankingList extends VoBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 487541791212016673L;

	//视图bean
	/**
	 * 
	 */

//RecruitInfID	GUID  varchar(36)
//	Type	GUID  varchar(36)
//	CompanyName	varchar(50)
//	RecruitingNum	num
//	JobName	varchar(50)
	
	public V_RankingList(){
	}
	private String RecruitInfoID;	
	private String CompanyName;
	private String Area;
	private float Price;
	private int RecruitingNum;
	private String JobName;
	private String Location;
	private Date InsertDate;
	private int IsNew;
	
	public String getRecruitInfoID() {
		return RecruitInfoID;
	}
	public void setRecruitInfoID(String RecruitInfoID) {
		this.RecruitInfoID = RecruitInfoID;
	}	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String CompanyName) {
		this.CompanyName = CompanyName;
	}	
	public String getArea() {
		return Area;
	}
	public void setArea(String Area) {
		this.Area = Area;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float Price) {
		this.Price = Price;
	}
	public int getRecruitingNum() {
		return RecruitingNum;
	}
	public void setRecruitingNum(int RecruitingNum) {
		this.RecruitingNum = RecruitingNum;
	}
	public String getJobName() {
		return JobName;
	}
	public void setJobName(String JobName) {
		this.JobName = JobName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	public Date getInsertDate() {
		return InsertDate;
	}
	public void setInsertDate(Date InsertDate) {
		this.InsertDate = InsertDate;
	}
	public int getIsNew() {
		return IsNew;
	}
	public void setIsNew(int IsNew) {
		this.IsNew = IsNew;
	}
	
}