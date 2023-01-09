package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.MaritalStatusModel;

@Repository
public interface MaritalStatusRepository extends JpaRepository<MaritalStatusModel, Integer> {

	@Query(value = "SELECT * FROM `marital_status` WHERE `marital_status_id`= :maritalStatusId ", nativeQuery = true)
	MaritalStatusModel getMaritalStatusById(@Param("maritalStatusId") int maritalStatusId);
}
