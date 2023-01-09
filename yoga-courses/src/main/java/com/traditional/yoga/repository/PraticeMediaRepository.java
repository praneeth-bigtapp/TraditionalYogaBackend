package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.PraticeMediaModel;

public interface PraticeMediaRepository   extends JpaRepository<PraticeMediaModel, Integer> {
	
	@Query(value = "SELECT * FROM `courses_pratice_session_media` WHERE `media_id`= :mediaId", nativeQuery = true)
	PraticeMediaModel getmediaById(@Param("mediaId") int mediaId);

}
