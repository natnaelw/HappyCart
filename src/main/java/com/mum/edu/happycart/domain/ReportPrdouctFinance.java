package com.mum.edu.happycart.domain;

import java.util.Date;

public class ReportPrdouctFinance {

	
	private String description;
	private String manufacturer;
	private double unitPrice;
	private String conditions;
	private int unitInStock;
	private Date postDate;
	private String post;
	private long userId;
	private String creditCardNumber;
	private String product;
	private double amountSpent;
	private long receiptNumber;
	private Date purchaseDate;
	private double vendorAmount;
	private double happyCartAmount;
	private double tax;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public int getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}
	public long getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(long receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getVendorAmount() {
		return vendorAmount;
	}
	public void setVendorAmount(double vendorAmount) {
		this.vendorAmount = vendorAmount;
	}
	public double getHappyCartAmount() {
		return happyCartAmount;
	}
	public void setHappyCartAmount(double happyCartAmount) {
		this.happyCartAmount = happyCartAmount;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
}
