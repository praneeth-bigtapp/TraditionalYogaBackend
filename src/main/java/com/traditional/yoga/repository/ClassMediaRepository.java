package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.ClassMediaModel;

@Repository
public interface ClassMediaRepository extends JpaRepository<ClassMediaModel, Integer> {

	@Query(value = "SELECT * FROM `class_media` WHERE `class_media_id`= :classMediaId", nativeQuery = true)
	ClassMediaModel getClassMediaById(@Param("classMediaId") int classMediaId);
}
