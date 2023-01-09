package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.AboutUsModel;

@Repository
public interface AboutUsRepository extends JpaRepository<AboutUsModel, Integer> {

	@Query(value = "SELECT * FROM `m_hear_about_us` WHERE `about_us_id`= :aboutUsId", nativeQuery = true)
	AboutUsModel getaboutusById(@Param("aboutUsId") int aboutUsId);
}
