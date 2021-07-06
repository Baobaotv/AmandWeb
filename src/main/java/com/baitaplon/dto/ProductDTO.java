package com.baitaplon.dto;

import java.util.Date;

public class ProductDTO {
	private Long id;
	private String name;
	private Integer price;
	private String categoryId;
	private String image;
	private String sizeId;
	private String memo;
	private String code;
	private Long qty;
	
	/* private Date createdDate; */
	
	
	





	public Long getQty() {
		return qty;
	}


	public void setQty(Long qty) {
		this.qty = qty;
	}


	private String createdDate;
	

	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getSizeId() {
		return sizeId;
	}


	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public ProductDTO(Long id, String name, Integer price, String categoryId, String image, String sizeId,
			String memo) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.image = image;
		this.sizeId = sizeId;
		this.memo = memo;
	}


	public ProductDTO() {
		super();
	}
	
	
	
}
