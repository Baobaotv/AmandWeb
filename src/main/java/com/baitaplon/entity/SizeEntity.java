package com.baitaplon.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="size")
public class SizeEntity extends BaseEntity {
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "sizeId", fetch = FetchType.LAZY)
	private List<ProductEntity> productEntitys;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductEntity> getProductEntitys() {
		return productEntitys;
	}

	public void setProductEntitys(List<ProductEntity> productEntitys) {
		this.productEntitys = productEntitys;
	}

	

}
