package com.traditional.yoga.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traditional.yoga.model.RolePermissionModel;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionModel, Long> {

	@Query(value = "SELECT * FROM `role_permissions` WHERE `role_Id`= :roleId AND `permission_id`<>6", nativeQuery = true)
	List<RolePermissionModel> getPermissionByroleId(@Param("roleId") int roleId);
	
	@Query(value = "SELECT * FROM `role_permissions` WHERE `role_Id`= :roleId ", nativeQuery = true)
	List<RolePermissionModel> getAllByroleId(@Param("roleId") int roleId);

	@Query(value = "SELECT COUNT(*) FROM `role_permissions` WHERE `role_Id`= :roleId AND `sub_module_id` = :subModuleId AND permission_id<>6", nativeQuery = true)
	int findCountOfSubModulesPermissions(@Param("roleId") int roleId, @Param("subModuleId") int subModuleId);
	
//	@Transactional
//	@Modifying
//	@Query("DELETE FROM role_permissions WHERE role_id = :roleId")
//	void deleteByRoleId(@Param("roleId") int roleId);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM role_permissions WHERE role_id = ?1 ", nativeQuery = true)
	void deleteByRoleId(int roleId);

}
