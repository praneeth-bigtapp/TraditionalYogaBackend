package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "name")
	private String name;

	@Column(name = "profession_id")
	private int professionId;

	@Column(name = "qulification_id")
	private int qulificationId;

	@Column(name = "gender_id")
	private int genderId;

	@Column(name = "age")
	private int age;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "address")
	private String address;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "regesiter_date")
	private String regesiterDate;

	@Column(name = "registed_ip_address")
	private String registedIpAddress;

	@Column(name = "is_active")
	private String active;

	@Column(name = "course_name")
	private String courseName;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfessionId() {
		return professionId;
	}

	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}

	public int getQulificationId() {
		return qulificationId;
	}

	public void setQulificationId(int qulificationId) {
		this.qulificationId = qulificationId;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
