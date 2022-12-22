package com.traditional.yoga.dto.response;

import com.traditional.yoga.model.CourseModel;

public class StudentProfileResponse {

	private int studentId;
	private String name;
	private String studentCategory;
	private String role;
	private String profession;
	private String qualification;
	private String gender;
	private int age;
	private String mobile;
	private String address;
	private String emailId;
	private String regesiterDate;
	private String registedIpAddress;
	private String active;
	private CourseModel course;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public CourseModel getCourse() {
		return course;
	}

	public void setCourse(CourseModel course) {
		this.course = course;
	}

}
