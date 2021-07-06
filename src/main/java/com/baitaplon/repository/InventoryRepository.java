package com.baitaplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baitaplon.entity.InventoryEntity;
@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
	
	InventoryEntity findOneByProductId(Long id);
	
	@Query(value = "select * from baitaplon.inventory where product_id=(select id from baitaplon.product where code= ?1 and site_id= ?2 )", nativeQuery = true)
	InventoryEntity findByProductCodeAndSizeId(String productCode, Long sizeId);

}
