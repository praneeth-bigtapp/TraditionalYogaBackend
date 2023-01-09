package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.RegistrationModel;

public class CertificationAlertRequest {

	private RegistrationModel studentId;
	private CourseListModel coursesId;
	private String certification;
	private String certificationAlertStatus;

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

}
