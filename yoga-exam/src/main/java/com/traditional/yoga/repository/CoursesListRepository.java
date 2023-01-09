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
	
	
	//course name //
	@Query(value = "SELECT * FROM `my_course_material` WHERE `courses_name`=:coursesName", nativeQuery = true)
	CourseListModel getcoursesListBycoursesName(@Param("coursesName") String coursesName);
	
	//description//
	@Query(value = "SELECT * FROM `my_course_material` WHERE `description`=:description", nativeQuery = true)
	CourseListModel getcoursesListBydescription(@Param("description") String description);
	
	//startDate//
	@Query(value = "SELECT * FROM `my_course_material` WHERE `start_date`=:startDate", nativeQuery = true)
	CourseListModel getcoursesListBystartdate(@Param("startDate") String startDate);
	
	
	//endDate//
	@Query(value = "SELECT * FROM `my_course_material` WHERE `end_date`=:endDate", nativeQuery = true)
	CourseListModel getcoursesListByenddate(@Param("endDate") String endDate);
	
	
	@Query(value = "SELECT * FROM `my_course_material` WHERE `application_closer_date`=:applicationClouserDate", nativeQuery = true)
	CourseListModel getcoursesListByclouserdate(@Param("applicationClouserDate") String applicationClouserDate);
	
	@Query(value = "SELECT COUNT(*) FROM `my_course_material`", nativeQuery = true)
	int countCourse();
	
}
