package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.CountryModel;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Integer> {

	
	@Query(value = "SELECT * FROM `m_country` WHERE `country_id`= :countryId", nativeQuery = true)
	CountryModel getCategoryById(@Param("countryId") int countryId);
}
