package com.traditional.yoga.dto.request;

public class ClassMediaRequest {

	private int classMediaId;
	private int courseId;
	private String date;
	private String typeOfClass;
	private int noOfMediaFiles;

	public int getClassMediaId() {
		return classMediaId;
	}

	public void setClassMediaId(int classMediaId) {
		this.classMediaId = classMediaId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTypeOfClass() {
		return typeOfClass;
	}

	public void setTypeOfClass(String typeOfClass) {
		this.typeOfClass = typeOfClass;
	}

	public int getNoOfMediaFiles() {
		return noOfMediaFiles;
	}

	public void setNoOfMediaFiles(int noOfMediaFiles) {
		this.noOfMediaFiles = noOfMediaFiles;
	}

}
