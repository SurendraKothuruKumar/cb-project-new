package com.training.paymentService.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	
	 @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int paymentId;
		private int userId;
		private int policyId;
		private LocalDate billdate;
		private Float fine;
		private Float paymentAmount;
		private LocalDate dueDate;
		private String status;
		private String paymentType;
		public int getPaymentId() {
			return paymentId;
		}
		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getPolicyId() {
			return policyId;
		}
		public void setPolicyId(int policyId) {
			this.policyId = policyId;
		}
		public LocalDate getBilldate() {
			return billdate;
		}
		public void setBilldate(LocalDate billdate) {
			this.billdate = billdate;
		}
		public Float getFine() {
			return fine;
		}
		public void setFine(Float fine) {
			this.fine = fine;
		}
		public Float getPaymentAmount() {
			return paymentAmount;
		}
		public void setPaymentAmount(Float paymentAmount) {
			this.paymentAmount = paymentAmount;
		}
		public LocalDate getDueDate() {
			return dueDate;
		}
		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getPaymentType() {
			return paymentType;
		}
		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}
		public Payment(int paymentId, int userId, int policyId, LocalDate billdate, Float fine, Float paymentAmount,
				LocalDate dueDate, String status, String paymentType) {
			super();
			this.paymentId = paymentId;
			this.userId = userId;
			this.policyId = policyId;
			this.billdate = billdate;
			this.fine = fine;
			this.paymentAmount = paymentAmount;
			this.dueDate = dueDate;
			this.status = status;
			this.paymentType = paymentType;
		}
		public Payment() {
			super();
		}
		
		

}
