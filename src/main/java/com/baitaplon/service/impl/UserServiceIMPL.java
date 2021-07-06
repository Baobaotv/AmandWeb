package com.baitaplon.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.baitaplon.controller.admin.form.RequestDelete;
import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.controller.web.request.UserDetailForm;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.dto.UserDTO;
import com.baitaplon.entity.ProductEntity;
import com.baitaplon.entity.RoleEntity;
import com.baitaplon.entity.UserEntity;
import com.baitaplon.repository.RoleRepository;
import com.baitaplon.repository.UserRepository;
import com.baitaplon.service.UserService;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Boolean addUser(UserDetailForm form) {
			if(userRepository.findOneByUserName(form.getUserName())== null) {
				UserEntity userEntity= new UserEntity();
				userEntity.setUserName(form.getUserName());
				userEntity.setFullName(form.getFullName());
				userEntity.setPhoneNumber(Integer.parseInt(form.getPhoneNumber()));
//				String encoded = new BCryptPasswordEncoder().encode(form.getPassword());
				userEntity.setPassword(form.getPassword());
				userEntity.setAddress(form.getAddress());
				userEntity.setCreatedDate(new Date());
				RoleEntity role =roleRepository.findRoleId(Long.parseLong(form.getRoleId()));
				
				userEntity.setRole(role);
				userRepository.save(userEntity);
				
			}
			else {
				return false;
			}
		
		return true;
	}

	@Override
	public List<UserDTO> getAllAdminAndManager(Long roleId) {
		List<UserEntity> lstEntity= userRepository.getByNotRoleId(roleId);
		List<UserDTO> lstDTO= new ArrayList<UserDTO>();
		lstDTO=converttoDTO(lstEntity);
		return lstDTO;
	}
	
	List<UserDTO> converttoDTO(List<UserEntity> lstEntity){
		List<UserDTO> lstDto = new ArrayList<UserDTO>();
		UserDTO dto = null;
		for(UserEntity e:lstEntity) {
		dto= new UserDTO();
		dto.setId(e.getId());
		dto.setUserName(e.getUserName());
		dto.setFullName(e.getFullName());
		dto.setRoleId(e.getRole().getId());
		dto.setPassword(e.getPassword());
		dto.setPhoneNumber( Integer.toString(e.getPhoneNumber()));
		dto.setRoleCode(e.getRole().getCode());
		dto.setAddress(e.getAddress());
		lstDto.add(dto);
	}
		return lstDto;
	}

	@Override
	public Boolean UpdateUser(UserDetailForm form) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserEntity userEntity= new UserEntity();
			userEntity.setUserName(form.getUserName());
			userEntity.setFullName(form.getFullName());
			userEntity.setPhoneNumber(Integer.parseInt(form.getPhoneNumber()));
//			String encoded = new BCryptPasswordEncoder().encode(form.getPassword());
			userEntity.setPassword(form.getPassword());
			userEntity.setAddress(form.getAddress());
			userEntity.setModifiedDate(new Date());
			userEntity.setModifiedBy(user.getFullName());
			userEntity.setId(form.getUserId());
			RoleEntity role =roleRepository.findRoleId(Long.parseLong(form.getRoleId()));
			userEntity.setRole(role);
			try {
				userRepository.save(userEntity);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public Boolean deleteUSer(List<String> lst) {
		
		for(String i:lst) {
			try {
				userRepository.delete(Long.parseLong(i));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return true;
	}

	@Override
	public UserDTO findByUserId(Long id) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserEntity userEntity= userRepository.findOne(user.getId());
		UserDTO userDTO= new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setFullName(userEntity.getFullName());
		userDTO.setUserName(userEntity.getUserName());
		userDTO.setPhoneNumber(Integer.toString(userEntity.getPhoneNumber()));;
		userDTO.setAddress(userEntity.getAddress());
		return userDTO;
	}






}
