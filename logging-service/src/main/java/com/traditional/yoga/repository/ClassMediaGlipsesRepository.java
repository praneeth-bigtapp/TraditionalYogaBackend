package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.ClassMediaGlimpsesModel;

public interface ClassMediaGlipsesRepository  extends JpaRepository<ClassMediaGlimpsesModel, Integer>{

	@Query(value = "SELECT * FROM `classmedia_glimpses`where `glimpses_id`= :glimpsesId",nativeQuery = true)
	ClassMediaGlimpsesModel getGlimpsesById(@Param("glimpsesId") int glimpsesId);
}
