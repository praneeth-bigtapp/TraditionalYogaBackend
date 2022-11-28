package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class_media")
public class ClassMediaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_media_id")
	private int classMediaId;

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
