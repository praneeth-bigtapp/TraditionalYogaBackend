package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.LibaryCategoryModel;
import com.traditional.yoga.model.SubCategoryPraticeLibaryModel;

public class ClassMediaShortVideoRequest {

	private int shortVideoId;
	private CourseListModel coursesId;
	private LibaryCategoryModel praticeLibaryId;
	private SubCategoryPraticeLibaryModel subCategoryId;
	private String videoLink;
	private String title;
	private String description;
	private String classDate;
	private String duration;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String isActive;

	public int getShortVideoId() {
		return shortVideoId;
	}

	public void setShortVideoId(int shortVideoId) {
		this.shortVideoId = shortVideoId;
	}

	public CourseListModel getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(CourseListModel coursesId) {
		this.coursesId = coursesId;
	}

	public LibaryCategoryModel getPraticeLibaryId() {
		return praticeLibaryId;
	}

	public void setPraticeLibaryId(LibaryCategoryModel praticeLibaryId) {
		this.praticeLibaryId = praticeLibaryId;
	}

	public SubCategoryPraticeLibaryModel getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(SubCategoryPraticeLibaryModel subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
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

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
