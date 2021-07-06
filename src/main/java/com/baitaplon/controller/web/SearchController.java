package com.baitaplon.controller.web;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baitaplon.controller.web.request.CardDetailForm;
import com.baitaplon.controller.web.request.SearchDetailForm;
import com.baitaplon.dto.CartDTO;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.service.CategoryService;
import com.baitaplon.service.ProductService;

@Controller(value = "controllerOfSearchOfWeb")
public class SearchController {
	@Autowired
	private CategoryService categoriService;
	@Autowired
	private ProductService productService;
	List<ProductDTO> lstProduct= null;
	
	@RequestMapping(value = "/trang-chu/search", method = RequestMethod.POST)
	public ResponseEntity<?> addCard(@ModelAttribute SearchDetailForm form, Model model) {
//		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		this.cart = cartServiceIMPL.addCart(form, cart);
//
////		return ResponseEntity.ok("true");
		String converttoEng=deAccent(form.getSearch()).toLowerCase();
		List<CategoryDTO> lstCartegory= categoriService.getAllToEng();
		List<Long> idsCategory= new ArrayList<Long>();
		for(CategoryDTO cart:lstCartegory) {
			if(converttoEng.contains(cart.getName())) {
				idsCategory.add(cart.getId());
			}
			else {
				if(cart.getName().contains(converttoEng)) {
					idsCategory.add(cart.getId());
				}
				
			}
		}
		this.lstProduct= productService.findAllByCategoryId(idsCategory);
		model.addAttribute("lstProduct",lstProduct);
		
		

		return ResponseEntity.ok("true");

	}
	
	@RequestMapping(value = "/trang-chu/san-pham-search", method = RequestMethod.GET)
	public ModelAndView homePage(Model model) {
		model.addAttribute("lstProduct",lstProduct);
		ModelAndView mav = new ModelAndView("web/product/product");
		return mav;
	}
	
	public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

}
