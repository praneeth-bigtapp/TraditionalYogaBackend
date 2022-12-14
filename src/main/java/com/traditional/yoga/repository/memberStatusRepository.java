package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.MasterCategoryModel;

public interface memberStatusRepository  extends JpaRepository<MasterCategoryModel ,Integer>{

	@Query(value = "SELECT * FROM `m_member_status` WHERE `status_id`= :statusId", nativeQuery = true)
	MasterCategoryModel getmemeberstatusById(@Param("statusId") int statusId);
}
