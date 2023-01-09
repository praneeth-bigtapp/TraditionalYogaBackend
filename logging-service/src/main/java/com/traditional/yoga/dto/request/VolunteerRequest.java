package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.VolunteeringCategoryModel;

public class VolunteerRequest {

	private int volunteerId;
	private int studentId;
	private VolunteeringCategoryModel categoryName;
	private CourseListModel courseId;
	private String startDate;
	private String endDate;
	private String servedAs;
	private int noOfMembers;

	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public VolunteeringCategoryModel getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(VolunteeringCategoryModel categoryName) {
		this.categoryName = categoryName;
	}

	public CourseListModel getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseListModel courseId) {
		this.courseId = courseId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getServedAs() {
		return servedAs;
	}

	public void setServedAs(String servedAs) {
		this.servedAs = servedAs;
	}

	public int getNoOfMembers() {
		return noOfMembers;
	}

	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}

}
