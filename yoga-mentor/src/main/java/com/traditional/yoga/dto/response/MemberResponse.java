package com.traditional.yoga.dto.response;

import java.util.List;

import com.traditional.yoga.model.StudentModel;

public class MemberResponse {

	private int userApplied;
	private int userMapped;
	private List<StudentModel> students;

	public int getUserApplied() {
		return userApplied;
	}

	public void setUserApplied(int userApplied) {
		this.userApplied = userApplied;
	}

	public int getUserMapped() {
		return userMapped;
	}

	public void setUserMapped(int userMapped) {
		this.userMapped = userMapped;
	}

	public List<StudentModel> getStudents() {
		return students;
	}

	public void setStudents(List<StudentModel> students) {
		this.students = students;
	}

}
