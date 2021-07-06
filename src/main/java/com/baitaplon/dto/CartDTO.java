package com.baitaplon.dto;

import java.util.List;

public class CartDTO {
	
	private Long userID;
	private Long productId;
	private Long number ;
	private String productCode;
	private Long price;
	private Long sizeId;
	private String file;
	private Long totalPrice;
	private String name;
	private String sizeName;
	private Long qty;

	
	
	
	

	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getSizeId() {
		return sizeId;
	}
	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public CartDTO(Long userID, Long productId, Long number, String productCode, Long price, Long sizeId, String file,
			Long totalPrice, Long qty) {
		super();
		this.userID = userID;
		this.productId = productId;
		this.number = number;
		this.productCode = productCode;
		this.price = price;
		this.sizeId = sizeId;
		this.file = file;
		this.totalPrice = totalPrice;
		this.qty=qty;
	}
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
