package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.QualificationModel;

@Repository
public interface QualificationRepository extends JpaRepository<QualificationModel, Integer> {

	@Query(value = "SELECT * FROM `qualification` WHERE `qualification_id`= :qualificationId", nativeQuery = true)
	QualificationModel getQualificationById(@Param("qualificationId") int qualificationId);
	
	@Query(value = "SELECT * FROM `qualification` WHERE `qualification_name`= :qualificationName", nativeQuery = true)
	QualificationModel getQualificationByName(@Param("qualificationName") String qualificationName);
}
