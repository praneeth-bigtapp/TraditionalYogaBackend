package com.traditional.yoga.utils;

import org.springframework.stereotype.Component;

import com.traditional.yoga.dto.request.RolePermissionRequest;
import com.traditional.yoga.model.RolePermissionModel;

@Component
public class UserManagementUtil {

	/**
	 * Entity for Role Permission
	 * 
	 * @param roleDto
	 * @param newRole
	 * @return
	 */
	public RolePermissionModel rolePermissionsDtoToEntity(RolePermissionRequest roleDto, RolePermissionModel newRole) {
		newRole.setRolePermissionId(roleDto.getRolePermissionId());
		newRole.setRoleId(roleDto.getRoleId());
		newRole.setModuleId(roleDto.getModuleId());
		newRole.setSubModuleId(roleDto.getSubModuleId());
		newRole.setPermissionId(roleDto.getPermissionId());
		return newRole;
	}
}
