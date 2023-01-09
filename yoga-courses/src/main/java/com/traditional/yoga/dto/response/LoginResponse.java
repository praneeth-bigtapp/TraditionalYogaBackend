package com.traditional.yoga.dto.response;

import java.util.List;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.RolePermissions;

public class LoginResponse {

	private String userId;
	private int roleId;
	private String userRole;
	private String roleStatus;
	private String userToken;
	private List<RolePermissions> permissions;
	private Response response;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public List<RolePermissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<RolePermissions> permissions) {
		this.permissions = permissions;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}
