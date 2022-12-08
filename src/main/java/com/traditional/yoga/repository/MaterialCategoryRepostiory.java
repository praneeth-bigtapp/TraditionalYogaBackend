package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.MaterialCategoryModel;

public interface MaterialCategoryRepostiory extends JpaRepository<MaterialCategoryModel, Integer> {
	
	
	@Query(value = "SELECT * FROM `material_category` WHERE `material_category_id`= :materialCategoryId", nativeQuery = true)
	MaterialCategoryModel getmaterialCategoryById(@Param("materialCategoryId") int materialCategoryId);
	
	@Query(value = "SELECT * FROM `material_category` WHERE `material_category_id`= :materialCategoryId=4", nativeQuery = true)
	MaterialCategoryModel getotherById(@Param("materialCategoryId") int materialCategoryId);
}
