package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.MasterRegionModel;
@Repository
public interface MasterCountryRepository extends JpaRepository<MasterRegionModel, Integer> {

	@Query(value = "SELECT * FROM `m_region` WHERE `region_id `= :regionId", nativeQuery = true)
	MasterRegionModel getRegionById(@Param("regionId") int regionId);
}

