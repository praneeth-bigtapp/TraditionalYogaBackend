package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.DonationModel;
import com.traditional.yoga.model.ModuleModel;

public interface DonationRepository extends JpaRepository<DonationModel, Integer> {
	
	@Query(value = "SELECT * FROM `donation` WHERE `student_id`=:student_id;", nativeQuery = true)
	ModuleModel getModuleById(@Param("moduleId") int moduleId);

}
