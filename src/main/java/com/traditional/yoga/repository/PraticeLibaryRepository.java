package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.PraticeLibaryModel;

@Repository
public interface PraticeLibaryRepository extends JpaRepository<PraticeLibaryModel, Integer> {

//	@Query(value = "SELECT * FROM `pratice_libary`where `library_category_id`= :categoryId",nativeQuery = true)
//	PraticeLibaryModel getpraticecategoryById(@Param("categoryId") int categoryId);
	
	@Query(value = "SELECT * FROM `pratice_libary`where `pratice_libary_id`= :praticeLibaryId",nativeQuery = true)
	PraticeLibaryModel getpraticeById(@Param("praticeLibaryId") int praticeLibaryId);
}
