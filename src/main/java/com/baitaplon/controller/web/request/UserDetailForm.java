package com.baitaplon.controller.web.request;

public class UserDetailForm {
	private String fullName;
	private String userName;
	private String password;
	private String phoneNumber;
	private String confirmPassword;
	private String address;
	private String roleId;
	private Long userId;
	
	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public UserDetailForm(String fullName, String userName, String password, String phoneNumber, String confirmPassword,
			String address, String roleId) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.roleId= roleId;
	}
	public UserDetailForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
