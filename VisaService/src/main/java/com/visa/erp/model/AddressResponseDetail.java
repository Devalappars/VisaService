package com.visa.erp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.time.LocalDateTime;

public class AddressResponseDetail {

	@SerializedName("studentId")
	private Long studentId;

	@SerializedName("addressType")
	private String addressType;

	@SerializedName("streetNumberOrCompleNumber")
	private String streetNumberOrCompleNumber;

	@SerializedName("address1")
	private String address1;

	@SerializedName("address2")
	private String address2;

	@SerializedName("district")
	private String district;

	@SerializedName("stateOrProvince")
	private String stateOrProvince;

	@SerializedName("country")
	private String country;

	@SerializedName("createdBy")
	private String createdBy;

	@SerializedName("updatedBy")
	private String updatedBy;

	@SerializedName("createdDate")
	private LocalDateTime createdDate;

	@SerializedName("updatedDate")
	private LocalDateTime updatedDate;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getStreetNumberOrCompleNumber() {
		return streetNumberOrCompleNumber;
	}

	public void setStreetNumberOrCompleNumber(String streetNumberOrCompleNumber) {
		this.streetNumberOrCompleNumber = streetNumberOrCompleNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AddressResponseDetail{");
		sb.append("studentId=").append(studentId);
		sb.append(", addressType='").append(addressType).append('\'');
		sb.append(", streetNumberOrCompleNumber='").append(streetNumberOrCompleNumber).append('\'');
		sb.append(", address1='").append(address1).append('\'');
		sb.append(", address2='").append(address2).append('\'');
		sb.append(", district='").append(district).append('\'');
		sb.append(", stateOrProvince='").append(stateOrProvince).append('\'');
		sb.append(", country='").append(country).append('\'');
		sb.append(", createdBy='").append(createdBy).append('\'');
		sb.append(", updatedBy='").append(updatedBy).append('\'');
		sb.append(", createdDate=").append(createdDate);
		sb.append(", updatedDate=").append(updatedDate);
		sb.append('}');
		return sb.toString();
	}
}