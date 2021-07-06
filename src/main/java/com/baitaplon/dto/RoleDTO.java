package com.baitaplon.dto;

public class RoleDTO {
	private Long id;
	private String code;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public RoleDTO(Long id, String code) {
		super();
		this.id = id;
		this.code = code;
	}
	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
