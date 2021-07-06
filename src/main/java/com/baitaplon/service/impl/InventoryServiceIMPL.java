package com.baitaplon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baitaplon.entity.InventoryEntity;
import com.baitaplon.repository.InventoryRepository;
import com.baitaplon.service.InventoryService;

@Service
public class InventoryServiceIMPL implements InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public Long findByProductCodeAndSizeId(String productCode, Long sizeId) {
		InventoryEntity inven= inventoryRepository.findByProductCodeAndSizeId(productCode, sizeId);
		return inven.getQty();
	}

	

}
