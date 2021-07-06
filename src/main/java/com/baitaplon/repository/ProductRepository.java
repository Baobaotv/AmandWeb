package com.baitaplon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.baitaplon.entity.ProductEntity;
import com.baitaplon.entity.UserEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
		
	ProductEntity findOneById(Long id);
	
	@Query(value  ="select * from product p inner join category c on p.category_id=c.id where c.code = ?1 and is_delete = ?2" , nativeQuery = true)
	List<ProductEntity> findAllByCategory(String code, String check);
	
	@Query(value  ="select * from product where is_delete= ?1" , nativeQuery = true)
	List<ProductEntity> findAllProductByIsDelete(String isDelete);
	
	@Query(value="UPDATE product SET is_delete=1 WHERE id in :ids" , nativeQuery = true)
	@Modifying
	@Transactional
	Integer deleteProduct(@Param("ids") List<String> ids);
	
	@Query(value = "SELECT * FROM baitaplon.product where is_delete=0  ORDER BY RAND ( )  LIMIT 1 " , nativeQuery = true)
	ProductEntity findOneRandomProduct();
	
	@Query(value = "SELECT * FROM baitaplon.product where code= ?1 and site_id= ?2  " , nativeQuery = true)
	ProductEntity findOneByProductCodeAndSizeId(String code, Long sizeId);
	
	@Query(value  ="select * from product  where category_id in :ids and is_delete = 0" , nativeQuery = true)
	List<ProductEntity> findAllByCategoryId(@Param("ids") List<Long> ids);
	
	@Query(value  ="select * from product  where site_id in :ids and is_delete = 0" , nativeQuery = true)
	List<ProductEntity> findAllBySizeId(@Param("ids") List<Long> ids);
	
}
