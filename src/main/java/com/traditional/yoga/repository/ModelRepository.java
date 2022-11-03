package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.ModuleModel;

@Repository
public interface ModelRepository extends JpaRepository<ModuleModel, Long> {

	@Query(value = "SELECT * FROM `module` WHERE `module_id`=:moduleId", nativeQuery = true)
	ModuleModel getModuleById(@Param("moduleId") int moduleId);

}
