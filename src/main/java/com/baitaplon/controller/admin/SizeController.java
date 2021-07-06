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
import com.baitaplon.controller.admin.form.SizeForm;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.SizeDTO;
import com.baitaplon.service.SizeService;

@Controller(value = "ControllerOfsizeOfAdmin")
public class SizeController {
	
	@Autowired
	private SizeService size;
	
	@RequestMapping(value = "/quan-tri/size")
	public ModelAndView sizePage(Model model) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		List<SizeDTO> lst = size.findAll();
		model.addAttribute("listCates", lst);
		ModelAndView mav = new ModelAndView("admin/size/add");
		
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/size/them-size", method = RequestMethod.POST)
	public ResponseEntity<?> addPage(@ModelAttribute SizeForm form) {
		
		String check = size.save(form);

		if (check.equals("done")) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}
	
	@RequestMapping(value = "/quan-tri/size/sua-size", method = RequestMethod.POST)
	public ResponseEntity<?> editPage(@ModelAttribute SizeForm form) {
		
		String check = size.save(form);
		
		if (check.equals("done")) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}
	
	
	@RequestMapping(value = "/quan-tri/size/xoa-size", method = RequestMethod.POST)
	public ResponseEntity<?> deletePage(@ModelAttribute RequestDelete rq) {
		
		if(size.checkDelete(rq.getIds())) {
			if(size.delete(rq.getIds())) {
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
