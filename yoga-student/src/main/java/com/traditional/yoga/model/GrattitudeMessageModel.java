package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "student_gratitude_message")
public class GrattitudeMessageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private int messageId;

	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "registration_id")
	private RegistrationModel studentId;

	@Column(name = "reflection_live_class")
	private String reflectionLiveClass;

	@Column(name = "reflection_pratice_session")
	private String reflectionPraticeSession;

	@Column(name = "reflection_personal_transformation")
	private String reflectionPersonalTransformation;

	@Column(name = "usage_of_vedic_nutraceutials_products")
	private String vedicNutraceutialsProducts;

	@Column(name = "file_upload")
	private String fileUpload;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private String updatedDate;

	@Column(name = "is_active")
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
