package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.SubCategoryPraticeLibaryModel;

public interface SubCategoryPraticeRepsoitory extends JpaRepository<SubCategoryPraticeLibaryModel, Integer> {

	@Query(value = "SELECT * FROM `sub_category_praticelibary` WHERE `sub_category_id`= :subCategoryId", nativeQuery = true)
	SubCategoryPraticeLibaryModel getsubCategorybyId(@Param("subCategoryId") int subCategoryId);

}
