package com.visa.erp.DAO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="PricingPlans")
public class PricingPlanDAO implements Serializable{

	private static final long serialVersionUID = -4613186672863162521L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="IndividualFixedFee")
	@JsonProperty("individualFixedFee")
	private float indFixedFee;
	
	@Column(name="IndividualVariableFee")
	@JsonProperty("individualVariableFee")
	private float indVariableFee;
	
	@Column(name="staffFixedFee")
	@JsonProperty("staffFixedFee")
	private float staffFixedFee;
	
	@Column(name="staffVariableFee")
	@JsonProperty("staffVariableFee")
	private float staffVariableFee;
	
	@Column(name="createdAt")
	@JsonProperty("createdAt")
	private String createdAt;
	
	@Column(name="createdBy")
	@JsonProperty("createdBy")
	private String createdBy;
	
	@Column(name="updatedAt")
	@JsonProperty("updatedAt")
	private String updatedAt;
		
	@Column(name="updatedBy")
	@JsonProperty("updatedBy")
	private String updatedBy;

	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "pricingPlans")
	private Set<PricingProductMapping> pricingProductMappings;
	
	
	public PricingPlanDAO(){}
	public PricingPlanDAO(float indFixedFee, float indVariableFee, float staffFixedFee, float staffVariableFee) {
		super();
		this.indFixedFee = indFixedFee;
		this.indVariableFee = indVariableFee;
		this.staffFixedFee = staffFixedFee;
		this.staffVariableFee = staffVariableFee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getIndFixedFee() {
		return indFixedFee;
	}

	public void setIndFixedFee(float indFixedFee) {
		this.indFixedFee = indFixedFee;
	}

	public float getIndVariableFee() {
		return indVariableFee;
	}

	public void setIndVariableFee(float indVariableFee) {
		this.indVariableFee = indVariableFee;
	}

	public float getStaffFixedFee() {
		return staffFixedFee;
	}

	public void setStaffFixedFee(float staffFixedFee) {
		this.staffFixedFee = staffFixedFee;
	}

	public float getStaffVariableFee() {
		return staffVariableFee;
	}

	public void setStaffVariableFee(float staffVariableFee) {
		this.staffVariableFee = staffVariableFee;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Set<PricingProductMapping> getPricingProductMappings() {
		return pricingProductMappings;
	}

	public void setPricingProductMappings(Set<PricingProductMapping> pricingProductMappings) {
		this.pricingProductMappings = pricingProductMappings;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PricingPlans [id=");
		builder.append(id);
		builder.append(", indFixedFee=");
		builder.append(indFixedFee);
		builder.append(", indVariableFee=");
		builder.append(indVariableFee);
		builder.append(", staffFixedFee=");
		builder.append(staffFixedFee);
		builder.append(", staffVariableFee=");
		builder.append(staffVariableFee);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
