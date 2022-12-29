package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "add_course_materials")
public class AddCoursesMaterialModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_material_id")
	private int courseMaterialId;

	@OneToOne
	@JoinColumn(name = "courses_id", referencedColumnName = "courses_id")
	private CourseListModel coursesId;

	@OneToOne
	@JoinColumn(name = "materal_category_id", referencedColumnName = "material_category_id")
	private MaterialCategoryModel materialCategoryId;

	@OneToOne
	@JoinColumn(name = "media_id", referencedColumnName = "media_id")
	private AddMediaModel mediaId;

	@Column(name = "course_material_titile")
	private String courseMaterialTitle;

	@Column(name = "Video_link")
	private String videoLink;

	@Column(name = "file_upload")
	private String fileUpload;

	@Column(name = "message")
	private String message;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private String updatedDate;

	@Column(name = "is_active")
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

	public String getCourseMaterialTitle() {
		return courseMaterialTitle;
	}

	public void setCourseMaterialTitle(String courseMaterialTitle) {
		this.courseMaterialTitle = courseMaterialTitle;
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
