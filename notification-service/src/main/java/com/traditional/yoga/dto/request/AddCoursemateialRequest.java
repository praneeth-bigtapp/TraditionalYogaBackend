package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.AddMediaModel;
import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.MaterialCategoryModel;

public class AddCoursemateialRequest {

	private int courseMaterialId;
	private CourseListModel coursesId;
	private MaterialCategoryModel materialCategoryId;
	private AddMediaModel mediaId;
	private String courseMaterialTitle;
	private String videoLink;
	private String fileUpload;
	private String message;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String isActive;
	private String otherCategoryName;

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

	public String getCourseMaterialTitle() {
		return courseMaterialTitle;
	}

	public void setCourseMaterialTitle(String courseMaterialTitle) {
		this.courseMaterialTitle = courseMaterialTitle;
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

	public String getOtherCategoryName() {
		return otherCategoryName;
	}

	public void setOtherCategoryName(String otherCategoryName) {
		this.otherCategoryName = otherCategoryName;
	}

}
