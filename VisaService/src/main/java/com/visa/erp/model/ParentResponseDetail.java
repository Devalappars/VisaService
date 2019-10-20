package com.visa.erp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.time.LocalDateTime;

public class ParentResponseDetail {

	@SerializedName("parentId")
	private Long id;

	@SerializedName("studentId")
	private Long studentId;

	public Long getStudentId() {
		return studentId;
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("middleName")
	private String middleName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("dob")
	private Date dob;

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("alternateMobile")
	private String alternateMobile;

	@JsonProperty("email")
	private String email;

	@JsonProperty("relation")
	private String relation;

	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("updatedBy")
	private String updatedBy;

	@JsonProperty("createdAt")
	private LocalDateTime createdDate;

	@JsonProperty("updatedAt")
	private LocalDateTime updatedDate;

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public Long getId() { return id;}

	public void setId(Long id) {this.id = id; }

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ParentResponseDetail{");
		sb.append("id=").append(id);
		sb.append(", studentId=").append(studentId);
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", middleName='").append(middleName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", gender='").append(gender).append('\'');
		sb.append(", dob=").append(dob);
		sb.append(", mobile='").append(mobile).append('\'');
		sb.append(", alternateMobile='").append(alternateMobile).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", relation='").append(relation).append('\'');
		sb.append(", createdBy='").append(createdBy).append('\'');
		sb.append(", updatedBy='").append(updatedBy).append('\'');
		sb.append(", createdDate=").append(createdDate);
		sb.append(", updatedDate=").append(updatedDate);
		sb.append('}');
		return sb.toString();
	}
}