package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.CourseListModel;

public class PraticeMediaRequest {

	private int mediaId;

	private CourseListModel courseId;
	private String praticeDate;
	private String praticeTime;
	private String videoLink;
	private String videoTitle;
	private String durationVideo;
	private String metaKeyword;
	private String fileUpload;
	private String description;
	private String instruction;
	private String createdBy;
	private String createdDate;
	private String updateBy;
	private String updateDate;
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
