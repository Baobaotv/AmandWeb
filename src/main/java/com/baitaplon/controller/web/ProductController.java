package com.baitaplon.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.controller.web.request.ProductDetailForm;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.dto.SizeDTO;
import com.baitaplon.service.CategoryService;
import com.baitaplon.service.ProductService;
import com.baitaplon.service.SizeService;

@Controller(value = "ControllerOfProductOfWeb")
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private SizeService sizeService;

	@RequestMapping(value = "/trang-chu/san-pham", method = RequestMethod.GET)
	public ModelAndView homePage(Model model, @RequestParam(name = "category") String categoryCode) {
		List<CategoryDTO> lstCategory = categoryService.getAll();

		List<ProductDTO> lstProduct = productService.getAllByCategory(categoryCode);

		model.addAttribute("lstProduct", lstProduct);
		model.addAttribute("lstCategory", lstCategory);
		ModelAndView mav = new ModelAndView("web/product/product");
		return mav;
	}

/*	@RequestMapping(value = "/trang-chu/san-pham/thong-tin-san-pham", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView infomationPage(@ModelAttribute ProductDetailForm form, Model model) {
		ProductDTO productDTO = productService.findOneById(form.getId());
		 List<SizeDTO> lstSizeDTO= sizeService.findByProductId(form.getId()); 
		List<String> lstSize = sizeService.findByProductCode(form.getCode());
		model.addAttribute("lstSizeDTO", lstSize);
		model.addAttribute("product", productDTO);
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}*/
	@RequestMapping("/trang-chu/san-pham/thong-tin-san-pham/{id}")
	public ModelAndView infomationPage(@PathVariable("id") Long id, Model model) {
		ProductDTO productDTO = productService.findOneById(id);
		 List<SizeDTO> lstSizeDTO= sizeService.findAllByProductId(id); 
		 List<CategoryDTO> lstCategory = categoryService.getAll();
		 model.addAttribute("lstCategory", lstCategory);
		 model.addAttribute("lstSizeDTO", lstSizeDTO);
			model.addAttribute("product", productDTO);
			ModelAndView mav = new ModelAndView("web/product/information2");
			return mav;
	}

}
