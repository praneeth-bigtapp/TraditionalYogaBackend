package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.AudioTypeModel;

public interface MasterAudioRepository extends JpaRepository<AudioTypeModel, Integer> {

	@Query(value = "SELECT * FROM `m_audio_type` WHERE `audio_type_id`= :audioType", nativeQuery = true)
	AudioTypeModel getImagesById(@Param("audioType") int audioType);
}
