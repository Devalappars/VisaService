package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class IdDetailsRequest {

    @SerializedName("studentId")
    private Long studentId;

    @SerializedName("idType")
    private Integer idType;

    @SerializedName("idNumber")
    private String idNumber;

    @SerializedName("idIssueDate")
    private String idIssueDate;

    @SerializedName("idExpiryDate")
    private String idExpiryDate;

    @SerializedName("countryOfIssue")
    private String countryOfIssue;

    @SerializedName("isPassport")
    private Boolean isPassport;

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

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdIssueDate() {
        return idIssueDate;
    }

    public void setIdIssueDate(String idIssueDate) {
        this.idIssueDate = idIssueDate;
    }

    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    public void setIdExpiryDate(String idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public Boolean getPassport() {
        return isPassport;
    }

    public void setPassport(Boolean passport) {
        isPassport = passport;
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