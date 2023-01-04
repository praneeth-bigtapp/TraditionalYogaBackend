package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.UserCoursesModel;

public interface UserCoursesRepository extends JpaRepository<UserCoursesModel, Integer> {
	
	@Query(value = "SELECT * FROM `user_courses` WHERE`user_courses_id`=:userCoursesId", nativeQuery = true)
	UserCoursesModel getUserCourses(@Param("userCoursesId") int userCoursesId);

}
