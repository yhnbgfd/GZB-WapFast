package bean;

import java.util.Date;

import org.json.JSONException;

import util.Json;

public class Wage extends VoBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5667441036880828241L;

	private int WageID;
	private String IDCard;
	private String Phone;
	private String AgentInfo;
	private String Wage;
	private Date Date;
	private String Factory;
	private String JSON;
	
	public Wage(){
	}
	public int getWageID() {
		return WageID;
	}
	public void setWageID(int WageID) {
		this.WageID = WageID;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String IDCard) {
		this.IDCard = IDCard;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public String getAgentInfo() {
		return AgentInfo;
	}
	public void setAgentInfo(String agentInfo) {
		AgentInfo = agentInfo;
	}
	public String getWage() {
		return Wage;
	}
	public void setWage(String Wage) {
		this.Wage = Wage;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date Date) {
		this.Date = Date;
	}
	public String getFactory() {
		return Factory;
	}
	public void setFactory(String Factory) {
		this.Factory = Factory;
	}
	public String getJSON() {
		return JSON;
	}
	public void setJSON(String JSON) {
		Json js = new Json();
		try {
			this.JSON = js.get(JSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.JSON = "数据格式错误";
		}
	}
	
}
