package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "m_exception")
public class ManageExceptionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "m_exception_id")
	private int exceptionId;

	@ManyToOne
	@JoinColumn(name = "registration_id", referencedColumnName = "registration_id")
	private RegistrationModel registrationId;

	@ManyToOne
	@JoinColumn(name = "performance_id", referencedColumnName = "performance_id")
	private ParametersModel performanceId;

	@Column(name = "exception_status")
	private String exceptionStatus;

	@Column(name = "exception_Desc")
	private String exceptionDesc;

	public int getExceptionId() {
		return exceptionId;
	}

	public void setExceptionId(int exceptionId) {
		this.exceptionId = exceptionId;
	}

	public RegistrationModel getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(RegistrationModel registrationId) {
		this.registrationId = registrationId;
	}

	public ParametersModel getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(ParametersModel performanceId) {
		this.performanceId = performanceId;
	}

	public String getExceptionStatus() {
		return exceptionStatus;
	}

	public void setExceptionStatus(String exceptionStatus) {
		this.exceptionStatus = exceptionStatus;
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

	public void setExceptionDesc(String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}

}
