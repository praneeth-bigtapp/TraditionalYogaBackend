package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.RegisteredStudentModel;

@Repository
public interface RegisteredStudentRepository extends JpaRepository<RegisteredStudentModel, Integer> {

	@Query(value = "SELECT * FROM `registered_student` WHERE `registration_student_id`= :registrationId ", nativeQuery = true)
	RegisteredStudentModel getRegistrationById(@Param("registrationId") int registrationId);
	
	@Query(value = "SELECT * FROM `registered_student` WHERE `student_id`= :studentId ", nativeQuery = true)
	RegisteredStudentModel getRegisteredByStudentId(@Param("studentId") int studentId);
	
}
