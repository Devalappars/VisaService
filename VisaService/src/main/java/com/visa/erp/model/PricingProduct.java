package com.visa.erp.model;

import java.io.Serializable;

public class PricingProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6959198937951036415L;
	private int productId;
	private String ttNumber;
	private String productTag;
	private String ftNumber;
	private String corpAccount;
	private String transactionDesc;
	private String transactionType;
	private PricingPlan pricingPlan;
	
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getTtNumber() {
		return ttNumber;
	}
	public void setTtNumber(String ttNumber) {
		this.ttNumber = ttNumber;
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
	
	public PricingPlan getPricingPlan() {
		return pricingPlan;
	}
	public void setPricingPlan(PricingPlan pricingPlan) {
		this.pricingPlan = pricingPlan;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transtionType) {
		this.transactionType = transtionType;
	}
	
	public PricingProduct() {
		// TODO Auto-generated constructor stub
	}
	public PricingProduct(int productId, String ttNumber, String productTag, String ftNumber, String corpAccount,
			String transactionDesc, String transactionType, PricingPlan pricingPlan) {
		super();
		this.productId = productId;
		this.ttNumber = ttNumber;
		this.productTag = productTag;
		this.ftNumber = ftNumber;
		this.corpAccount = corpAccount;
		this.transactionDesc = transactionDesc;
		this.transactionType = transactionType;
		this.pricingPlan = pricingPlan;
	}
	
	
		
}
