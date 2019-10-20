package com.visa.erp.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="ParentDetails")
public class ParentDetailsDao extends AbstractDAO{

    private static final long serialVersionUID = -4613186672863162521L;

    @Column(name="StudentId")
    @JsonProperty("StudentId")
    private Long studentId;

    @Column(name="FirstName")
    @JsonProperty("FirstName")
    private String firstName;

    @Column(name="MiddleName")
    @JsonProperty("MiddleName")
    private String middleName;

    @Column(name="LastName")
    @JsonProperty("LastName")
    private String lastName;

    @Column(name="Relation")
    @JsonProperty("Relation")
    private String relation;

    @Column(name="Mobile")
    @JsonProperty("Mobile")
    private String mobile;

    @Column(name="AlternateMobile")
    @JsonProperty("AlternateMobile")
    private String alternateMobile;

    @Column(name="Email")
    @JsonProperty("Email")
    private String email;

    public Long getStudentId() {  return studentId;  }

    public void setStudentId(Long studentId) { this.studentId = studentId;  }

    public String getFirstName() {   return firstName;    }

    public void setFirstName(String firstName) {        this.firstName = firstName;    }

    public String getMiddleName() {     return middleName;    }

    public void setMiddleName(String middleName) {    this.middleName = middleName;    }

    public String getLastName() {   return lastName;  }

    public void setLastName(String lastName) {   this.lastName = lastName;  }

    public String getRelation() {  return relation;    }

    public void setRelation(String relation) {   this.relation = relation;    }

    public String getMobile() {        return mobile;    }

    public void setMobile(String mobile) {        this.mobile = mobile;    }

    public String getAlternateMobile() {        return alternateMobile;    }

    public void setAlternateMobile(String alternateMobile) {        this.alternateMobile = alternateMobile;    }

    public String getEmail() {   return email;    }

    public void setEmail(String email) {        this.email = email;    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ParentDetailsDao{");
        sb.append("StudentId='").append(studentId).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", relation='").append(relation).append('\'');
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", alternateMobile='").append(alternateMobile).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
