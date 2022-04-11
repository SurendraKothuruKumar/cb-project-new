package com.training.paymentService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int policyId;
	String policyName;
	String policyDesc;
	String policyType;
	Float sumAssured;
	Float premium;
	int duration;
	String companyName;
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyDesc() {
		return policyDesc;
	}
	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public Float getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(Float sumAssured) {
		this.sumAssured = sumAssured;
	}
	public Float getPremium() {
		return premium;
	}
	public void setPremium(Float premium) {
		this.premium = premium;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Policy(int policyId, String policyName, String policyDesc, String policyType, Float sumAssured,
			Float premium, int duration, String companyName) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyDesc = policyDesc;
		this.policyType = policyType;
		this.sumAssured = sumAssured;
		this.premium = premium;
		this.duration = duration;
		this.companyName = companyName;
	}
	public Policy(int policyId, String policyName, String policyDesc, String policyType, Float sumAssured,
			Float premium, int duration) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyDesc = policyDesc;
		this.policyType = policyType;
		this.sumAssured = sumAssured;
		this.premium = premium;
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyDesc=" + policyDesc
				+ ", policyType=" + policyType + ", sumAssured=" + sumAssured + ", premium=" + premium + ", duration="
				+ duration + ", companyName=" + companyName + "]";
	}
	public Policy() {
		super();
	}
	
	
}
