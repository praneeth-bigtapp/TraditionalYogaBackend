package com.traditional.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.RolePermissionModel;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionModel, Integer> {

	@Query(value = "SELECT * FROM `role_permissions` WHERE `role_Id`=:roleId", nativeQuery = true)
	List<RolePermissionModel> getPermissionByroleId(@Param("roleId") int roleId);
	
}
