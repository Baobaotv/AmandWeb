package com.baitaplon.dto;

import java.util.Date;

public class CategoryDTO {
	private Long id;
	private String name;
	
	private String code;
	private String createdDate;
	private String createdBy;
	private String modifiedBy;
	private String modifiedDate;
	

	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public String getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


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




	public CategoryDTO(Long id, String name, String code, String createdDate, String createdBy, String modifiedBy,
			String modifiedDate) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}


	public CategoryDTO() {
		super();
	}
	
	
	
}
