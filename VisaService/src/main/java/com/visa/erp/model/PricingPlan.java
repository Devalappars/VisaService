package com.visa.erp.model;

import java.io.Serializable;

public class PricingPlan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1520425755471157148L;
	private int planId;
	private float individualFixedFee; 
	private float individualVariableFee;
	private float staffFixedFee;
	private float staffVariableFee;
	
	
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
    public float getIndividualFixedFee() {
		return individualFixedFee;
	}
	public void setIndividualFixedFee(float individualFixedFee) {
		this.individualFixedFee = individualFixedFee;
	}
	public float getIndividualVariableFee() {
		return individualVariableFee;
	}
	public void setIndividualVariableFee(float individualVariableFee) {
		this.individualVariableFee = individualVariableFee;
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
	
	public PricingPlan(){}
	public PricingPlan(int planId, float individualFixedFee, float individualVariableFee, float staffFixedFee,
			float staffVariableFee) {
		super();
		this.planId = planId;
		this.individualFixedFee = individualFixedFee;
		this.individualVariableFee = individualVariableFee;
		this.staffFixedFee = staffFixedFee;
		this.staffVariableFee = staffVariableFee;
	}
	
}
