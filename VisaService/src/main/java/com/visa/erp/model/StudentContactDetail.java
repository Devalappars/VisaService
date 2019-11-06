package com.visa.erp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.time.LocalDateTime;

public class StudentContactDetail {

	@SerializedName("studentId")
	private Long studentId;

	public Long getStudentId() {
		return studentId;
	}

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("alternateMobile")
	private String alternateMobile;

	@JsonProperty("parentMobile")
	private String parentMobile;

	@JsonProperty("parentAlternateMobile")
	private String parentAlternateMobile;

	@JsonProperty("email")
	private String email;

	public String getMobile() {
		return mobile;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public String getEmail() {
		return email;
	}

	public String getParentMobile() { return parentMobile;	}

	public String getParentAlternateMobile() { return parentAlternateMobile; }

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public void setParentMobile(String parentMobile) {
		this.parentMobile = parentMobile;
	}

	public void setParentAlternateMobile(String parentAlternateMobile) {
		this.parentAlternateMobile = parentAlternateMobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("StudentContactDetail{");
		sb.append("studentId=").append(studentId);
		sb.append(", mobile='").append(mobile).append('\'');
		sb.append(", alternateMobile='").append(alternateMobile).append('\'');
		sb.append(", parentMobile='").append(parentMobile).append('\'');
		sb.append(", parentAlternateMobile='").append(parentAlternateMobile).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append('}');
		return sb.toString();
	}
}