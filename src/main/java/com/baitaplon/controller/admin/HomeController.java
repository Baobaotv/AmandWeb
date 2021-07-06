package com.baitaplon.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baitaplon.controller.admin.form.RequestDelete;
import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.entity.CategoryEntity;
import com.baitaplon.entity.SizeEntity;
import com.baitaplon.repository.ProductRepository;
import com.baitaplon.service.CategoryService;
import com.baitaplon.service.ProductService;
import com.baitaplon.service.SizeService;

@Controller(value = "ControllerOfAdmin")
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SizeService sizeService;

	@RequestMapping(value = "/quan-tri")
	public ModelAndView homePage(Model model) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
/*	@RequestMapping(value = "/quan-tri/tai-khoan")
	public ModelAndView userPage(Model model) {
		ModelAndView mav = new ModelAndView("admin/user/add");
		return mav;
	}*/

/*	@RequestMapping(value = "/quan-tri/san-pham")
	public ModelAndView productPage(Model model) {

		List<CategoryDTO> lst = categoryService.getAll();

		List<SizeEntity> lstSize = sizeService.getAllSize();

		List<ProductDTO> lstP = productService.getAllProduct();

		model.addAttribute("lstProduct", lstP);
		model.addAttribute("listCates", lst);
		model.addAttribute("lstSize", lstSize);
		ModelAndView mav = new ModelAndView("admin/product/add");
		return mav;
	}*/

	@RequestMapping(value = "/dang-xuat")
	public ModelAndView logoutPage() {
		ModelAndView mav = new ModelAndView("redirect:/trang-chu");
		return mav;
	}

	/*
	 * @RequestMapping(value = "/quan-tri/san-pham/chinh-sua") public ModelAndView
	 * editPage() { ModelAndView mav = new ModelAndView("admin/product/edit");
	 * return mav; }
	 */


/*	@RequestMapping(value = "/quan-tri/san-pham/sua-san-pham", method = RequestMethod.POST)
	public ResponseEntity<?> editPage(@ModelAttribute productForm form) {
		String check = productService.save(form);

		if (check.equals("done")) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}*/
	
/*	@RequestMapping(value = "/quan-tri/san-pham/xoa-san-pham", method = RequestMethod.POST)
	public ResponseEntity<?> deletePage(@ModelAttribute RequestDelete rq) {
		//* String check = productService.save(form); 
		
		String check=productService.delete(rq.getIds());

		if (check.equals("done")) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}*/
	

	
	
	


}