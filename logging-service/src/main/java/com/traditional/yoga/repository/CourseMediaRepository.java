package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseMediaModel;

@Repository
public interface CourseMediaRepository extends JpaRepository<CourseMediaModel, Integer> {

	@Query(value = "SELECT * FROM `course_media_files` WHERE `course_media_id`= :courseMediaId", nativeQuery = true)
	CourseMediaModel getCourseMediaById(@Param("courseMediaId") int courseMediaId);
}
