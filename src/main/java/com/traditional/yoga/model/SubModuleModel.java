package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "submodule")
public class SubModuleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_module_id")
	private int subModuleId;

	@Column(name = "module_id")
	private int moduleId;

	@Column(name = "sub_module_name")
	private String subModuleName;

	public int getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(int subModuleId) {
		this.subModuleId = subModuleId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

}
