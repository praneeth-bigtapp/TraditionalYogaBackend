package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.LibaryCategoryModel;

@Repository
public interface CategoryLibaryRepository extends JpaRepository<LibaryCategoryModel, Integer>{

	
	@Query(value = "SELECT * FROM `library_category `where `category_id`= :categoryId",nativeQuery = true)
	LibaryCategoryModel getpraticecategoryById(@Param("categoryId") int categoryId);
}
