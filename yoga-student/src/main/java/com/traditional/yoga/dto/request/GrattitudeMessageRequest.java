package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.RegistrationModel;

public class GrattitudeMessageRequest {

	private int messageId;
	private RegistrationModel studentId;
	private String reflectionLiveClass;
	private String reflectionPraticeSession;
	private String reflectionPersonalTransformation;
	private String vedicNutraceutialsProducts;
	private String fileUpload;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String isActive;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public RegistrationModel getStudentId() {
		return studentId;
	}

	public void setStudentId(RegistrationModel studentId) {
		this.studentId = studentId;
	}

	public String getReflectionLiveClass() {
		return reflectionLiveClass;
	}

	public void setReflectionLiveClass(String reflectionLiveClass) {
		this.reflectionLiveClass = reflectionLiveClass;
	}

	public String getReflectionPraticeSession() {
		return reflectionPraticeSession;
	}

	public void setReflectionPraticeSession(String reflectionPraticeSession) {
		this.reflectionPraticeSession = reflectionPraticeSession;
	}

	public String getReflectionPersonalTransformation() {
		return reflectionPersonalTransformation;
	}

	public void setReflectionPersonalTransformation(String reflectionPersonalTransformation) {
		this.reflectionPersonalTransformation = reflectionPersonalTransformation;
	}

	public String getVedicNutraceutialsProducts() {
		return vedicNutraceutialsProducts;
	}

	public void setVedicNutraceutialsProducts(String vedicNutraceutialsProducts) {
		this.vedicNutraceutialsProducts = vedicNutraceutialsProducts;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
