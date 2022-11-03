package com.traditional.yoga.dto;

import java.util.List;

public class RolePermissions {

	private String moduleName;
	private List<SubModules> subModules;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<SubModules> getSubModules() {
		return subModules;
	}

	public void setSubModules(List<SubModules> subModules) {
		this.subModules = subModules;
	}

}
