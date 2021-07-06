package com.baitaplon.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.baitaplon.controller.admin.form.SizeForm;
import com.baitaplon.dto.SizeDTO;
import com.baitaplon.entity.CategoryEntity;
import com.baitaplon.entity.ProductEntity;
import com.baitaplon.entity.SizeEntity;
import com.baitaplon.repository.ProductRepository;
import com.baitaplon.repository.SizeRepository;

@Service
public class SizeService implements com.baitaplon.service.SizeService {

	@Autowired
	private SizeRepository sizeRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<SizeEntity> getAllSize() {
		// TODO Auto-generated method stub
		return sizeRepository.findAll();
	}

	

	@Override
	public List<SizeDTO> findAllByProductId(Long id) {
		List<SizeEntity> lstSize = sizeRepository.findAllByProductId(id);
		List<SizeDTO> lstSizeDto = new ArrayList<SizeDTO>();
		SizeDTO dto = null;
		for (SizeEntity e : lstSize) {
			dto = new SizeDTO(e.getId(), e.getName(), e.getCode());

			lstSizeDto.add(dto);
		}

		return lstSizeDto;
		
	}



	@Override
	public List<SizeDTO> findAll() {
		List<SizeEntity> lstSize = sizeRepository.findAll();
		List<SizeDTO> lstSizeDto = new ArrayList<SizeDTO>();
		SizeDTO size= null;
		for(SizeEntity e:lstSize) {
			size= new SizeDTO();
		size.setId(e.getId());
		size.setCode(e.getCode());
		size.setName(e.getName());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		  if(e.getCreatedDate()!=null) {
			  size.setCreatedDate(dateFormat.format(e.getCreatedDate()));
			  size.setCreatedBy(e.getCreatedBy());
		  }
		  if(e.getModifiedDate()!=null) {
			  size.setModifiedDate(dateFormat.format(e.getModifiedDate()));
			  size.setModifiedBy(e.getModifiedBy());
		  }
		  lstSizeDto.add(size);
		}
		return lstSizeDto;
	}



	@Override
	public String save(SizeForm form) {
		SizeEntity sizeEntity= new SizeEntity();
		if(Objects.nonNull(form.getId())) {
			sizeEntity.setId(form.getId());
			sizeEntity.setCode(form.getCodeSize());
			sizeEntity.setName(form.getNameSize());
			sizeEntity.setCreatedDate(new Date());
			
		}
		else {
			sizeEntity.setCode(form.getCodeSize());
			sizeEntity.setName(form.getNameSize());
			sizeEntity.setModifiedDate(new Date());			
		}
		
		sizeRepository.save(sizeEntity);	
		return "done";
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
				sizeRepository.delete(Long.parseLong(id));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return true ;
	}




	/*
	 * @Override public List<String> findByProductCode(String code) { List<String>
	 * lstSize = sizeRepository.findSiteName(code);
	 * 
	 * return lstSize; }
	 */

}
