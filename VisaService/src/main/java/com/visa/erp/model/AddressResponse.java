package com.visa.erp.model;

import com.google.gson.annotations.SerializedName;

public class AddressResponse {

	@SerializedName("data")
	private AddressResponseDetail data;

	@SerializedName("result")
	private Result result = null;

	public AddressResponseDetail getData() {
		return data;
	}

	public void setData(AddressResponseDetail data) {
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
		final StringBuilder sb = new StringBuilder("AddressResponse{");
		sb.append("data=").append(data);
		sb.append(", result=").append(result);
		sb.append('}');
		return sb.toString();
	}
}