package com.visa.erp.DAO;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.visa.erp.DAO.AbstractDAO;

@Entity
@Table(name="StudentDao")
public class StudentDao extends AbstractDAO {

	private static final long serialVersionUID = -4613186672863162521L;
	
	@Column(name="FirstName")
	@JsonProperty("FirstName")
	private String firstName;

	@Column(name="MiddleName")
	@JsonProperty("MiddleName")
	private String middleName;

	@Column(name="LastName")
	@JsonProperty("LastName")
	private String lastName;

	@Column(name="Gender")
	@JsonProperty("Gender")
	private String gender;

	@Column(name="Dob")
	@JsonProperty("Dob")
	private Date dob;

	@Column(name="Mobile")
	@JsonProperty("Mobile")
	private String mobile;

	@Column(name="AlternateMobile")
	@JsonProperty("AlternateMobile")
	private String alternateMobile;

	@Column(name="Email")
	@JsonProperty("Email")
	private String email;

	@Column(name="EnrollmentYear")
	@JsonProperty("EnrollmentYear")
	private String enrollmentYear;

	@Column(name="EnrollmentStatus")
	@JsonProperty("EnrollmentStatus")
	private String enrollmentStatus;


}