package com.mum.edu.happycart.domain;

public class SearchDto {
	
	private String category;
	private String item;
	private String searchBy;
	private String itemCondition;
	private String user;
	private String price;
	
	
	
	public SearchDto() {
		super();
	}
	public SearchDto(String category, String item, String searchBy,
			String itemCondition, String user, String price) {
		super();
		this.category = category;
		this.item = item;
		this.searchBy = searchBy;
		this.itemCondition = itemCondition;
		this.user = user;
		this.price = price;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getItemCondition() {
		return itemCondition;
	}
	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}
	
	

}
