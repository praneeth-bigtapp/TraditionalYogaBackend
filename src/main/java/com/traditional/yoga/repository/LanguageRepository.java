package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.LanguageModel;

public interface LanguageRepository extends JpaRepository<LanguageModel, Integer> {

	@Query(value = "SELECT * FROM `m_language` WHERE `language_id`= :languageId", nativeQuery = true)
	LanguageModel getlanguageById(@Param("languageId") int genderId);

}
