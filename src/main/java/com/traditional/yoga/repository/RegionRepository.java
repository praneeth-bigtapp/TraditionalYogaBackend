package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.RegionModel;

public interface RegionRepository extends JpaRepository<RegionModel, Integer> {
	
	@Query(value = "SELECT * FROM `region` WHERE `region_id`=:regionId", nativeQuery = true)
	RegionModel getRegionById(@Param("regionId") int regionId);

}
