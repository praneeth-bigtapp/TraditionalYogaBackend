package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.ClassMediaShortVideoModel;

public interface ClassMediaShortVideoRepository extends  JpaRepository<ClassMediaShortVideoModel, Integer> {
	
	@Query(value = "SELECT * FROM `classmedia_shortvideo` WHERE `short_video_id`= :shortVideoId", nativeQuery = true)
	ClassMediaShortVideoModel getshortVideobyId(@Param("shortVideoId") int shortVideoId);

}
