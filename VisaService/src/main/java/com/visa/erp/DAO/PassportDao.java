package com.visa.erp.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PassportDetails")
public class PassportDao extends AbstractDAO {

    @Column(name = "StudentId")
    @JsonProperty("StudentId")
    private Long studentId;

    @Column(name = "PassportId")
    @JsonProperty("passportId")
    private String passportId;

    @Column(name = "ExpiryDate")
    @JsonProperty("expiryDate")
    private String expiryDate;

    @Column(name = "IssuedDate")
    @JsonProperty("issuedDate")
    private String issuedDate;

    @Column(name = "PlaceOfIssued")
    @JsonProperty("placeOfIssued")
    private String placeOfIssued;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getPlaceOfIssued() {
        return placeOfIssued;
    }

    public void setPlaceOfIssued(String placeOfIssued) {
        this.placeOfIssued = placeOfIssued;
    }
}