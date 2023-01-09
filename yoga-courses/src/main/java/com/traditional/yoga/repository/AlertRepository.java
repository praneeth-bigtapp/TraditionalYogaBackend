package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.AlertModel;

@Repository
public interface AlertRepository  extends JpaRepository<AlertModel, Integer> {

	@Query(value = "SELECT * FROM `alert` WHERE `alert_id`= :alertId",nativeQuery = true)
	AlertModel getalertById(@Param("alertId") int alertId);
	
	@Query(value = "SELECT * FROM `alert` WHERE `category_id`= :categoryId",nativeQuery = true)
	AlertModel getalertBycategoryId(@Param("categoryId") String categoryId);
	
	
	@Query(value = "SELECT * FROM `alert` WHERE `alert_description`= :alertDescription",nativeQuery = true)
	AlertModel getalertBydescription(@Param("alertDescription") String alertDescription);
	
	@Query(value = "SELECT * FROM `alert` WHERE `start_date`= :startDate",nativeQuery = true)
	AlertModel getalertBystartdate(@Param("startDate") String startDate);
	
	@Query(value = "SELECT * FROM `alert` WHERE `end_date`= :endDate",nativeQuery = true)
	AlertModel getalertByenddate(@Param("endDate") String endDate);
}


