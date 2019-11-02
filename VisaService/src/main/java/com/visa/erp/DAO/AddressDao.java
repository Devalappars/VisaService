package com.visa.erp.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "AddressDetails")
public class AddressDao extends AbstractDAO {

    @Column(name = "StudentId")
    @JsonProperty("StudentId")
    private Long studentId;

    @Column(name = "AddressType")
    @JsonProperty("AddressType")
    private String addressType;

    @Column(name = "StreetNumberOrCompleNumber")
    @JsonProperty("StreetNumberOrCompleNumber")
    private String streetNumberOrCompleNumber;

    @Column(name = "Address1")
    @JsonProperty("Address1")
    private String address1;

    @Column(name = "Address2")
    @JsonProperty("Address2")
    private String address2;

    @Column(name = "Distict")
    @JsonProperty("Distict")
    private String distict;

    @Column(name = "StateOrProvince")
    @JsonProperty("StateOrProvince")
    private String stateOrProvince;

    @Column(name = "Country")
    @JsonProperty("Country")
    private String country;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getStreetNumberOrCompleNumber() {
        return streetNumberOrCompleNumber;
    }

    public void setStreetNumberOrCompleNumber(String streetNumberOrCompleNumber) {
        this.streetNumberOrCompleNumber = streetNumberOrCompleNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistict() {
        return distict;
    }

    public void setDistict(String distict) {
        this.distict = distict;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}