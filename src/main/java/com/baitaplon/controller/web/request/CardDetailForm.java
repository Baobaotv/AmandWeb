package com.baitaplon.controller.web.request;

import org.springframework.web.multipart.MultipartFile;

public class CardDetailForm {
	private String code;
	private Long number;
	private Long sizeId;
	private Long price;
	private String img;
	private String name;
	private String sizeName;
	
	
	

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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getSizeId() {
		return sizeId;
	}
	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	


	public CardDetailForm(String code, Long number, Long sizeId, Long price, String img, String name, String sizeName) {
		super();
		this.code = code;
		this.number = number;
		this.sizeId = sizeId;
		this.price = price;
		this.img = img;
		this.name = name;
		this.sizeName = sizeName;
	}
	public CardDetailForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
