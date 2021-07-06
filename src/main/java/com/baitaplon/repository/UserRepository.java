package com.baitaplon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.baitaplon.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserName(String username);
	
	@Query(value = "Select * from baitaplon.user where roleid != ?1" ,nativeQuery = true)
	List<UserEntity> getByNotRoleId(Long roleid);
	
	
}
