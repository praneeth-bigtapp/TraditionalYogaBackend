package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseProfileModel;

@Repository
public interface CourseProfileRepository extends JpaRepository<CourseProfileModel, Integer> {

	@Query(value = "SELECT * FROM `course_profile` WHERE `course_profile_id`= :courseProfileId ", nativeQuery = true)
	CourseProfileModel getCourseProfileById(@Param("courseProfileId") int courseProfileId);
	
	@Query(value = "SELECT * FROM `course_profile` WHERE `student_id`= :studentId", nativeQuery = true)
	List<CourseProfileModel> getCourseProfileByStudentId(@Param("studentId") int studentId);
}
