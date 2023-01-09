package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.PraticeImageModel;

public interface PraticeImageRepository extends JpaRepository<PraticeImageModel, Integer> {

	@Query(value = "SELECT * FROM `courses_pratice_image_session` WHERE `image_id`= :imageId", nativeQuery = true)
	PraticeImageModel getimageById(@Param("imageId") int imageId);

}
