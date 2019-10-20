package com.visa.erp.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Student")
public class StudentDao extends AbstractDAO {

    private static final long serialVersionUID = -4613186672863162521L;

    @Column(name = "FirstName")
    @JsonProperty("FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    @JsonProperty("MiddleName")
    private String middleName;

    @Column(name = "LastName")
    @JsonProperty("LastName")
    private String lastName;

    @Column(name = "Gender")
    @JsonProperty("Gender")
    private String gender;

    @Column(name = "Dob")
    @JsonProperty("Dob")
    private Date dob;

    @Column(name = "Mobile")
    @JsonProperty("Mobile")
    private String mobile;

    @Column(name = "AlternateMobile")
    @JsonProperty("AlternateMobile")
    private String alternateMobile;

    @Column(name = "Email")
    @JsonProperty("Email")
    private String email;

    @Column(name = "EnrollmentYear")
    @JsonProperty("EnrollmentYear")
    private String enrollmentYear;

    @Column(name = "EnrollmentStatus")
    @JsonProperty("EnrollmentStatus")
    private String enrollmentStatus;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentDao{");
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
        sb.append('}');
        return sb.toString();
    }
}