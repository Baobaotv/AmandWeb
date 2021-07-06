package com.baitaplon.controller.admin.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class productForm {
	private Long id;
	private String nameProduct;
	private String codeProduct;
	private Integer categoryId;
	private MultipartFile files;
	private Integer sizeId;
	private Long amount;
	private String price;
	private String memo;
	private List<String> ids;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeName) {
		this.sizeId = sizeName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public productForm(Long id, String nameProduct, String codeProduct, Integer categoryId, MultipartFile files,
			Integer sizeId, Long amount, String price, String memo, List<String> ids) {
		super();
		this.id = id;
		this.nameProduct = nameProduct;
		this.codeProduct = codeProduct;
		this.categoryId = categoryId;
		this.files = files;
		this.sizeId = sizeId;
		this.amount = amount;
		this.price = price;
		this.memo = memo;
		this.ids = ids;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}

	public productForm() {

		// TODO Auto-generated constructor stub
	}

}
