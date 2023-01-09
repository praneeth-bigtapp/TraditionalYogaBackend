package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_media_files")
public class CourseMediaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_media_id")
	private int courseMediaId;

	@Column(name = "course_id")
	private Integer courseId;

	@Column(name = "catgory_id")
	private int catgoryId;

	@Column(name = "date")
	private String date;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "course_link")
	private String courseLink;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "duration")
	private int duration;

	@Column(name = "course_material_type")
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

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getCatgoryId() {
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
