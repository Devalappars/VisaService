package com.visa.erp.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5224947503746806962L;
	private int categoryId;
	private String category;
	private List<PricingProduct> pricingProducts;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<PricingProduct> getPricingProducts() {
		return pricingProducts;
	}

	public void setPricingProducts(List<PricingProduct> pricingProducts) {
		this.pricingProducts = pricingProducts;
	}

	public Category(int categoryId, String category, List<PricingProduct> pricingProducts) {
		super();
		this.categoryId = categoryId;
		this.category = category;
		this.pricingProducts = pricingProducts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductCategory [categoryId=");
		builder.append(categoryId);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}
	
	

}
