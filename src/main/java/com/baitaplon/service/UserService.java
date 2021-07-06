package com.baitaplon.service;

import java.util.List;

import com.baitaplon.controller.admin.form.RequestDelete;
import com.baitaplon.controller.web.request.UserDetailForm;
import com.baitaplon.dto.UserDTO;
import com.baitaplon.entity.UserEntity;

public interface UserService {

	Boolean addUser(UserDetailForm form);
	List<UserDTO> getAllAdminAndManager(Long roleId);
	Boolean UpdateUser(UserDetailForm form);
	Boolean deleteUSer(List<String> lst);
	UserDTO findByUserId(Long id);

}
