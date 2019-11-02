package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

public class IdDetailsResponse {

	@SerializedName("data")
	private IdDetailsResponseDetail data;

	@SerializedName("result")
	private Result result = null;

	public IdDetailsResponseDetail getData() {
		return data;
	}

	public void setData(IdDetailsResponseDetail data) {
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
		final StringBuilder sb = new StringBuilder("IdDetailsResponse{");
		sb.append("data=").append(data);
		sb.append(", result=").append(result);
		sb.append('}');
		return sb.toString();
	}
}