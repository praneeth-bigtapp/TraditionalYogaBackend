package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_media_category")
public class CourseMediaCategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_media_category_id")
	private int courseMediaCategoryId;

	@Column(name = "category_name")
	private String categoryName;

	public int getCourseMediaCategoryId() {
		return courseMediaCategoryId;
	}

	public void setCourseMediaCategoryId(int courseMediaCategoryId) {
		this.courseMediaCategoryId = courseMediaCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
