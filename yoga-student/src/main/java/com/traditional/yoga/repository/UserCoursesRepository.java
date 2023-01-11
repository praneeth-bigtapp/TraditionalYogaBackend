package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.UserCoursesModel;

public interface UserCoursesRepository extends JpaRepository<UserCoursesModel, Integer> {

	@Query(value = "SELECT * FROM `user_courses` WHERE `student_id`=:studentId", nativeQuery = true)
	List<UserCoursesModel> getUserCourses(@Param("studentId") int studentId);


	
	 
	}
