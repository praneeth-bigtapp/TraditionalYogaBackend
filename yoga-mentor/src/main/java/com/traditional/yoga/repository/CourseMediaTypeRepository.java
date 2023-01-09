package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseMediaTypeModel;

@Repository
public interface CourseMediaTypeRepository extends JpaRepository<CourseMediaTypeModel, Integer> {

	@Query(value = "SELECT * FROM `course_media_type` WHERE `id`= :id", nativeQuery = true)
	CourseMediaTypeModel getMediaTypeById(@Param("id") int id);
}
