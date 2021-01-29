package com.nagp.inventory.models;


import java.time.Instant;

public class Order {

	private String userID;
	private String orderID;
	private String address;
	private String totalQty;
	private String amount;
	private String remarks;
	private Product product;
	private OrderStatus orderStatus;
	private Instant creationTimeStamp;
	private Instant lastupdateTimeStamp;
	
	public Order(){
		
	}
	
	public Order(String userID,String orderID,String address, String totalQty,OrderStatus orderStatus,Product product){
		super();
		this.userID = userID;
		this.orderID = orderID;
		this.address = address;
		this.totalQty = totalQty;
		this.orderStatus = orderStatus;
		this.product = product;
		
	}
	
	public Instant getCreationTimeStamp(){
		return this.creationTimeStamp;
	}
	
	public void setCreationTimeStamp(Instant creationTimeStamp){
		this.creationTimeStamp = creationTimeStamp;
	}

	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getTotalQty() {
		return this.totalQty;
	}
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderID() {
		return this.orderID;
	}
	public void setorderID(String orderID) {
		this.orderID = orderID;
	}

	

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the lastupdateTimeStamp
	 */
	public Instant getLastupdateTimeStamp() {
		return lastupdateTimeStamp;
	}

	/**
	 * @param lastupdateTimeStamp the lastupdateTimeStamp to set
	 */
	public void setLastupdateTimeStamp(Instant lastupdateTimeStamp) {
		this.lastupdateTimeStamp = lastupdateTimeStamp;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
