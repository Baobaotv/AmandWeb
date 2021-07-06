package com.baitaplon.service;

public interface InventoryService {
	Long findByProductCodeAndSizeId(String productCode, Long sizeId);
}
