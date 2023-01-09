package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.CreateAlbumModel;

public interface CreateAlbumRepository extends JpaRepository<CreateAlbumModel, Integer> {
	
	@Query(value = "SELECT * FROM `video_album` WHERE `album_id`=:albumId", nativeQuery = true)
	CreateAlbumModel getAlbumById(@Param("albumId") int albumId);
}
