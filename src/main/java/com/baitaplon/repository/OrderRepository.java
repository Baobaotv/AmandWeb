package com.baitaplon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.baitaplon.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	@Query(value="UPDATE baitaplon.order_product p SET p.status=1 WHERE p.id = ?1 ;" , nativeQuery = true)
	@Modifying
	@Transactional
//	Integer updateOrder(String id);
	Integer updateOrder(String id);
	
	OrderEntity findOneById(Long id);
	
	

}
