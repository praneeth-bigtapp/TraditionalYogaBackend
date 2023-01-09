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
@Table(name = "course_profile")
public class CourseProfileModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_profile_id")
	private int courseProfileId;

	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private StudentModel studentId;

	@OneToOne
	@JoinColumn(name = "course_id", referencedColumnName = "courses_id")
	private CourseListModel courseId;

	@Column(name = "admissions_status")
	private String admissionsStatus;

	@Column(name = "completion_status")
	private String completionStatus;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "updated_by")
	private String updateBy;

	@Column(name = "updated_date")
	private String updateDate;

	@Column(name = "delete_flage")
	private String deleteFlage;

	public int getCourseProfileId() {
		return courseProfileId;
	}

	public void setCourseProfileId(int courseProfileId) {
		this.courseProfileId = courseProfileId;
	}

	public StudentModel getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentModel studentId) {
		this.studentId = studentId;
	}

	public CourseListModel getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseListModel courseId) {
		this.courseId = courseId;
	}

	public String getAdmissionsStatus() {
		return admissionsStatus;
	}

	public void setAdmissionsStatus(String admissionsStatus) {
		this.admissionsStatus = admissionsStatus;
	}

	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDeleteFlage() {
		return deleteFlage;
	}

	public void setDeleteFlage(String deleteFlage) {
		this.deleteFlage = deleteFlage;
	}

}
