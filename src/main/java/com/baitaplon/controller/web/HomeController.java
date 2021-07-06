package com.baitaplon.controller.web;

import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baitaplon.controller.web.request.UserDetailForm;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.dto.SizeDTO;
import com.baitaplon.service.CategoryService;
import com.baitaplon.service.ProductService;
import com.baitaplon.service.SizeService;
import com.baitaplon.service.UserService;

@Controller(value = "ControllerOfWeb")
public class HomeController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;;
	@Autowired
	private UserService userServiceIMPL;
	@Autowired
	private SizeService sizeService;
	
  
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage(Model model) {
	   
	   List<ProductDTO> lst = productService.getAllProduct();
	   List<ProductDTO> lstA = productService.getAllByCategory("Ao-somi");
	   List<ProductDTO> lstQB = productService.getAllByCategory("Ao-phong");
	   List<CategoryDTO> lstCategory = categoryService.getAll();
	   ProductDTO productRandom=productService.findOneRandomProduct();
	   List<SizeDTO> lstSizeDTO= sizeService.findAllByProductId(productRandom.getId());
		
	   model.addAttribute("productRandom",productRandom);
	   model.addAttribute("lstSizeDTO",lstSizeDTO);
		model.addAttribute("lstProduct", lst);
		model.addAttribute("lstProductA", lstA);
		model.addAttribute("lstProductQB", lstQB);
		model.addAttribute("lstCategory",lstCategory);
      ModelAndView mav = new ModelAndView("web/home2");
      return mav;
   }
   @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
   public ModelAndView signinPage() {
      ModelAndView mav = new ModelAndView("login/signin");
      return mav;
   }
   
   @RequestMapping(value = "/dang-ki", method = RequestMethod.GET)
   public ModelAndView signupPage() {
      ModelAndView mav = new ModelAndView("login/signup");
      return mav;
   }
   
   @RequestMapping(value = "/them-tai-khoan", method = RequestMethod.POST)
   public ResponseEntity<?> addUser(@ModelAttribute UserDetailForm form) {
	   
	   if (userServiceIMPL.addUser(form)) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}
     
     
   }
  
 
}
