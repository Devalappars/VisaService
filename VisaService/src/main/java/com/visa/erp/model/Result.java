package com.visa.erp.model;

public class Result {
	
	private String responseCode;
	private String responseDescription;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDescription() {
		return responseDescription;
	}
	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
	
	public Result(String responseCode, String responseDescription) {
		super();
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
	}
	public Result() {
		// TODO Auto-generated constructor stub
	}
	
	

}
