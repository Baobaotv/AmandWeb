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
import com.baitaplon.controller.admin.form.categoryForm;
import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.dto.MyUser;
import com.baitaplon.service.CategoryService;

@Controller(value = "ControllerOfCategoryOfAdmin")
public class CategoryController {
	
	@Autowired
	private CategoryService category;
	
	@RequestMapping(value = "/quan-tri/the-loai")
	public ModelAndView categoryPage(Model model) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		List<CategoryDTO> lst = category.getAll();
		model.addAttribute("listCates", lst);
		ModelAndView mav = new ModelAndView("admin/category/add");
		
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/the-loai/them-the-loai", method = RequestMethod.POST)
	public ResponseEntity<?> addPage(@ModelAttribute categoryForm form) {
		
		String check = category.save(form);

		if (check.equals("done")) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}
	
	@RequestMapping(value = "/quan-tri/the-loai/sua-the-loai", method = RequestMethod.POST)
	public ResponseEntity<?> editPage(@ModelAttribute categoryForm form) {
		
		String check = category.save(form);
		
		if (check.equals("done")) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}
	
	
	@RequestMapping(value = "/quan-tri/the-loai/xoa-the-loai", method = RequestMethod.POST)
	public ResponseEntity<?> deletePage(@ModelAttribute RequestDelete rq) {
		
		if(category.checkDelete(rq.getIds())) {
			if(category.delete(rq.getIds())) {
				return ResponseEntity.ok("true");
			}
			else {
				return ResponseEntity.badRequest().body("false");
			}
		}
		else
			return ResponseEntity.badRequest().body("false");
		
		

	}

}
