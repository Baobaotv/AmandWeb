package com.baitaplon.service;

import java.util.List;

import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.entity.ProductEntity;

public interface ProductService {
	String save(productForm form);
	
	List<ProductDTO> getAllProduct();
	
	List<ProductDTO> getAllByCategory(String code);
	
	ProductDTO findOneById(Long id);
	
	String delete(List<String> ids);
	
	ProductDTO findOneRandomProduct();
	
	List<ProductDTO> findAllByCategoryId(List<Long> ids);
	
	
	
	

}
