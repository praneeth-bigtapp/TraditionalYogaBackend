package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registered_student")
public class RegisteredStudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registration_student_id")
	private int registrationStudentId;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "registration_id")
	private RegistrationModel studentId;

	@Column(name = "courses_id")
	private int coursesId;

	@ManyToOne
	@JoinColumn(name = "mentor_id", referencedColumnName = "registration_id")
	private RegistrationModel mentorId;

	@ManyToOne
	@JoinColumn(name = "chief_mentor_id", referencedColumnName = "registration_id")
	private RegistrationModel chiefMentorId;

	public int getRegistrationStudentId() {
		return registrationStudentId;
	}

	public void setRegistrationStudentId(int registrationStudentId) {
		this.registrationStudentId = registrationStudentId;
	}

	public RegistrationModel getStudentId() {
		return studentId;
	}

	public void setStudentId(RegistrationModel studentId) {
		this.studentId = studentId;
	}

	public int getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(int coursesId) {
		this.coursesId = coursesId;
	}

	public RegistrationModel getMentorId() {
		return mentorId;
	}

	public void setMentorId(RegistrationModel mentorId) {
		this.mentorId = mentorId;
	}

	public RegistrationModel getChiefMentorId() {
		return chiefMentorId;
	}

	public void setChiefMentorId(RegistrationModel chiefMentorId) {
		this.chiefMentorId = chiefMentorId;
	}

}
