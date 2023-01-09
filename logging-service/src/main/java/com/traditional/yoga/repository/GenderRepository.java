package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.GenderModel;

@Repository
public interface GenderRepository extends JpaRepository<GenderModel, Integer> {

	@Query(value = "SELECT * FROM `gender` WHERE `gender_id`= :genderId", nativeQuery = true)
	GenderModel getGenderById(@Param("genderId") int genderId);
}
