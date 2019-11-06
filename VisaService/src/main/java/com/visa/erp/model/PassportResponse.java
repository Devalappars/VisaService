package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

public class PassportResponse {

	@SerializedName("data")
	private PassportDetailsResponse data;

	@SerializedName("result")
	private Result result = null;

	public PassportDetailsResponse getData() {
		return data;
	}

	public void setData(PassportDetailsResponse data) {
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
		final StringBuilder sb = new StringBuilder("PassportDetailsResponse{");
		sb.append("data=").append(data);
		sb.append(", result=").append(result);
		sb.append('}');
		return sb.toString();
	}
}