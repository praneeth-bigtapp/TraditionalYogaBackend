package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.AudioCategoryLibaryModel;

@Repository
public interface AudioCategoryLibaryRepository extends JpaRepository<AudioCategoryLibaryModel, Integer>  {

	@Query(value = "SELECT * FROM `course_media_practice` WHERE `audio_category_id`= :audioCategoryId", nativeQuery = true)
	AudioCategoryLibaryModel getAudioCategoryById(@Param("audioCategoryId") int audioCategoryId);
}
