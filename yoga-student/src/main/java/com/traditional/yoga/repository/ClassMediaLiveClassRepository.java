package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.ClassMediaLiveClassModel;

public interface ClassMediaLiveClassRepository extends JpaRepository<ClassMediaLiveClassModel, Integer>{

	@Query(value = "SELECT * FROM `classmedia_liveclass`where `liveclass_id`= :liveClassId",nativeQuery = true)
	ClassMediaLiveClassModel getClassMediaLiveclass(@Param("liveClassId") int liveClassId);
}
