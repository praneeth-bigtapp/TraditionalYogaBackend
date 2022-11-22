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
}


