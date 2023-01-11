package com.traditional.yoga.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_courses")
public class UserCoursesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_courses_id")
	private int userCoursesId;

	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "registration_id")
	private RegistrationModel studentId;

	@OneToOne
	@JoinColumn(name = "course_id", referencedColumnName = "courses_id")
	private CourseListModel coursesId;

	@Column(name = "certification")
	private String certification;
	@Column(name = "certification_alert_status")
	private String certificationAlertStatus;
	@Column(name = "volunteering")
	private String volunteering;
	@Column(name = "motivation_resaon")
	private String motivationReason;
	@Column(name = "volunteering_alert_status")
	private String voluteeringAlertStatus;
	@Column(name = "guru_dakshana")
	private String guruDakshana;
	@Column(name = "inability_resaon")
	private String inablityReson;
	@Column(name = "guru_dakshana_alert_status")
	private String guruDakshnaAlertStatus;
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

	public String getVolunteering() {
		return volunteering;
	}

	public void setVolunteering(String volunteering) {
		this.volunteering = volunteering;
	}

	public String getMotivationReason() {
		return motivationReason;
	}

	public void setMotivationReason(String motivationReason) {
		this.motivationReason = motivationReason;
	}

	public String getVoluteeringAlertStatus() {
		return voluteeringAlertStatus;
	}

	public void setVoluteeringAlertStatus(String voluteeringAlertStatus) {
		this.voluteeringAlertStatus = voluteeringAlertStatus;
	}

	public String getGuruDakshana() {
		return guruDakshana;
	}

	public void setGuruDakshana(String guruDakshana) {
		this.guruDakshana = guruDakshana;
	}

	public String getInablityReson() {
		return inablityReson;
	}

	public void setInablityReson(String inablityReson) {
		this.inablityReson = inablityReson;
	}

	public String getGuruDakshnaAlertStatus() {
		return guruDakshnaAlertStatus;
	}

	public void setGuruDakshnaAlertStatus(String guruDakshnaAlertStatus) {
		this.guruDakshnaAlertStatus = guruDakshnaAlertStatus;
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
