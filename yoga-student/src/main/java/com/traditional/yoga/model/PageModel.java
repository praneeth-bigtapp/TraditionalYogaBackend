package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pages")
public class PageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pages_id ")
	private int pageId;
	@Column(name = "pages_title")
	private String pageTitle;

	@Column(name = "page_text")
	private String pageText;

	@Column(name = "hover_title")
	private String hoverTitle;

	@Column(name = "related_tags")
	private String relatedTags;

	@Column(name = "description")
	private String description;

	@Column(name = "subject")
	private String subject;

	@Column(name = "captcha")
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
