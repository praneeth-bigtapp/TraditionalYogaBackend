package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.AddMeidaModel;

public interface MediaRepository extends JpaRepository<AddMeidaModel, Integer> {
	
	@Query(value = "SELECT * FROM `material_media` WHERE `media_id`= :mediaId",nativeQuery = true)
	AddMeidaModel getbannerbyId(@Param("mediaId") int mediaId);

}
