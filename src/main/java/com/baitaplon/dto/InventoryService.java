package com.baitaplon.dto;

public class InventoryService {
	private Long id;
	private Long productID;
	private String productCode;
	private Long qty;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public InventoryService(Long id, Long productID, String productCode, Long qty) {
		super();
		this.id = id;
		this.productID = productID;
		this.productCode = productCode;
		this.qty = qty;
	}
	public InventoryService() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
