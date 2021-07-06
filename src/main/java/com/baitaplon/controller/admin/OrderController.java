package com.baitaplon.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.OrderDTO;
import com.baitaplon.service.OrderService;

@Controller(value = "controllerOFOrderOfAdmin")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/quan-tri/don-hang")
	public ModelAndView orderPage(Model model) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		List<OrderDTO> lstOder= orderService.getAll();
		model.addAttribute("lstOder",lstOder);
		ModelAndView mav = new ModelAndView("admin/order/add");
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/don-hang/hoan-thanh-don-hang", method = RequestMethod.POST)
	public ResponseEntity<?> editPage(@RequestBody String id) {
		String a=null;
		
		Boolean check = orderService.updateOrder(id);
		if (check) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}
	
	

}
