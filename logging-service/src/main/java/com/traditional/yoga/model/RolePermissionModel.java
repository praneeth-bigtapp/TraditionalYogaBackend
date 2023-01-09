package com.traditional.yoga.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author bigtapp
 *
 */
@Entity
@Table(name = "role_permissions")
public class RolePermissionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_permission_id")
	private int rolePermissionId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private RoleModel role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "module_id", referencedColumnName = "module_id")
	private ModuleModel module;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sub_module_id", referencedColumnName = "sub_module_id")
	private SubModuleModel subModule;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
	private PermissionModel permission;

	public int getRolePermissionId() {
		return rolePermissionId;
	}

	public void setRolePermissionId(int rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public ModuleModel getModule() {
		return module;
	}

	public void setModule(ModuleModel module) {
		this.module = module;
	}

	public SubModuleModel getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModuleModel subModule) {
		this.subModule = subModule;
	}

	public PermissionModel getPermission() {
		return permission;
	}

	public void setPermission(PermissionModel permission) {
		this.permission = permission;
	}

}
