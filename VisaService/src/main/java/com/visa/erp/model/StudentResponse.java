package com.visa.erp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.time.LocalDateTime;

public class StudentResponse {

	@SerializedName("data")
	private StudentResponseDetail data;

	@SerializedName("result")
	private Result result = null;

	public StudentResponseDetail getData() {
		return data;
	}

	public void setData(StudentResponseDetail data) {
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
		final StringBuilder sb = new StringBuilder("StudentResponse{");
		sb.append("data=").append(data);
		sb.append(", result=").append(result);
		sb.append('}');
		return sb.toString();
	}
}