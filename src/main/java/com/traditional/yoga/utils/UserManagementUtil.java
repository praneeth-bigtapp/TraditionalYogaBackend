package com.traditional.yoga.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traditional.yoga.dto.request.RolePermissionRequest;
import com.traditional.yoga.model.RolePermissionModel;
import com.traditional.yoga.repository.ModelRepository;
import com.traditional.yoga.repository.PermissionRepository;
import com.traditional.yoga.repository.RoleRepository;
import com.traditional.yoga.repository.SubModelRepository;

@Component
public class UserManagementUtil {

	private static final Logger LOG = LoggerFactory.getLogger(UserManagementUtil.class);

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ModelRepository modelRepository;

	@Autowired
	SubModelRepository subModelRepository;

	@Autowired
	PermissionRepository permissionRepository;

	/**
	 * Entity for Role Permission
	 * 
	 * @param roleDto
	 * @param newRole
	 * @return
	 */
	public RolePermissionModel rolePermissionsDtoToEntity(RolePermissionRequest roleDto, RolePermissionModel newRole) {
		newRole.setRolePermissionId(roleDto.getRolePermissionId());
		newRole.setRole(roleRepository.getRoleById(roleDto.getRoleId()));
		newRole.setModule(modelRepository.getModuleById(roleDto.getModuleId()));
		newRole.setSubModule(subModelRepository.getSubModuleById(roleDto.getSubModuleId()));
		newRole.setPermission(permissionRepository.getPermissionById(roleDto.getPermissionId()));
		LOG.info("Role Permission set Sucessfully");
		return newRole;
	}
}
