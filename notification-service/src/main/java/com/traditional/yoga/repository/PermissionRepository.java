package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.PermissionModel;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionModel, Integer> {

	@Query(value = "SELECT * FROM `permission` WHERE `permission_id`=:permissionId", nativeQuery = true)
	PermissionModel getPermissionById(@Param("permissionId") int permissionId);

}
