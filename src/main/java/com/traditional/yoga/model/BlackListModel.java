package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blacklist_users")
public class BlackListModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "backlistuser_id")
	private int blacklistuserId;

	@Column(name = "blacklistuser_email")
	private String blacklistUserEmail;

	@Column(name = "date")
	private String date;

	@Column(name = "comments")
	private String comments;

	@Column(name = "created_date")
	private String createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "updated_date")
	private String updateDate;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "is_active")
	private String isActive;

	public int getBlacklistuserId() {
		return blacklistuserId;
	}

	public void setBlacklistuserId(int blacklistuserId) {
		this.blacklistuserId = blacklistuserId;
	}

	public String getBlacklistUserEmail() {
		return blacklistUserEmail;
	}

	public void setBlacklistUserEmail(String blacklistUserEmail) {
		this.blacklistUserEmail = blacklistUserEmail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
