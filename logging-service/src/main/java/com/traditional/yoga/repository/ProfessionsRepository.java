package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.ProfessionsModel;

@Repository
public interface ProfessionsRepository extends JpaRepository<ProfessionsModel, Integer> {

	@Query(value = "SELECT * FROM `professions` WHERE `profession_id`= :professionId", nativeQuery = true)
	ProfessionsModel getProfessionsById(@Param("professionId") int professionId);
}
