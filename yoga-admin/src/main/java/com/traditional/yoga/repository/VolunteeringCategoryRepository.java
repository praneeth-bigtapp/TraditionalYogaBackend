package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.VolunteeringCategoryModel;

@Repository
public interface VolunteeringCategoryRepository extends JpaRepository<VolunteeringCategoryModel, Integer> {

	@Query(value = "SELECT * FROM `m_volunteering_category` WHERE `Volunteering_category_id`= :volunteeringCategoryId", nativeQuery = true)
	VolunteeringCategoryModel getbannerbyId(@Param("volunteeringCategoryId") int volunteeringCategoryId);

}
