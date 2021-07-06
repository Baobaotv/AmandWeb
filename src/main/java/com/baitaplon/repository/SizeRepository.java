package com.baitaplon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baitaplon.dto.SizeDTO;
import com.baitaplon.entity.SizeEntity;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity, Long> {

	@Query(value = "select * from size where id = ?1", nativeQuery = true)
	SizeEntity findSizeById(Integer id);


	 @Query(value ="select s.name, s.code,s.id,s.createdby, s.createddate,s.modifiedby,s.modifieddate from  product p inner join size s on p.site_id=s.id where p.code =(select p.code from product p where p.id= ?1)",nativeQuery = true)
	 List<SizeEntity> findAllByProductId(Long id);
	
	/*@Query(value = "select s.name from baitaplon.size s where id in(select site_id from baitaplon.product where code = ?1)", nativeQuery = true)
	@Modifying
	List<String> findSiteName(String code);*/
}
