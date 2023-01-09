package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parameters")
public class ParametersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parameters_id")
	private int parametersId;

	@Column(name = "parameters_name")
	private String parametersName;

	@Column(name = "section")
	private int section;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_date")
	private String updatedDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "delete_flage")
	private int deleteFlage;

	public int getParametersId() {
		return parametersId;
	}

	public void setParametersId(int parametersId) {
		this.parametersId = parametersId;
	}

	public String getParametersName() {
		return parametersName;
	}

	public void setParametersName(String parametersName) {
		this.parametersName = parametersName;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getDeleteFlage() {
		return deleteFlage;
	}

	public void setDeleteFlage(int deleteFlage) {
		this.deleteFlage = deleteFlage;
	}

}
