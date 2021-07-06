package com.baitaplon.controller.web.request;

public class ProductDetailForm {
	private String code;
	private Long id;
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
	public ProductDetailForm(String code, Long id) {
		super();
		this.code = code;
		this.id = id;
	}
	public ProductDetailForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
