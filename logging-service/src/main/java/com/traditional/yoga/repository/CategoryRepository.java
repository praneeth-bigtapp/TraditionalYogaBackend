package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.MasterCategoryModel;

public interface CategoryRepository  extends JpaRepository<MasterCategoryModel, Integer>{

	@Query(value = "SELECT * FROM `m_categories`where `categories_id`= :categoriesId",nativeQuery = true)
	MasterCategoryModel getpraticecategoryById(@Param("categoriesId") int categoriesId);
}
