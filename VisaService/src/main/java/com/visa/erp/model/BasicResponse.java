package com.visa.erp.model;

public class BasicResponse {
	
    private Object data;
    private Object result;
	
    public BasicResponse() {}

	public BasicResponse(Object data, Object result) {
		super();
		this.data = data;
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BasicResponse [data=");
		builder.append(data);
		builder.append(", result=");
		builder.append(result);
		builder.append("]");
		return builder.toString();
	}
    
	

	
    
    

}
