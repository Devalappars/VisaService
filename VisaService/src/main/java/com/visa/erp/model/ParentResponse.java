package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

public class ParentResponse {

	@SerializedName("data")
	private ParentResponseDetail data;

	@SerializedName("result")
	private Result result = null;

	public ParentResponseDetail getData() {
		return data;
	}

	public void setData(ParentResponseDetail data) {
		this.data = data;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ParentResponse{");
		sb.append("data=").append(data);
		sb.append(", result=").append(result);
		sb.append('}');
		return sb.toString();
	}
}