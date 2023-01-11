package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.GrattitudeMessageModel;

public interface GrattittudeMessageRepository extends JpaRepository<GrattitudeMessageModel, Integer>{

	@Query(value = "SELECT * FROM `student_gratitude_message`where `message_id`= :messageId",nativeQuery = true)
	GrattitudeMessageModel getMessagebyId(@Param("messageId") int messageId);
}
