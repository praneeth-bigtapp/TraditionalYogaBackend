package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.GurujiRepliesStudent;

@Repository
public interface GurujiRepliesStudentRepository extends JpaRepository<GurujiRepliesStudent, Integer> {
	
//	@Query(value = "SELECT * FROM `guruji_replies_student` where `student_id`= :student",nativeQuery = true)
//	GurujiRepliesStudent getMessagebyId(@Param("student") int student);
	
	@Query(value = "SELECT * FROM `guruji_replies_student` where `student_id`= :studentId",nativeQuery = true)
    GurujiRepliesStudent getMessagebyId(@Param("studentId") int studentId);
	
}
