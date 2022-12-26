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
@Table(name = "courses_pratice_session_media")
public class PraticeMediaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "media_id")
	private int mediaId;

	@OneToOne
	@JoinColumn(name = "courses_id", referencedColumnName = "courses_id")
	private CourseListModel courseId;

	@Column(name = "pratice_date")
	private String praticeDate;

	@Column(name = "pratice_time")
	private String praticeTime;

	@Column(name = "video_link")
	private String videoLink;

	@Column(name = "video_title")
	private String videoTitle;

	@Column(name = "video_duration")
	private String durationVideo;

	@Column(name = "meta_keyword")
	private String metaKeyword;

	@Column(name = "file_upload")
	private String fileUpload;

	@Column(name = "description")
	private String description;

	@Column(name = "instruction")
	private String instruction;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "update_by")
	private String updateBy;

	@Column(name = "update_date")
	private String updateDate;

	@Column(name = "is_active")
	private String isActive;

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public CourseListModel getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseListModel courseId) {
		this.courseId = courseId;
	}

	public String getPraticeDate() {
		return praticeDate;
	}

	public void setPraticeDate(String praticeDate) {
		this.praticeDate = praticeDate;
	}

	public String getPraticeTime() {
		return praticeTime;
	}

	public void setPraticeTime(String praticeTime) {
		this.praticeTime = praticeTime;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getDurationVideo() {
		return durationVideo;
	}

	public void setDurationVideo(String durationVideo) {
		this.durationVideo = durationVideo;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	
	

}
