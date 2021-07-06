package com.baitaplon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class InventoryEntity extends BaseEntity{

	@Column(name = "product_id")
	private Long productId;
	

	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "qty")
	private Long qty;
	
	

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}
	


}
