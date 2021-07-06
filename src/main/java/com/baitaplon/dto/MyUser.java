package com.baitaplon.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User {

	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}
	private Long id;
	
	private String roleCode;
	
	
	
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String code) {
		this.roleCode = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id,
			String code, String fullName) {
		super(username, password, authorities);
		this.id = id;
		this.roleCode = code;
		this.fullName = fullName;
	}

	
	

	
	
	

}
