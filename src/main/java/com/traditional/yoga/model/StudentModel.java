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
@Table(name = "student_details")
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "role_id")
	private int roleId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private CourseListModel courseId;

	@Column(name = "name")
	private String name;

	@Column(name = "student_category")
	private String studentCategory;

	@Column(name = "profession_id")
	private Integer professionId;

	@Column(name = "qulification_id")
	private Integer qulificationId;

	@Column(name = "gender_id")
	private Integer genderId;

	@Column(name = "mentor_id")
	private String mentorId;

	@Column(name = "mentor_status")
	private String mentorStatus;

	@Column(name = "mentor_region")
	private String mentorRegion;

	@Column(name = "chief_mentor_id")
	private String chiefMentorId;

	@Column(name = "age")
	private Integer age;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "address")
	private String address;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "student_register_date")
	private String regesiterDate;

	@Column(name = "registed_ip_address")
	private String registedIpAddress;

	@Column(name = "is_active")
	private String active;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public CourseListModel getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseListModel courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentCategory() {
		return studentCategory;
	}

	public void setStudentCategory(String studentCategory) {
		this.studentCategory = studentCategory;
	}

	public Integer getProfessionId() {
		return professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public Integer getQulificationId() {
		return qulificationId;
	}

	public void setQulificationId(Integer qulificationId) {
		this.qulificationId = qulificationId;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public String getMentorId() {
		return mentorId;
	}

	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}

	public String getMentorStatus() {
		return mentorStatus;
	}

	public void setMentorStatus(String mentorStatus) {
		this.mentorStatus = mentorStatus;
	}

	public String getMentorRegion() {
		return mentorRegion;
	}

	public void setMentorRegion(String mentorRegion) {
		this.mentorRegion = mentorRegion;
	}

	public String getChiefMentorId() {
		return chiefMentorId;
	}

	public void setChiefMentorId(String chiefMentorId) {
		this.chiefMentorId = chiefMentorId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRegesiterDate() {
		return regesiterDate;
	}

	public void setRegesiterDate(String regesiterDate) {
		this.regesiterDate = regesiterDate;
	}

	public String getRegistedIpAddress() {
		return registedIpAddress;
	}

	public void setRegistedIpAddress(String registedIpAddress) {
		this.registedIpAddress = registedIpAddress;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
