package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

	@Query(value = "SELECT * FROM `student_details` WHERE `student_id`=:studentId", nativeQuery = true)
	StudentModel getStudentById(@Param("studentId") int studentId);
}
