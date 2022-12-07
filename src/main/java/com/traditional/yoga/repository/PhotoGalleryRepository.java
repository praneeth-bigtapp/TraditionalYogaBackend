package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.PhotoGalleryModel;

@Repository
public interface PhotoGalleryRepository extends JpaRepository<PhotoGalleryModel, Integer> {

	@Query(value = "SELECT * FROM `photo_gallery` WHERE `photo_gallery_id`= :photoGalleryId", nativeQuery = true)
	PhotoGalleryModel getPhotoGallery(@Param("photoGalleryId") int photoGalleryId);
	
	@Query(value = "SELECT * FROM `photo_gallery` WHERE `gallery_name`= :galleryName", nativeQuery = true)
	PhotoGalleryModel getGalleryName(@Param("galleryName") String galleryName);
}
