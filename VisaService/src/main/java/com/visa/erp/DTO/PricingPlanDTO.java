package com.visa.erp.DTO;

import java.io.Serializable;

public class PricingPlanDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5589981654362545649L;
	
	private String individualFixedFee;
	private String individualVariableFee;
	private String staffFixedFee;
	private String staffVariableFee;
	
	public String getIndividualFixedFee() {
		return individualFixedFee;
	}
	public void setIndividualFixedFee(String individualFixedFee) {
		this.individualFixedFee = individualFixedFee;
	}
	public String getIndividualVariableFee() {
		return individualVariableFee;
	}
	public void setIndividualVariableFee(String individualVariableFee) {
		this.individualVariableFee = individualVariableFee;
	}
	public String getStaffFixedFee() {
		return staffFixedFee;
	}
	public void setStaffFixedFee(String staffFixedFee) {
		this.staffFixedFee = staffFixedFee;
	}
	public String getStaffVariableFee() {
		return staffVariableFee;
	}
	public void setStaffVariableFee(String staffVariableFee) {
		this.staffVariableFee = staffVariableFee;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", individualFixedFee=");
		builder.append(individualFixedFee);
		builder.append(", individualVariableFee=");
		builder.append(individualVariableFee);
		builder.append(", staffFixedFee=");
		builder.append(staffFixedFee);
		builder.append(", staffVariableFee=");
		builder.append(staffVariableFee);
		builder.append("]");
		return builder.toString();
	}
	
	

}
