package bean;


public class V_RecruitInfo extends VoBase{
/**
	 * 
	 */
	private static final long serialVersionUID = -2453846028645575834L;

//	RecruitInfID	GUID  varchar(36)
//	Type	GUID  varchar(36)
//	CompanyName	varchar(50)
//	RecruitingNum	num
//	StartTime	datetime
//	EndTime	datetime
//	JobName	varchar(50)
//	Requirement	varchar(400)
//	Sex	int(1)
//	Age	varchar(50)
//	JobContent	varchar(400)
//	Benefits	varchar(400)
//	Location	varchar(400)
//	Route	varchar(400)
//	ContactBy	varchar(50)
//	ContactNum	long
//	Remark	varchar(200)
	
	private String RecruitInfID;
	private String Type;
	private String CompanyName;
	private float Price;
	private int RecruitingNum;
	private int InitRemainNum;	
	private int RemainNum;
	private String StartTime;
	private String EndTime;
	private String JobName;	
	private String Education;
	private String Requirement;
	private int Sex;
	private String Age;
	private String JobContent;
	private String Benefits;
	private String SalaryRange;
	private String Location;
	//private String Route;
	private String ContactBy;
	private String ContactNum;  
	private String Remark;
	private int IsNew;
	private String Pre;
	private String Next;
	
	public V_RecruitInfo(){
	}
	public String getRecruitInfoID() {
		return RecruitInfID;
	}
	public void setRecruitInfoID(String RecruitInfID) {
		this.RecruitInfID = RecruitInfID;
	}	
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String CompanyName) {
		this.CompanyName = CompanyName;
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
	
	public int getInitRemainNum() {
		return InitRemainNum;
	}
	public void setInitRemainNum(int InitRemainNum) {
		this.InitRemainNum = InitRemainNum;
	}
	public int getRemainNum() {
		return RemainNum;
	}
	public void setRemainNum(int RemainNum) {
		this.RemainNum = RemainNum;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String StartTime) {
		this.StartTime = StartTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String EndTime) {
		this.EndTime = EndTime;
	}
	public String getJobName() {
		return JobName;
	}
	public void setJobName(String JobName) {
		this.JobName = JobName;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String Education) {
		this.Education = Education;
	}
	public String getRequirement() {
		return Requirement;
	}
	public void setRequirement(String Requirement) {
		this.Requirement = Requirement;
	}
	public int getSex() {
		return Sex;
	}
	public void setSex(int Sex) {
		this.Sex = Sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String Age) {
		this.Age = Age;
	}
	public String getJobContent() {
		return JobContent;
	}
	public void setJobContent(String JobContent) {
		this.JobContent = JobContent;
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
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
//	public String getRoute() {
//		return Route;
//	}
//	public void setRoute(String Route) {
//		this.Route = Route;
//	}
	public String getContactBy() {
		return ContactBy;
	}
	public void setContactBy(String ContactBy) {
		this.ContactBy = ContactBy;
	}
	public String getContactNum() {
		return ContactNum;
	}
	public void setContactNum(String ContactNum) {
		this.ContactNum = ContactNum;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
	public int getIsNew() {
		return IsNew;
	}
	public void setIsNew(int IsNew) {
		this.IsNew = IsNew;
	}
	public String getPre() {
		return Pre;
	}
	public void setPre(String Pre) {
		this.Pre = Pre;
	}
	public String getNext() {
		return Next;
	}
	public void setNext(String Next) {
		this.Next = Next;
	}
}
