package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
	
	@Query(value = "SELECT COUNT(*) FROM `student_details` ", nativeQuery = true)
	int getMaxCount();

	@Query(value = "SELECT * FROM `student_details` WHERE `student_id`= :studentId", nativeQuery = true)
	StudentModel getStudentById(@Param("studentId") int studentId);
	
	@Query(value = "SELECT * FROM `student_details` WHERE `course_id`= :courseId", nativeQuery = true)
	List<StudentModel> getStudentByCourseId(@Param("courseId") int courseId);
	
	@Query(value = "SELECT COUNT(*) FROM `student_details` WHERE `course_id`= :courseId", nativeQuery = true)
	int getCountByCourseId(@Param("courseId") int courseId);
	
	@Query(value = "SELECT * FROM `student_details` WHERE `course_id`= :courseId AND `mentor_status` = 0 ", nativeQuery = true)
	List<StudentModel> getStudentByMentor(@Param("courseId") int courseId);
	
	@Query(value = "SELECT COUNT(*) FROM `student_details` WHERE `course_id`= :courseId  AND `mentor_status` = 0", nativeQuery = true)
	int getCountByMentor(@Param("courseId") int courseId);
	
	@Query(value = "SELECT COUNT(*) FROM `student_details` WHERE `email_address`= :eamilId ", nativeQuery = true)
	int getCountByBlackList(@Param("eamilId") String eamilId);
}
