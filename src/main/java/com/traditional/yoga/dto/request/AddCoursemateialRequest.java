package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.AddMediaModel;
import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.MaterialCategoryModel;

public class AddCoursemateialRequest {

	private int courseMaterialId;
	private CourseListModel coursesId;
	private String addCategory;
	private String addDescription;
	private MaterialCategoryModel materialCategoryId;
	private AddMediaModel mediaId;
	private String videoLink;
	private String fileUpload;
	private String message;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String isActive;

	public int getCourseMaterialId() {
		return courseMaterialId;
	}

	public void setCourseMaterialId(int courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}

	public CourseListModel getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(CourseListModel coursesId) {
		this.coursesId = coursesId;
	}

	public String getAddCategory() {
		return addCategory;
	}

	public void setAddCategory(String addCategory) {
		this.addCategory = addCategory;
	}

	public String getAddDescription() {
		return addDescription;
	}

	public void setAddDescription(String addDescription) {
		this.addDescription = addDescription;
	}

	public MaterialCategoryModel getMaterialCategoryId() {
		return materialCategoryId;
	}

	public void setMaterialCategoryId(MaterialCategoryModel materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}

	public AddMediaModel getMediaId() {
		return mediaId;
	}

	public void setMediaId(AddMediaModel mediaId) {
		this.mediaId = mediaId;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
