package com.visa.erp.DAO;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="PricingProduct_PricingPlans")
public class PricingProductMapping implements Serializable{

	private static final long serialVersionUID = -7083854285083395943L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	

	@Column(name="TransactionType")
	@JsonProperty("TransactionType")
	private String transactionType;
	
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
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="categoryId" , referencedColumnName="id", insertable=false, updatable=false)
	private ProductCategory productCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pricingPlansId" , referencedColumnName="id", insertable=false , updatable=false)
	private PricingPlanDAO pricingPlans;
	
	/*@OneToOne(mappedBy="pricingProductMapping",fetch=FetchType.LAZY)
	private PricingProduct pricingProduct;*/

	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="PricingProductId", referencedColumnName="id", insertable=false, updatable=false)
	private PricingProduct pricingProduct;
	
	
	public PricingProduct getPricingProduct() {
		return pricingProduct;
	}

	public void setPricingProduct(PricingProduct pricingProduct) {
		this.pricingProduct = pricingProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTranstionType() {
		return transactionType;
	}

	public void setTranstionType(String transtionType) {
		this.transactionType = transtionType;
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
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
 
	public PricingPlanDAO getPricingPlans() {
		return pricingPlans;
	}

	public void setPricingPlans(PricingPlanDAO pricingPlans) {
		this.pricingPlans = pricingPlans;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PricingProductMapping [id=");
		builder.append(id);
		builder.append(", transactionType=");
		builder.append(transactionType);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", productCategory=");
		builder.append(productCategory);
		builder.append(", pricingPlans=");
		builder.append(pricingPlans);
		builder.append(", pricingProduct=");
		builder.append(pricingProduct);
		builder.append("]");
		return builder.toString();
	}

	
	
	

	
}
