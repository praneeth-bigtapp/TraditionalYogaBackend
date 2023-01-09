package com.traditional.yoga.dto.request;

public class PageRequest {

	private int pageId;
	private String pageTitle;
	private String pageText;
	private String hoverTitle;
	private String relatedTags;
	private String description;
	private String subject;
	private String captcha;

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageText() {
		return pageText;
	}

	public void setPageText(String pageText) {
		this.pageText = pageText;
	}

	public String getHoverTitle() {
		return hoverTitle;
	}

	public void setHoverTitle(String hoverTitle) {
		this.hoverTitle = hoverTitle;
	}

	public String getRelatedTags() {
		return relatedTags;
	}

	public void setRelatedTags(String relatedTags) {
		this.relatedTags = relatedTags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

}
