package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.VideoAlbumModel;

public interface VideoAlbumReposiotry extends JpaRepository<VideoAlbumModel ,Integer> {

	
	@Query(value = "SELECT * FROM `album_videos` WHERE `videos_id`= :videoId", nativeQuery = true)
	VideoAlbumModel getvideoById(@Param("videoId") int videoId);
}
