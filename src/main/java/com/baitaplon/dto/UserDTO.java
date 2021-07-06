package com.baitaplon.dto;

public class UserDTO {
		private String fullName;
		private String userName;
		private String password;
		private String phoneNumber;
		private String roleCode;
		private Long id;
		private Long roleId;
		private String address;
		
		
	
		
		
		
		public String getAddress() {
			return this.address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Long getRoleId() {
			return roleId;
		}
		public void setRoleId(Long roleId) {
			this.roleId = roleId;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRoleCode() {
			return roleCode;
		}
		public void setRoleCode(String roleCode) {
			this.roleCode = roleCode;
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
		public UserDTO(String fullName, String userName, String password, String phoneNumber, String roleCode, Long id) {
			super();
			this.fullName = fullName;
			this.userName = userName;
			this.password = password;
			this.phoneNumber = phoneNumber;
			this.roleCode=roleCode;
			this.id = id;
		}
		public UserDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
}
