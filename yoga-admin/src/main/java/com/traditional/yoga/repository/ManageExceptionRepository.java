package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.ManageExceptionModel;

@Repository
public interface ManageExceptionRepository extends JpaRepository<ManageExceptionModel, Integer> {

	@Query(value = "SELECT * FROM `m_exception` WHERE `m_exception_id`= :exceptionId", nativeQuery = true)
	ManageExceptionModel getManageExceptionById(@Param("exceptionId") int exceptionId);
}
