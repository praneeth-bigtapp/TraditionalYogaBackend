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
@Table(name = "volunteer")
public class VolunteerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "volunteer_id")
	private int volunteerId;

	@Column(name = "student_id")
	private int studentId;

	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "Volunteering_category_id")
	private VolunteeringCategoryModel categoryName;

	@OneToOne
	@JoinColumn(name = "course_id", referencedColumnName = "courses_id")
	private CourseListModel courseId;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "served_as")
	private String servedAs;

	@Column(name = "No_of_members")
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
