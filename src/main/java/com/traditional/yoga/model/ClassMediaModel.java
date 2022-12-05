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
@Table(name = "class_media")
public class ClassMediaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_media_id")
	private int classMediaId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private CourseModel courseId;

	@Column(name = "date")
	private String date;

	@Column(name = "type_of_class")
	private String typeOfClass;

	@Column(name = "no_of_media_files")
	private int noOfMediaFiles;

	public int getClassMediaId() {
		return classMediaId;
	}

	public void setClassMediaId(int classMediaId) {
		this.classMediaId = classMediaId;
	}

	public CourseModel getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseModel courseId) {
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
