package com.baitaplon.controller.admin.form;

import org.springframework.web.multipart.MultipartFile;

public class categoryForm {
	
	private Long id;
	private String nameCategory;
	private String codeCategory;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public categoryForm(Long id, String nameCategory, String codeCategory) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
		this.codeCategory = codeCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public String getCodeCategory() {
		return codeCategory;
	}
	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}
	public categoryForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
