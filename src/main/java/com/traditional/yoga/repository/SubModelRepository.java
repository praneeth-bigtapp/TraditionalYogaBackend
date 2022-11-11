package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.SubModuleModel;

@Repository
public interface SubModelRepository extends JpaRepository<SubModuleModel, Integer> {

	@Query(value = "SELECT * FROM `submodule` WHERE `sub_module_id`=:subModuleId", nativeQuery = true)
	SubModuleModel getSubModuleById(@Param("subModuleId") int subModuleId);
	
	@Query(value = "SELECT * FROM `submodule` WHERE `sub_module_name`=:subModuleName", nativeQuery = true)
	SubModuleModel getSubModuleByName(@Param("subModuleName") String subModuleName);
}
