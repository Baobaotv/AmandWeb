package com.baitaplon.service.impl;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.baitaplon.controller.admin.form.categoryForm;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.entity.CategoryEntity;
import com.baitaplon.entity.ProductEntity;
import com.baitaplon.repository.CategoryRepository;
import com.baitaplon.repository.ProductRepository;

@Service
public class CategoryService implements com.baitaplon.service.CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<CategoryDTO> getAll() {
		List<CategoryEntity> ca = categoryRepository.findAll();
		List<CategoryDTO> lDto = convertToDto(ca);
		return lDto;
	}
	
	List<CategoryDTO> convertToDto(List<CategoryEntity> lst) {
		
		List<CategoryDTO> lstDto = new ArrayList<CategoryDTO>();
		CategoryDTO dto = null;
		for(CategoryEntity e:lst) {
			dto = new CategoryDTO();
			dto.setId(e.getId());
			dto.setName(e.getName());
			
		
			dto.setCode(e.getCode());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			  if(e.getCreatedDate()!=null) {
				  dto.setCreatedDate(dateFormat.format(e.getCreatedDate()));
				  dto.setCreatedBy(e.getCreatedBy());
			  }
			  if(e.getModifiedDate()!=null) {
				  dto.setModifiedDate(dateFormat.format(e.getModifiedDate()));
				  dto.setModifiedBy(e.getModifiedBy());
			  }
			
			/* dto.setCreatedDate(e.getCreatedDate()); */
			lstDto.add(dto);
		}
		
		return lstDto;
		
	}

	@Override
	public String save(categoryForm form) {
		CategoryEntity categoryEntity= new CategoryEntity();
		if(Objects.nonNull(form.getId())) {
			categoryEntity.setId(form.getId());
			categoryEntity.setCode(form.getCodeCategory());
			categoryEntity.setName(form.getNameCategory());
			categoryEntity.setCreatedDate(new Date());
			
		}
		else {
			categoryEntity.setCode(form.getCodeCategory());
			categoryEntity.setName(form.getNameCategory());
			categoryEntity.setModifiedDate(new Date());			
		}
		
		categoryRepository.save(categoryEntity);	
		return "done";
	}

	@Override
	public List<CategoryDTO> findAllByCode(String code) {
		List<CategoryEntity> lstCategory = categoryRepository.findAllByCode(code);
		List<CategoryDTO> lDto = convertToDto(lstCategory);
		return lDto ;
	}

	@Override
	public List<CategoryDTO> getAllToEng() {
		List<CategoryEntity> ca = categoryRepository.findAll();
		List<CategoryDTO> lstDto = new ArrayList<CategoryDTO>();
		CategoryDTO dto = null;
		for(CategoryEntity e:ca) {
			dto = new CategoryDTO();
			dto.setId(e.getId());
			dto.setName(deAccent(e.getName()).toLowerCase());
			
		
			dto.setCode(e.getCode());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			  if(e.getCreatedDate()!=null) {
				  dto.setCreatedDate(dateFormat.format(e.getCreatedDate()));
				  dto.setCreatedBy(e.getCreatedBy());
			  }
			  if(e.getModifiedDate()!=null) {
				  dto.setModifiedDate(dateFormat.format(e.getModifiedDate()));
				  dto.setModifiedBy(e.getModifiedBy());
			  }
			
			/* dto.setCreatedDate(e.getCreatedDate()); */
			lstDto.add(dto);
		}
		return lstDto;
	}
	
	public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

	@Override
	public Boolean checkDelete(List<String> ids) {
		List<Long> idsLong = new ArrayList<Long>();
		Long id;
		for(String idStr:ids) {
			id=Long.parseLong(idStr);
			idsLong.add(id);
		}
		List<ProductEntity> lstPro= productRepository.findAllBySizeId(idsLong);
		if(CollectionUtils.isEmpty(lstPro)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean delete(List<String> ids) {
		for(String id:ids) {
			try {
				categoryRepository.delete(Long.parseLong(id));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return true ;
	}
	


}
