package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pratice_libary")
public class PraticeLibaryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pratice_libary_id")
	private int praticeLibaryId;

	@Column(name = "library_category_id")
	private int categoryId;

	@Column(name = "video_link")
	private String videoLink;

	@Column(name = "duration_of_video")
	private String duration;

	@Column(name = "title")
	private String title;

	@Column(name = "message")
	private String message;

	@Column(name = "meta_keywords")
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
