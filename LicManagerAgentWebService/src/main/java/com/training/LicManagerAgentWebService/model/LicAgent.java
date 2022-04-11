package com.training.LicManagerAgentWebService.model;



import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LicAgent {
	
	private int id;
	private String name;
	private String mobileNumber;
	private String mail;
	private float totalPolicyAmount;
	private int managerId;

	public LicAgent(int id, String name, String mobileNumber, String mail, float totalPolicyAmount, int managerId) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.mail = mail;
		this.totalPolicyAmount = totalPolicyAmount;
		this.managerId = managerId;
	}

	public LicAgent() {
		super();
	}

	@Override
	public String toString() {
		return "LicAgent [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", mail=" + mail
				+ ", totalPolicyAmount=" + totalPolicyAmount + ", managerId=" + managerId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public float getTotalPolicyAmount() {
		return totalPolicyAmount;
	}

	public void setTotalPolicyAmount(float totalPolicyAmount) {
		this.totalPolicyAmount = totalPolicyAmount;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}

