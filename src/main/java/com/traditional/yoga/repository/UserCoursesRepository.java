package com.traditional.yoga.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.RegistrationModel;
import com.traditional.yoga.model.UserCoursesModel;

public interface UserCoursesRepository extends JpaRepository<UserCoursesModel, Integer> {

	  @Query(value = "SELECT * FROM `user_courses` WHERE`user_courses_id`=:userCoursesId", nativeQuery = true)
	  UserCoursesModel getUserCourses(@Param("userCoursesId") int userCoursesId);

	
	  @Modifying
	  @Transactional
	  @Query(value = "INSERT INTO `user_courses` (`student_id`, `course_id`) VALUES (:studentId, :coursesId)", nativeQuery = true)
	  void addCourses(@Param("studentId") RegistrationModel registrationModel, @Param("coursesId") int courseId);



	  @Query(value = "SELECT * FROM `user_courses` WHERE`student_id`=:studentId", nativeQuery = true)
	  UserCoursesModel getCertificationalert(@Param("studentId") RegistrationModel registrationModel);
	}
