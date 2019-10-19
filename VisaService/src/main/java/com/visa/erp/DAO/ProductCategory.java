package com.visa.erp.DAO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="ProductCategory")
public class ProductCategory implements Serializable{
	
	private static final long serialVersionUID = -6970885518926865599L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Category")
	@JsonProperty("category")
	private String category;
			
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

	@OneToMany(mappedBy="productCategory", fetch = FetchType.LAZY)
	private Set<PricingProductMapping> pricingProductMappings;
	
	
    
	public Set<PricingProductMapping> getPricingProductMappings() {
		return pricingProductMappings;
	}

	public void setPricingProductMappings(Set<PricingProductMapping> pricingProductMappings) {
		this.pricingProductMappings = pricingProductMappings;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductCategory [id=");
		builder.append(id);
		builder.append(", category=");
		builder.append(category);
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
