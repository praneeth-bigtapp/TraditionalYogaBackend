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
@Table(name = "pratice_libary")
public class PraticeLibaryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pratice_libary_id")
	private int praticeLibaryId;

	@OneToOne
	@JoinColumn(name = "library_category_id", referencedColumnName = "category_id")
	private LibaryCategoryModel libraryCategoryId;

	@OneToOne
	@JoinColumn(name = "sub_category_Id", referencedColumnName = "sub_category_id")
	private SubCategoryPraticeLibaryModel subCategoryId;

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

	public LibaryCategoryModel getLibraryCategoryId() {
		return libraryCategoryId;
	}

	public void setLibraryCategoryId(LibaryCategoryModel libraryCategoryId) {
		this.libraryCategoryId = libraryCategoryId;
	}

	public SubCategoryPraticeLibaryModel getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(SubCategoryPraticeLibaryModel subCategoryId) {
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
