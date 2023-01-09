package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseMediaCategoryModel;

@Repository
public interface CourseMediaCategoryRepository extends JpaRepository<CourseMediaCategoryModel, Integer> {

	@Query(value = "SELECT * FROM `course_media_category` WHERE `course_media_category_id`= :categoryId", nativeQuery = true)
	CourseMediaCategoryModel getCategoryById(@Param("categoryId") int categoryId);
}
