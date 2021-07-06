package com.baitaplon.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity extends BaseEntity {
	
	@Column(name="code")
	private String code;
	
	@OneToMany(mappedBy = "role")
	private List<UserEntity> users=new ArrayList<UserEntity>();
	


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}


	
	 
	 
	

}
