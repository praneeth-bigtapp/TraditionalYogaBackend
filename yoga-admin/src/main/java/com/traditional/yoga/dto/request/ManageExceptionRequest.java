package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.ParametersModel;
import com.traditional.yoga.model.RegistrationModel;

public class ManageExceptionRequest {

	private int exceptionId;
	private RegistrationModel registrationId;
	private ParametersModel performanceId;
	private String exceptionStatus;
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
