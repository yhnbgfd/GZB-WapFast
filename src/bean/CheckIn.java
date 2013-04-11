package bean;

import java.util.Date;

public class CheckIn extends VoBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2133389293042252656L;
	
	private String CheckInID;
	private String FK_RecruitInfoID;
	private String FK_UserID;
	private int IsConfirm;
	private Date InsertDate;
	private String InsertBy;
	private Date LastModifyDate;
	private String LastModifyBy;
	
	public CheckIn(){
	}
	public String getCheckInID() {
		return CheckInID;
	}
	public void setCheckInID(String CheckInID) {
		this.CheckInID = CheckInID;
	}
	public String getFK_RecruitInfoID() {
		return FK_RecruitInfoID;
	}
	public void setFK_RecruitInfoID(String FK_RecruitInfoID) {
		this.FK_RecruitInfoID = FK_RecruitInfoID;
	}	
	public String getFK_UserID() {
		return FK_UserID;
	}
	public void setFK_UserID(String FK_UserID) {
		this.FK_UserID = FK_UserID;
	}
	public int getIsConfirm() {
		return IsConfirm;
	}
	public void setIsConfirm(int IsConfirm) {
		this.IsConfirm = IsConfirm;
	}
	public Date getInsertDate() {
		return InsertDate;
	}
	public void setInsertDate(Date InsertDate) {
		this.InsertDate = InsertDate;
	}
	public String getInsertBy() {
		return InsertBy;
	}
	public void setInsertBy(String InsertBy) {
		this.InsertBy = InsertBy;
	}
	public Date getLastModifyDate() {
		return LastModifyDate;
	}
	public void setLastModifyDate(Date LastModifyDate) {
		this.LastModifyDate = LastModifyDate;
	}
	public String getLastModifyBy() {
		return LastModifyBy;
	}
	public void setLastModifyBy(String LastModifyBy) {
		this.LastModifyBy = LastModifyBy;
	}
}
