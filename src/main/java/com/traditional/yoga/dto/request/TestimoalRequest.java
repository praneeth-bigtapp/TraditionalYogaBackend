package com.traditional.yoga.dto.request;

public class TestimoalRequest {

	private int testimonalId;
	private String content;
	private String givenByName;
	private String videoLink;
	private String description;
	private String createdBy;
	private String createDate;
	private String updateBy;
	private String updateDate;
	private String isActive;

	public int getTestimonalId() {
		return testimonalId;
	}

	public void setTestimonalId(int testimonalId) {
		this.testimonalId = testimonalId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGivenByName() {
		return givenByName;
	}

	public void setGivenByName(String givenByName) {
		this.givenByName = givenByName;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
