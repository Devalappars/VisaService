package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class EducationResponseDetail {

	@SerializedName("studentId")
	private Long studentId;

	@SerializedName("education")
	private String education;

	@SerializedName("boardOfEducation")
	private String boardOfEducation;

	@SerializedName("scoreType")
	private String scoreType;

	@SerializedName("totalScore")
	private String totalScore;

	@SerializedName("marksScored")
	private String marksScored;

	@SerializedName("grade")
	private String grade;

	@SerializedName("yearOfCompletion")
	private String yearOfCompletion;

	@SerializedName("status")
	private String status;

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

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getBoardOfEducation() {
		return boardOfEducation;
	}

	public void setBoardOfEducation(String boardOfEducation) {
		this.boardOfEducation = boardOfEducation;
	}

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(String marksScored) {
		this.marksScored = marksScored;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getYearOfCompletion() {
		return yearOfCompletion;
	}

	public void setYearOfCompletion(String yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
}