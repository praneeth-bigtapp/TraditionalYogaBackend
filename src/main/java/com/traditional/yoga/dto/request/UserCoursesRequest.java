package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.RegistrationModel;

public class UserCoursesRequest {

	private int userCoursesId;
	private RegistrationModel studentId;
	private CourseListModel coursesId;
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

	public CourseListModel getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(CourseListModel coursesId) {
		this.coursesId = coursesId;
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
