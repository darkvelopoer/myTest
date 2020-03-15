package com.myapps.examples.dto;

public class ProductDataObj {
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private Integer amount;
	private String currencyType;
	private String productId;
	private Integer quantity;
	private String storeId;
	private String type;
	
	@Override
	public String toString() {
		return storeId + ", " + productId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		if((obj instanceof ProductDataObj) && (((ProductDataObj)obj).getProductId() == this.productId) 
				&& (((ProductDataObj)obj).getStoreId() == this.storeId) ) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode()) + ((storeId == null) ? 0 : storeId.hashCode());
		return result;
	}
}
