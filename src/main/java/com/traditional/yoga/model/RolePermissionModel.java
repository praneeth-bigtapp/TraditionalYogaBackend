package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_permissions")
public class RolePermissionModel {

	@Id
	@Column(name = "role_permission_id")
	private int rolePermissionId;

	@Column(name = "role_id")
	private int roleId;

	@Column(name = "module_id")
	private int moduleId;

	@Column(name = "sub_module_id")
	private int subModuleId;

	@Column(name = "permission_id")
	private int permissionId;

	public int getRolePermissionId() {
		return rolePermissionId;
	}

	public void setRolePermissionId(int rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(int subModuleId) {
		this.subModuleId = subModuleId;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

}
