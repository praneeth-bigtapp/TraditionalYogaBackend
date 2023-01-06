package com.traditional.yoga.dto.request;

import java.util.List;

import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.RegistrationModel;

public class UserCoursesRequest {

	private int userCoursesId;
	private RegistrationModel studentId;
	private List<CourseListModel> coursesId;

	private String certification;
	private String certificationAlertStatus;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String isActive;

	public int getUserCoursesId() {
		return userCoursesId;
	}

	public void setUserCoursesId(int userCoursesId) {
		this.userCoursesId = userCoursesId;
	}

	public RegistrationModel getStudentId() {
		return studentId;
	}

	public void setStudentId(RegistrationModel studentId) {
		this.studentId = studentId;
	}

	public List<CourseListModel> getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(List<CourseListModel> coursesId) {
		this.coursesId = coursesId;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getCertificationAlertStatus() {
		return certificationAlertStatus;
	}

	public void setCertificationAlertStatus(String certificationAlertStatus) {
		this.certificationAlertStatus = certificationAlertStatus;
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
