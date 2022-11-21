package com.traditional.yoga.dto;

import java.util.List;

public class RolePermissions {

	private String moduleName;
	private List<SubModulesScreen> subModules;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<SubModulesScreen> getSubModules() {
		return subModules;
	}

	public void setSubModules(List<SubModulesScreen> subModules) {
		this.subModules = subModules;
	}

}
