package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.LibaryCategoryModel;

public class PraticeLibaryRequest {

	private int praticeLibaryId;
	private LibaryCategoryModel libraryCategoryId;
	private int subCategoryId;
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

	public LibaryCategoryModel getLibraryCategoryId() {
		return libraryCategoryId;
	}

	public void setLibraryCategoryId(LibaryCategoryModel libraryCategoryId) {
		this.libraryCategoryId = libraryCategoryId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
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
