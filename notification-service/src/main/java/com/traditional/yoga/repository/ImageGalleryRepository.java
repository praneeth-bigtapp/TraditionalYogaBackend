package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.ImageGalleryModel;

@Repository
public interface ImageGalleryRepository extends JpaRepository<ImageGalleryModel, Integer> {

	@Query(value = "SELECT * FROM `image_gallery` WHERE `image_id`= :imageId", nativeQuery = true)
	List<ImageGalleryModel> getImagesById(@Param("imageId") int imageId);
}
