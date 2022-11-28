package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseCategoryModel;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategoryModel, Integer> {

	@Query(value = "SELECT * FROM `m_course_category` WHERE `category_id`= :categoryId", nativeQuery = true)
	CourseCategoryModel getCategoryById(@Param("categoryId") int categoryId);
}
