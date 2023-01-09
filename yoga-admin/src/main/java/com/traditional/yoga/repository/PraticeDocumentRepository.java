package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.PraticeDocumentModel;

public interface PraticeDocumentRepository extends JpaRepository<PraticeDocumentModel, Integer> {

	@Query(value = "SELECT * FROM `courses_pratice_document_session` WHERE `documnet_id`= :documentId", nativeQuery = true)
	PraticeDocumentModel getdocumentById(@Param("documentId") int documentId);
}
