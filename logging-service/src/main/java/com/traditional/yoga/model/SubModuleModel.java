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

@Entity
@Table(name = "submodule")
public class SubModuleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_module_id")
	private int subModuleId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "module_id", referencedColumnName = "module_id")
	private ModuleModel moduleId;

	@Column(name = "sub_module_name")
	private String subModuleName;
	
	@Column(name = "routing_link")
	private String routingLink;
	
	@Column(name = "icon")
	private String icon;

	@Column(name = "status")
	private String status;

	public int getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(int subModuleId) {
		this.subModuleId = subModuleId;
	}

	public ModuleModel getModuleId() {
		return moduleId;
	}

	public void setModuleId(ModuleModel moduleId) {
		this.moduleId = moduleId;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public String getRoutingLink() {
		return routingLink;
	}

	public void setRoutingLink(String routingLink) {
		this.routingLink = routingLink;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
