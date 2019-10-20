package com.visa.erp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.visa.erp.DAO.AbstractDAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDateTime;

public class StudentRequest {

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("middleName")
	private String middleName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("gender")
	private String gender;

	@SerializedName("dob")
	private Date dob;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("alternateMobile")
	private String alternateMobile;

	@SerializedName("email")
	private String email;

	@SerializedName("enrollmentYear")
	private String enrollmentYear;

	@SerializedName("enrollmentStatus")
	private String enrollmentStatus;

	@SerializedName("createdBy")
	private String createdBy;

	@SerializedName("updatedBy")
	private String updatedBy;

	@SerializedName("createdDate")
	private LocalDateTime createdDate;

	@SerializedName("updatedDate")
	private LocalDateTime updatedDate;

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

	public String getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(String enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}

	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("StudentRequest{");
		sb.append("firstName='").append(firstName).append('\'');
		sb.append(", middleName='").append(middleName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", gender='").append(gender).append('\'');
		sb.append(", dob=").append(dob);
		sb.append(", mobile='").append(mobile).append('\'');
		sb.append(", alternateMobile='").append(alternateMobile).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", enrollmentYear='").append(enrollmentYear).append('\'');
		sb.append(", enrollmentStatus='").append(enrollmentStatus).append('\'');
		sb.append(", createdBy='").append(createdBy).append('\'');
		sb.append(", updatedBy='").append(updatedBy).append('\'');
		sb.append(", createdDate=").append(createdDate);
		sb.append(", updatedDate=").append(updatedDate);
		sb.append('}');
		return sb.toString();
	}
}