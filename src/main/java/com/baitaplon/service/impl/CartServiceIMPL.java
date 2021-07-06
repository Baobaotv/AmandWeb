package com.baitaplon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.baitaplon.controller.web.request.CardDetailForm;
import com.baitaplon.dto.CartDTO;
import com.baitaplon.dto.MyUser;
import com.baitaplon.repository.InventoryRepository;
import com.baitaplon.repository.ProductRepository;
import com.baitaplon.service.CartService;
import com.baitaplon.service.InventoryService;

@Service
public class CartServiceIMPL implements CartService {
	
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private ProductRepository ProductRepository;
	
	@Override

	public Map<Long, List<CartDTO>>  addCart(CardDetailForm form, Map<Long, List<CartDTO>> cartMap) {
		
		MyUser user= (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		 CartDTO card= new CartDTO();
		 card.setPrice(form.getPrice());
		 card.setNumber(form.getNumber());
		 card.setSizeId(form.getSizeId());
		 card.setProductCode(form.getCode());		
//		 card.setQty(inventoryService.findByProductCodeAndSizeId(card.getProductCode(), card.getSizeId()));
		 card.setFile(form.getImg());
		 card.setUserID(user.getId());
		 card.setName(form.getName());
		 card.setSizeName(form.getSizeName());
		 card.setProductId(ProductRepository.findOneByProductCodeAndSizeId(card.getProductCode(), form.getSizeId()).getId());
		 if(StringUtils.isNotEmpty(user.getId().toString())) {
			 if(CollectionUtils.isEmpty(cartMap.get(user.getId()))) {
				 List<CartDTO> lst = new ArrayList<CartDTO>();
				 card.setTotalPrice(card.getPrice()*card.getNumber());
				 lst.add(card);
				 cartMap.put(user.getId(), lst);
				 } else {
					 cartMap.get(user.getId());
					 cartMap.get(user.getId()).add(card);
				}
		 }
		return cartMap;
	}

	@Override
	public Long showCard(List<CartDTO> list) {
			Long totalPrice=(long) 0;

    	  if(CollectionUtils.isEmpty(list)) {
    		  
    	  }else {
    		  for(int i=0; i<list.size();i++) {
    			  list.get(i).setQty(inventoryService.findByProductCodeAndSizeId(list.get(i).getProductCode(), list.get(i).getSizeId()));
    		  }
    		  
    		 
    		  for(CartDTO cart:list) {
	    		  totalPrice+= cart.getNumber()*cart.getPrice();
	    	  }
		}
    	  
		return totalPrice;
	}

	@Override
	public String checkCard(List<CartDTO> list) {
		for(CartDTO cartCheck: list) {
			if(cartCheck.getNumber()>cartCheck.getQty())
				return "false";
		}
		return "true";
	}





//	@Override
//	public Map<Long, CartDTO> addCart(CardDetailForm form, Map<Long, CartDTO> cartDTO) {
//		
//		MyUser user= (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		 CartDTO card= new CartDTO();
//		 card.setPrice(form.getPrice());
//		 card.setNumber(form.getNumber());
//		 card.setSizeId(form.getSizeId());
//		 card.setProductCode(form.getCode());
//		 card.setFile(form.getImg());
//		 card.setUserID(user.getId());
//		 if(StringUtils.isNotEmpty(user.getId().toString())) {
//			 if(Objects.isNull(cartDTO.get(user.getId()))) {
//				 List<CartDTO> lst = new ArrayList<CartDTO>();
//				 lst.add(card);
//				 cartDTO.put(user.getId(), new CartDTO());
//				 cartDTO.get(user.getId()).setLstCart(lst);
//				 cartDTO.get(user.getId()).setTotalPrice(card.getPrice()*card.getNumber());
//				 
//				 } else {
//					 Long totalPrice=cartDTO.get(user.getId()).getTotalPrice()+card.getNumber()*card.getPrice();
//					 cartDTO.get(user.getId()).setTotalPrice(totalPrice);
//					 cartDTO.get(user.getId()).getLstCart().add(card);
//				}
//		 }
//		return cartDTO;
//	}

}
