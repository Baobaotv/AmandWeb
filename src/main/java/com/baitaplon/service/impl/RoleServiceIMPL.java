package com.baitaplon.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.baitaplon.controller.admin.form.RoleForm;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.RoleDTO;
import com.baitaplon.entity.RoleEntity;
import com.baitaplon.repository.RoleRepository;
import com.baitaplon.service.RoleService;
@Service
public class RoleServiceIMPL implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<RoleDTO> getAll() {
		List<RoleEntity> lstEntity= roleRepository.findAll();
		List<RoleDTO> lstDTO= new ArrayList<RoleDTO>();
		RoleDTO roleDTO= null;
		for(RoleEntity role: lstEntity) {
			roleDTO= new RoleDTO();
			roleDTO.setId(role.getId());
			roleDTO.setCode(role.getCode());
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			  if(role.getCreatedDate()!=null) {
				  roleDTO.setCreatedDate(dateFormat.format(role.getCreatedDate()));
				  roleDTO.setCreatedBy(role.getCreatedBy());
			  }
			  if(role.getModifiedDate()!=null) {
				  roleDTO.setModifiedDate(dateFormat.format(role.getModifiedDate()));
				  roleDTO.setModifiedBy(role.getModifiedBy());
			  }
			lstDTO.add(roleDTO);
		}
		return lstDTO;
	}

	@Override
	public Boolean save(RoleForm form) {
		RoleEntity  roleEntity= new RoleEntity();
		MyUser user= (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		roleEntity.setCode(form.getCode());
		if(form.getId()==null) {			
			roleEntity.setCreatedDate(new Date());
			roleEntity.setCreatedBy(user.getFullName());
		}else {
			roleEntity.setId(form.getId());
			roleEntity.setModifiedBy(user.getFullName());
			roleEntity.setModifiedDate(new Date());
		}
		try {
			roleRepository.save(roleEntity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	
	}

	@Override
	public Boolean delete(List<String> lst) {
		for(String i:lst) {
			try {
				roleRepository.delete(Long.parseLong(i));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return true;
	}

}
