package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.StatesModel;

@Repository
public interface StatesRepository extends JpaRepository<StatesModel, Integer> {

	@Query(value = "SELECT * FROM `marital_status` WHERE `marital_status_id`= :maritalStatusId ", nativeQuery = true)
	StatesModel getMaritalStatusById(@Param("maritalStatusId") int maritalStatusId);
}
