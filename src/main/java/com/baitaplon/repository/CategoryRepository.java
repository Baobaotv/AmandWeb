package com.baitaplon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baitaplon.entity.CategoryEntity;

@Repository
public interface CategoryRepository   extends JpaRepository<CategoryEntity, Long>{
	
	
	@Query(value = "select * from category where id = ?1", nativeQuery = true)
	CategoryEntity findCategoryById(Integer id);
	
	
	List<CategoryEntity> findAllByCode(String code);
	
	
}
