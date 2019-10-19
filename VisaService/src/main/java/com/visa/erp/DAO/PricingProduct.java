package com.visa.erp.DAO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="PricingProduct")
public class PricingProduct implements Serializable {

	private static final long serialVersionUID = 8797173118675956237L;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@Column(name="ProductTT")
	@JsonProperty("ProductTT")
	private String productTT;
	
	@Column(name="ProductTag")
	@JsonProperty("ProductTag")
	private String productTag;
	
	@Column(name="TransactionDesc")
	@JsonProperty("TransactionDesc")
	private String transactionDesc;
	
	@Column(name="FTNumber")
	@JsonProperty("FTNumber")
	private String ftNumber;
	
	@Column(name="CorpAccount")
	@JsonProperty("CorpAccount")
	private String corpAccount;
	
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
            mappedBy = "pricingProduct")
	private Set<PricingProductMapping> pricingProductMapping;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductTT() {
		return productTT;
	}

	public void setProductTT(String productTT) {
		this.productTT = productTT;
	}

	public String getProductTag() {
		return productTag;
	}

	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
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
	
	public String getFtNumber() {
		return ftNumber;
	}

	public void setFtNumber(String ftNumber) {
		this.ftNumber = ftNumber;
	}

	public String getCorpAccount() {
		return corpAccount;
	}

	public void setCorpAccount(String corpAccount) {
		this.corpAccount = corpAccount;
	}
	
	public Set<PricingProductMapping> getPricingProductMapping() {
		return pricingProductMapping;
	}

	public void setPricingProductMapping(Set<PricingProductMapping> pricingProductMapping) {
		this.pricingProductMapping = pricingProductMapping;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PricingProduct [id=");
		builder.append(id);
		builder.append(", productTT=");
		builder.append(productTT);
		builder.append(", productTag=");
		builder.append(productTag);
		builder.append(", transactionDesc=");
		builder.append(transactionDesc);
		builder.append(", ftNumber=");
		builder.append(ftNumber);
		builder.append(", corpAccount=");
		builder.append(corpAccount);
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
