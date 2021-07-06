package com.baitaplon.service;

import java.util.List;
import java.util.Map;

import com.baitaplon.controller.web.request.CardDetailForm;
import com.baitaplon.dto.CartDTO;

public interface CartService {
	Map<Long, List<CartDTO>> addCart(CardDetailForm form, Map<Long, List<CartDTO>> cartMap);
	
//	Map<Long, CartDTO> addCart(CardDetailForm form, Map<Long, CartDTO>> cartDTO);
	
	Long showCard(List<CartDTO> list);
	String checkCard(List<CartDTO> list);
	

}
