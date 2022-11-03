package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.traditional.yoga.model.RolePermissionModel;

public interface RolePermissionRepository extends JpaRepository<RolePermissionModel, Long> {

	@Query(value = "SELECT * FROM `role_permissions` WHERE `role_Id`=:roleId", nativeQuery = true)
	List<RolePermissionModel> getPermissionByroleId(@Param("roleId") int roleId);
}
