package com.baitaplon.controller.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baitaplon.controller.web.request.CardDetailForm;
import com.baitaplon.controller.web.request.UserDetailForm;
import com.baitaplon.dto.CartDTO;
import com.baitaplon.dto.CategoryDTO;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.UserDTO;
import com.baitaplon.service.CartService;
import com.baitaplon.service.CategoryService;
import com.baitaplon.service.InventoryService;
import com.baitaplon.service.UserService;
import com.baitaplon.service.impl.OderServiceIMPL;

@Controller(value = "ControllerOfCardOfWeb")
public class CardController {

	@Autowired
	private CartService cartServiceIMPL;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private OderServiceIMPL oderServiceIMPL;

	Map<Long, List<CartDTO>> cart = new LinkedHashMap<Long, List<CartDTO>>();
//	Map<Long , CartDTO> cartDTO = new LinkedHashMap<Long, CartDTO>();
	private List<CartDTO> lst;
	private List<CartDTO> listCart;

	@RequestMapping(value = "/trang-chu/addcard", method = RequestMethod.POST)
	public ResponseEntity<?> addCard(@ModelAttribute CardDetailForm form) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.cart = cartServiceIMPL.addCart(form, cart);

//		return ResponseEntity.ok("true");

		return new ResponseEntity<>(this.cart.get(user.getId()), HttpStatus.OK);

	}

	@RequestMapping(value = "/trang-chu/deleteCard", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCard(@RequestBody String id) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int i = Integer.parseInt(id);
		this.cart.get(user.getId()).remove(i);

//		return ResponseEntity.ok("true");

		return new ResponseEntity<>(this.cart.get(user.getId()), HttpStatus.OK);

	}

	@RequestMapping(value = "/trang-chu/gio-hang", method = RequestMethod.GET)
	public ModelAndView cartPage(Model model) {
		
		   List<CategoryDTO> lstCategory = categoryService.getAll();
		
		   model.addAttribute("lstCategory",lstCategory);
			
			
			 
		ModelAndView mav = new ModelAndView("web/cart/cart2");
		Long totalPrice = (long) 0;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//	    	  model.addAttribute("lstcart",cardDTO.getLstCartDTO());
		} else {
			MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//	    	  List<CartDTO> lstShow=cartServiceIMPL.showCart(cardDTO.getLstCartDTO());
		
//	    	  List<CartDTO> lstShow = (List<CartDTO>) this.cart.get(user.getId());

//	    	  List<CartDTO> lstShow = this.cartDTO.get(user.getId()).getLstCart();
			/*
			 * if(CollectionUtils.isEmpty(lstShow)) {
			 * 
			 * }else { for(int i=0; i<lstShow.size();i++) {
			 * lstShow.get(i).setQty(inventoryService.findByProductCodeAndSizeId(lstShow.get
			 * (i).getProductCode(), lstShow.get(i).getSizeId())); }
			 * 
			 * 
			 * for(CartDTO cart:lstShow) { totalPrice+= cart.getNumber()*cart.getPrice(); }
			 * }
			 */
			String check=null;
			if(!CollectionUtils.isEmpty(this.cart.get(user.getId()))) {
				totalPrice = cartServiceIMPL.showCard(this.cart.get(user.getId()));	
				check = cartServiceIMPL.checkCard(this.cart.get(user.getId()));
			}
			model.addAttribute("lstcart", this.cart.get(user.getId()));
			model.addAttribute("check",check);
			model.addAttribute("totalPrice", totalPrice);
			  UserDTO userDTO= userService.findByUserId(user.getId());
			  model.addAttribute("userDTO",userDTO);

		}

		return mav;
	}

	@RequestMapping(value = "/trang-chu/payCart", method = RequestMethod.POST)
	public ResponseEntity<?> order(@ModelAttribute UserDetailForm form) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Boolean check = oderServiceIMPL.save(this.cart.get(user.getId()), form);
		

		if (check) {
			this.cart.remove(user.getId());
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.badRequest().body("false");
		}

	}

}
