package com.traditional.yoga.dto.request;

public class CourseMediaRequest {

	private int courseMediaId;
	private int courseId;
	private int catgoryId;
	private String date;
	private String fileName;
	private String courseLink;
	private String title;
	private String description;
	private int duration;
	private int courseMaterialType;

	public int getCourseMediaId() {
		return courseMediaId;
	}

	public void setCourseMediaId(int courseMediaId) {
		this.courseMediaId = courseMediaId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCatgoryId() {
		return catgoryId;
	}

	public void setCatgoryId(int catgoryId) {
		this.catgoryId = catgoryId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCourseLink() {
		return courseLink;
	}

	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCourseMaterialType() {
		return courseMaterialType;
	}

	public void setCourseMaterialType(int courseMaterialType) {
		this.courseMaterialType = courseMaterialType;
	}

}
