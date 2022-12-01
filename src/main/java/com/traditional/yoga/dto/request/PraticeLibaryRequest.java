package com.traditional.yoga.dto.request;

public class PraticeLibaryRequest {

	private int praticeLibaryId;
	private int categoryId;
	private String videoLink;
	private String duration;
	private String title;
	private String message;
	private String metaKeyword;

	public int getPraticeLibaryId() {
		return praticeLibaryId;
	}

	public void setPraticeLibaryId(int praticeLibaryId) {
		this.praticeLibaryId = praticeLibaryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

}
