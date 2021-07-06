package com.baitaplon.service;

import java.util.List;

import com.baitaplon.controller.admin.form.SizeForm;
import com.baitaplon.controller.admin.form.categoryForm;
import com.baitaplon.dto.SizeDTO;
import com.baitaplon.entity.SizeEntity;

public interface SizeService {
	
	List<SizeEntity> getAllSize();
	List<SizeDTO> findAll();
	String save(SizeForm form);
	Boolean checkDelete(List<String> ids);
	Boolean delete(List<String> ids);
	
	/* List<String> findByProductCode(String code); */
	List<SizeDTO> findAllByProductId(Long id);

}
