package bean;

import java.util.Date;

public class V_RecruitList extends VoBase {
	//视图bean
	/**
	 * 
	 */
	private static final long serialVersionUID = 2076140092030919931L;

//RecruitInfID	GUID  varchar(36)
//	Type	GUID  varchar(36)
//	CompanyName	varchar(50)
//	RecruitingNum	num
//	JobName	varchar(50)
	
	public V_RecruitList(){
	}
	private String RecruitInfoID;	
	private String CompanyName;
	private String Benefits;
	private String SalaryRange;
	private int RecruitingNum;
	private String JobName;
	
	private int Level;
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
	public String getBenefits() {
		return Benefits;
	}
	public void setBenefits(String Benefits) {
		this.Benefits = Benefits;
	}
	public String getSalaryRange() {
		return SalaryRange;
	}
	public void setSalaryRange(String SalaryRange) {
		this.SalaryRange = SalaryRange;
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
	public int getLevel() {
		return Level;
	}
	public void setLevel(int Level) {
		this.Level = Level;
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
