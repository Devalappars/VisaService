package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class SOFResponseDetails {

	@SerializedName("studentId")
	private Long studentId;

	@SerializedName("parentsOccupation")
	private String parentsOccupation;

	@SerializedName("jobCategory")
	private String jobCategory;

	@SerializedName("jobType")
	private String jobType;

	@SerializedName("monthlyIncome")
	private String monthlyIncome;

	@SerializedName("proofOfIncomeDocumentType")
	private String proofOfIncomeDocumentType;

	@SerializedName("createdBy")
	private String createdBy;

	@SerializedName("updatedBy")
	private String updatedBy;

	@SerializedName("createdDate")
	private LocalDateTime createdDate;

	@SerializedName("updatedDate")
	private LocalDateTime updatedDate;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getParentsOccupation() { return parentsOccupation;	}

	public void setParentsOccupation(String parentsOccupation) { this.parentsOccupation = parentsOccupation; }

	public String getJobCategory() { return jobCategory; }

	public void setJobCategory(String jobCategory) { this.jobCategory = jobCategory; }

	public String getJobType() {	return jobType;	}

	public void setJobType(String jobType) {	this.jobType = jobType; 	}

	public String getMonthlyIncome() {	return monthlyIncome;	}

	public void setMonthlyIncome(String monthlyIncome) {	this.monthlyIncome = monthlyIncome; 	}

	public String getProofOfIncomeDocumentType() {	return proofOfIncomeDocumentType;	}

	public void setProofOfIncomeDocumentType(String proofOfIncomeDocumentType) {	this.proofOfIncomeDocumentType = proofOfIncomeDocumentType;	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}