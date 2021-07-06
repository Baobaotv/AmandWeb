package com.baitaplon.service;

import java.util.List;

import com.baitaplon.controller.web.request.UserDetailForm;
import com.baitaplon.dto.CartDTO;
import com.baitaplon.dto.OrderDTO;

public interface OrderService {
	Boolean save(List<CartDTO> lstCart,UserDetailForm form);
	List<OrderDTO> getAll();
	Boolean updateOrder(String id);

}
