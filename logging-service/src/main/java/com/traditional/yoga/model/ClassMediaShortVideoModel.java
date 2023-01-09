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
@Table(name = "classmedia_shortvideo")
public class ClassMediaShortVideoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "short_video_id")
	private int shortVideoId;

	@OneToOne
	@JoinColumn(name = "courses_id", referencedColumnName = "courses_id")
	private CourseListModel coursesId;

	@OneToOne
	@JoinColumn(name = "praticelibary_id", referencedColumnName = "category_id")
	private LibaryCategoryModel praticeLibaryId;

	@OneToOne
	@JoinColumn(name = "subcategory_id", referencedColumnName = "sub_category_id")
	private SubCategoryPraticeLibaryModel subCategoryId;

	@Column(name = "video_link")
	private String videoLink;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "class_date")
	private String classDate;

	@Column(name = "duration_of_video")
	private String duration;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "update_date")
	private String updatedDate;

	@Column(name = "is_active")
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
