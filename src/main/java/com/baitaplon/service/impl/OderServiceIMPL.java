package com.baitaplon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.baitaplon.controller.web.request.UserDetailForm;
import com.baitaplon.dto.CartDTO;
import com.baitaplon.dto.MyUser;
import com.baitaplon.dto.OrderDTO;
import com.baitaplon.entity.OrderEntity;
import com.baitaplon.repository.OrderRepository;
import com.baitaplon.service.OrderService;

@Service
public class OderServiceIMPL implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Boolean save(List<CartDTO> lstCart,UserDetailForm form) {
		MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		OrderEntity orderEntiry= null;
		
	
		for(CartDTO cart: lstCart) {
			orderEntiry= new OrderEntity();
			orderEntiry.setUserName(form.getUserName());
			orderEntiry.setFullName(form.getFullName());
			orderEntiry.setPhoneNumber(form.getPhoneNumber());
			orderEntiry.setAddress(form.getAddress());
			orderEntiry.setProductCode(cart.getProductCode());
			orderEntiry.setProductName(cart.getName());
			orderEntiry.setQty(String.valueOf(cart.getNumber()));
			orderEntiry.setProductId(String.valueOf(cart.getProductId()));
			orderEntiry.setSizeName(cart.getSizeName());
			orderEntiry.setImage(cart.getFile());
			orderEntiry.setStatus("0");
			try {
				orderRepository.save(orderEntiry);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return true;
	}

	@Override
	public List<OrderDTO> getAll() {
		List<OrderEntity> lstEntity=orderRepository.findAll();
		List<OrderDTO> lstDTO= new ArrayList<OrderDTO>();
		OrderDTO order= null;
		for(OrderEntity e: lstEntity) {
			order = new OrderDTO();
			order.setProductCode(e.getProductCode());
			order.setProductId(e.getProductId());
			order.setProductName(e.getProductName());
			order.setProductQty(e.getQty());
			order.setUserPhoneNumber(e.getPhoneNumber());
			order.setUserAddress(e.getAddress());
			order.setUserFullName(e.getFullName());
			order.setUserName(e.getUserName());
			order.setSizeName(e.getSizeName());
			order.setStatus(e.getStatus());
			order.setId( String.valueOf(e.getId()) );
			order.setProductImg(e.getImage());
			lstDTO.add(order);
		}
		return lstDTO;
	}

	@Override
	public Boolean updateOrder(String id) {
		/*
		 * Long ids=Long.parseLong(id); OrderEntity order= orderRepository.findOne(ids);
		 * order.setStatus("1"); orderRepository.save(order);
		 */
		try {
			orderRepository.updateOrder(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
