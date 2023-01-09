package com.traditional.yoga.dto.request;

public class CourseMediaPracticeRequest {

	private int id;
	private String uploadMediaFile;
	private String videoLink;
	private String title;
	private String description;
	private int duration;
	private String metaKeyword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUploadMediaFile() {
		return uploadMediaFile;
	}

	public void setUploadMediaFile(String uploadMediaFile) {
		this.uploadMediaFile = uploadMediaFile;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

}
