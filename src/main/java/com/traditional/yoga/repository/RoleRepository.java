package com.traditional.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer> {

	@Query(value = "SELECT * FROM `role` WHERE `role_Id`=:roleId", nativeQuery = true)
	RoleModel getRoleById(@Param("roleId") int roleId);

	@Query(value = "SELECT * FROM `role` WHERE `role_name`=:roleName", nativeQuery = true)
	RoleModel getRoleByName(@Param("roleName") String roleName);
	
	

}
