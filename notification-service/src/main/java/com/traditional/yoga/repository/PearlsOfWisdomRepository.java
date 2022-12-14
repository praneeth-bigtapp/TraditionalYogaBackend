package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.PearlsOfWisdomModel;

@Repository
public interface PearlsOfWisdomRepository extends JpaRepository<PearlsOfWisdomModel, Integer> {


	
	
	@Query(value = "SELECT * FROM `pearls_of_wisdom` WHERE `quote_id`=:quoteId", nativeQuery = true)
	PearlsOfWisdomModel getwisdomById(@Param("quoteId") int quoteId);
	
	
	

}
