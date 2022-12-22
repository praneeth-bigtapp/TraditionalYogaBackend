package com.traditional.yoga.dto.request;

public class BlackListRequest {

	private int blacklistuserId;
	private String blacklistUserEmail;
	private String comments;
	private String date;
	private String createdDate;
	private String createdBy;
	private String updateDate;
	private String updatedBy;
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
