package com.baitaplon.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baitaplon.controller.admin.form.RequestDelete;
import com.baitaplon.controller.admin.form.RoleForm;
import com.baitaplon.controller.admin.form.categoryForm;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.RoleDTO;
import com.baitaplon.service.RoleService;

@Controller(value = "controllerOfRoleOfAdmin")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/quan-tri/chuc-nang")
	public ModelAndView rolePage(Model model) {
		List<RoleDTO> lstRoleDTO=roleService.getAll();
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);

		model.addAttribute("lstRoleDTO",lstRoleDTO);
		ModelAndView mav = new ModelAndView("admin/role/add");
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/chuc-nang/them-chuc-nang", method = RequestMethod.POST)
	public ResponseEntity<?> addPage(@ModelAttribute RoleForm form) {
			Boolean check = roleService.save(form);

		if (check) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}
	
	@RequestMapping(value = "/quan-tri/chuc-nang/sua-chuc-nang", method = RequestMethod.POST)
	public ResponseEntity<?> editPage(@ModelAttribute RoleForm form) {
		Boolean check = roleService.save(form);

		if (check) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}
	}
	
	@RequestMapping(value = "/quan-tri/chuc-nang/xoa-chuc-nang", method = RequestMethod.POST)
	public ResponseEntity<?> deletePage(@ModelAttribute RequestDelete rq) {
		Boolean check=roleService.delete(rq.getIds());

		if (check) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}
	}

}
