package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testimonal")
public class TestimonalsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testimonal_id")
	private int testimonalId;

	@Column(name = "content")
	private String content;

	@Column(name = "Given_by_name")
	private String givenByName;

	@Column(name = "Video_link")
	private String videoLink;

	@Column(name = "description")
	private String description;

	@Column(name = "date_of_add")
	private String dateOfAdd;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private String updateDate;

	@Column(name = "is_active")
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

	public String getDateOfAdd() {
		return dateOfAdd;
	}

	public void setDateOfAdd(String dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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
