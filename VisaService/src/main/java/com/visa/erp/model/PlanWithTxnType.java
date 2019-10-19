package com.visa.erp.model;

public class PlanWithTxnType {
	private Object object;
	private String txnType;
	
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	
	public PlanWithTxnType(){}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlanWithTxnType [object=");
		builder.append(object);
		builder.append(", txnType=");
		builder.append(txnType);
		builder.append("]");
		return builder.toString();
	};
	
	
	
	
	
    	

}
