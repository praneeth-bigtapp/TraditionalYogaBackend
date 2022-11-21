package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.DonationModel;
@Repository
public interface DonationRepository extends JpaRepository<DonationModel, Integer> {
	
//	@Query(value = "SELECT * FROM `donation` WHERE `student_id`=:student_id;", nativeQuery = true)
//	DonationModel getDonationById(@Param("studentId") int studentId);

	@Query(value = "SELECT * FROM `donation` WHERE `student_id`=:studentId;",nativeQuery = true)
	DonationModel getDonationByStudentId(@Param("studentId") int studentId);
	
}
