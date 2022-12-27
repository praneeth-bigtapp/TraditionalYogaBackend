package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.StudentStatus;

public interface StudentStatusRepostiory extends JpaRepository<StudentStatus, Integer> {

	@Query(value = "SELECT * FROM `student_current_status` WHERE `status_id`= :statusId", nativeQuery = true)
	StudentStatus getbannerbyId(@Param("statusId") int statusId);

}
