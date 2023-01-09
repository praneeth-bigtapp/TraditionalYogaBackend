package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.AudioManagementModel;

@Repository
public interface AudioManagementRepository extends JpaRepository<AudioManagementModel, Integer> {

	@Query(value = "SELECT * FROM `audio_management` WHERE `audio_management_id`= :id", nativeQuery = true)
	AudioManagementModel getAudioById(@Param("id") int id);
}
