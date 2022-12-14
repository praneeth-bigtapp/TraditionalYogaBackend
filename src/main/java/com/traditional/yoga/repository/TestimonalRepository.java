package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.TestimonalsModel;

public interface TestimonalRepository extends JpaRepository<TestimonalsModel, Integer> {
	
	
	@Query(value = "SELECT * FROM `testimonal` WHERE `testimonal_id`=:testimonalId", nativeQuery = true)
	TestimonalsModel getTestmonialsById(@Param("testimonalId") int testimonalId);

	
	@Query(value = "SELECT * FROM `testimonal` WHERE `content`=:content", nativeQuery = true)
	TestimonalsModel getTestmonialsBycontent(@Param("content") String testimonalId);
	
	//Video Link///
	@Query(value = "SELECT * FROM `testimonal` WHERE `Video_link`=:videoLink", nativeQuery = true)
	TestimonalsModel getTestmonialsBylink(@Param("videoLink") String videoLink);
	
	//by name//
	@Query(value = "SELECT * FROM `testimonal` WHERE `Given_by_name`=:givenByName", nativeQuery = true)
	TestimonalsModel getTestmonialsByname(@Param("givenByName") String givenByName);
	
	
	// Description/////
	@Query(value = "SELECT * FROM `testimonal` WHERE `description`=:description", nativeQuery = true)
	TestimonalsModel getTestmonialsBydescription(@Param("description") String description);
}
