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
import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.controller.web.request.UserDetailForm;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.dto.RoleDTO;
import com.baitaplon.dto.UserDTO;
import com.baitaplon.entity.SizeEntity;
import com.baitaplon.service.RoleService;
import com.baitaplon.service.UserService;

@Controller(value = "controllerOfUserOfAdmin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping(value = "/quan-tri/tai-khoan")
	public ModelAndView userPage(Model model) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		List<UserDTO>lstDTO=userService.getAllAdminAndManager((long) 3);
		List<RoleDTO> lstRoleDTO= roleService.getAll();
		model.addAttribute("lstRoleDTO",lstRoleDTO);
		model.addAttribute("lstDTO",lstDTO);
		ModelAndView mav = new ModelAndView("admin/user/add");
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/tai-khoan/them-tai-khoan", method = RequestMethod.POST)
	public ResponseEntity<?> addUserPage(@ModelAttribute UserDetailForm form) {
		Boolean check = userService.addUser(form);

		if (check) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}
	
	
	@RequestMapping(value = "/quan-tri/tai-khoan/sua-tai-khoan", method = RequestMethod.POST)
	public ResponseEntity<?> editUserPage(@ModelAttribute UserDetailForm form) {
		Boolean check = userService.UpdateUser(form);

		if (check) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}
		

	}
	
	@RequestMapping(value = "/quan-tri/tai-khoan/xoa-tai-khoan", method = RequestMethod.POST)
	public ResponseEntity<?> deleteUserPage(@ModelAttribute RequestDelete rq) {
		/* String check = productService.save(form); */
		
		Boolean check=userService.deleteUSer(rq.getIds());

		if (check) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}
	


}
