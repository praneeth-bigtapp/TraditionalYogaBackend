package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.RolePermissionModel;

public interface RolePermissionRepository extends JpaRepository<RolePermissionModel, Integer> {

	@Query(value = "SELECT * FROM `role_permissions` WHERE `role_Id`=:roleId", nativeQuery = true)
	List<RolePermissionModel> getPermissionByroleId(@Param("roleId") int roleId);
	
	@Query(value = "SELECT * FROM rolepermissions rp WHERE rp.role_id = :roleId AND rp.table_id NOT IN (SELECT `table_id` FROM `dma_tables` WHERE `deleted_flag`=1)", nativeQuery = true)
	List<RolePermissionModel> findPermissionsByRoleId(@Param("roleId") int roleId);
}
