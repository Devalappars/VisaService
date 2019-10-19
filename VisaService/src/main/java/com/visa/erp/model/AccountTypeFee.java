package com.visa.erp.model;

public class AccountTypeFee {
	
	String variableFee;
	float fixedFee;
	public String getVariableFee() {
		return variableFee;
	}
	public void setVariableFee(String variableFee) {
		this.variableFee = variableFee;
	}
	public float getFixedFee() {
		return fixedFee;
	}
	public void setFixedFee(float fixedFee) {
		this.fixedFee = fixedFee;
	}
	
	public AccountTypeFee(String variableFee, float fixedFee) {
		super();
		this.variableFee = variableFee;
		this.fixedFee = fixedFee;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountTypeFee [variableFee=");
		builder.append(variableFee);
		builder.append(", fixedFee=");
		builder.append(fixedFee);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
