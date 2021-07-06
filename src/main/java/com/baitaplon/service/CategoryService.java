package com.baitaplon.service;

import java.util.List;

import com.baitaplon.controller.admin.form.categoryForm;
import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.entity.CategoryEntity;

public interface CategoryService {
	List<CategoryDTO> getAll();
	String save(categoryForm form);
	List<CategoryDTO> getAllToEng();
	List<CategoryDTO> findAllByCode(String code);
	Boolean checkDelete(List<String> ids);
	Boolean delete(List<String> ids);
}
