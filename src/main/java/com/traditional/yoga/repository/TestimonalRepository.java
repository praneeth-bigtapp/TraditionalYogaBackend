package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.TestimonalsModel;

public interface TestimonalRepository extends JpaRepository<TestimonalsModel, Integer> {
	
	
	@Query(value = "SELECT * FROM `testimonal` WHERE `testimonal_id`=:testimonalId", nativeQuery = true)
	TestimonalsModel getTestmonialsById(@Param("testimonalId") int testimonalId);

}
