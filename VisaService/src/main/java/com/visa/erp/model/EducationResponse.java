package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

public class EducationResponse {

	@SerializedName("data")
	private EducationResponseDetail data;

	@SerializedName("result")
	private Result result = null;

	public EducationResponseDetail getData() {
		return data;
	}

	public void setData(EducationResponseDetail data) {
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
		final StringBuilder sb = new StringBuilder("EducationResponse{");
		sb.append("data=").append(data);
		sb.append(", result=").append(result);
		sb.append('}');
		return sb.toString();
	}
}