package com.visa.erp.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SourceOfFunds")
public class SOFDao extends AbstractDAO {

    @Column(name = "StudentId")
    @JsonProperty("studentId")
    private Long studentId;

    @Column(name = "ParentsOccupation")
    @JsonProperty("parentsOccupation")
    private String parentsOccupation;

    @Column(name = "JobCategory")
    @JsonProperty("jobCategory")
    private String jobCategory;

    @Column(name = "JobType")
    @JsonProperty("jobType")
    private String jobType;

    @Column(name = "MonthlyIncome")
    @JsonProperty("monthlyIncome")
    private String monthlyIncome;

    @Column(name = "ProofOfIncomeDocumentType")
    @JsonProperty("proofOfIncomeDocumentType")
    private String proofOfIncomeDocumentType;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getParentsOccupation() {
        return parentsOccupation;
    }

    public void setParentsOccupation(String parentsOccupation) {
        this.parentsOccupation = parentsOccupation;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getProofOfIncomeDocumentType() {
        return proofOfIncomeDocumentType;
    }

    public void setProofOfIncomeDocumentType(String proofOfIncomeDocumentType) {
        this.proofOfIncomeDocumentType = proofOfIncomeDocumentType;
    }
}