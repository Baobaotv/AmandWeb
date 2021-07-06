package com.baitaplon.service;

import java.util.List;

import com.baitaplon.controller.admin.form.RoleForm;
import com.baitaplon.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> getAll();
	Boolean save(RoleForm form);
	
	Boolean delete(List<String> lst);
}
