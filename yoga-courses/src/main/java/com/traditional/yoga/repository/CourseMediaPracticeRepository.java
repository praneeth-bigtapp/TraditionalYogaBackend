package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseMediaPracticeModel;

@Repository
public interface CourseMediaPracticeRepository extends JpaRepository<CourseMediaPracticeModel, Integer> {

	@Query(value = "SELECT * FROM `course_media_practice` WHERE `course_media_category_id`= :categoryId", nativeQuery = true)
	CourseMediaPracticeModel getCategoryById(@Param("categoryId") int categoryId);
}
