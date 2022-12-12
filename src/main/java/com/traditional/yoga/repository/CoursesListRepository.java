package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CourseListModel;

@Repository
public interface CoursesListRepository extends JpaRepository<CourseListModel, Integer> {

	
	
	@Query(value = "SELECT * FROM `my_course_material` WHERE `courses_id`=:coursesId", nativeQuery = true)
	CourseListModel getcoursesListById(@Param("coursesId") int coursesId);
	
	
}
