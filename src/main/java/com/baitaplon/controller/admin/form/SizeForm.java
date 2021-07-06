package com.baitaplon.controller.admin.form;

import org.springframework.web.multipart.MultipartFile;

public class SizeForm {
	
	private Long id;
	private String nameSize;
	private String codeSize;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public SizeForm(Long id, String nameSize, String codeSize) {
		super();
		this.id = id;
		this.nameSize = nameSize;
		this.codeSize = codeSize;
	}
	public String getNameSize() {
		return nameSize;
	}
	public void setNameSize(String nameSize) {
		this.nameSize = nameSize;
	}
	public String getCodeSize() {
		return codeSize;
	}
	public void setCodeSize(String codeSize) {
		this.codeSize = codeSize;
	}
	public SizeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
