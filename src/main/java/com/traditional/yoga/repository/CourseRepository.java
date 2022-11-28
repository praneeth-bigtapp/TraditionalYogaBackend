package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseModel;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Integer> {

	@Query(value = "SELECT * FROM `m_course` WHERE `course_Id`= :courseId", nativeQuery = true)
	CourseModel getCourseById(@Param("courseId") int courseId);
}
