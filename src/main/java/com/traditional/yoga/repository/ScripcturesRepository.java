package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.ScripcturesModel;

@Repository
public interface ScripcturesRepository extends JpaRepository<ScripcturesModel, Integer> {

	@Query(value = "SELECT * FROM `scripctures` WHERE `scripctures_id`= :scripcturesId", nativeQuery = true)
	ScripcturesModel checkscripcturesId(@Param("scripcturesId") int scripcturesId);

//	@Query(value = "SELECT * FROM `scripctures` WHERE `scripctures_id`= :scripcturesId", nativeQuery = true)
//	String getscripcturesId(@Param("scripcturesId") int scripcturesId);
}
