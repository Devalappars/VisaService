package com.visa.erp.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "IdDetails")
public class IdDetailsDao extends AbstractDAO {

    @Column(name = "StudentId")
    @JsonProperty("StudentId")
    private Long studentId;

    @Column(name = "IdType")
    @JsonProperty("IdType")
    private Integer idType;

    @Column(name = "IdNumber")
    @JsonProperty("IdNumber")
    private String idNumber;

    @Column(name = "IdIssueDate")
    @JsonProperty("IdIssueDate")
    private LocalDateTime idIssueDate;

    @Column(name = "IdExpiryDate")
    @JsonProperty("IdExpiryDate")
    private LocalDateTime idExpiryDate;

    @Column(name = "CountryOfIssue")
    @JsonProperty("CountryOfIssue")
    private String countryOfIssue;

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

    public LocalDateTime getIdIssueDate() {
        return idIssueDate;
    }

    public void setIdIssueDate(LocalDateTime idIssueDate) {
        this.idIssueDate = idIssueDate;
    }

    public LocalDateTime getIdExpiryDate() {
        return idExpiryDate;
    }

    public void setIdExpiryDate(LocalDateTime idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }
}