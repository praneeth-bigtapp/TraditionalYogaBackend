package com.traditional.yoga.dto.request;

public class TestimoalRequest {

	private int testimonalId;
	private String content;
	private String givenByName;
	private String videoLink;
	private String description;

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

}
