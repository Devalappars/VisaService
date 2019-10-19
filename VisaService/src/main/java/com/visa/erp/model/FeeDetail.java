package com.visa.erp.model;

public class FeeDetail {

	private float amount;
	private double  fee;
	
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
    public FeeDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public FeeDetail(float amount, double fee) {
		super();
		this.amount = amount;
		this.fee = fee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeeDetail [amount=");
		builder.append(amount);
		builder.append(", fee=");
		builder.append(fee);
		builder.append("]");
		return builder.toString();
	}
	
	
}
