package com.traditional.yoga.dto.request;

public class CreateAlbumRequest {

	private int albumId;
	private String albumName;
	private String eventFromDate;
	private String eventToDate;
	private String description;
	private String activeStatus;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String isActive;

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getEventFromDate() {
		return eventFromDate;
	}

	public void setEventFromDate(String eventFromDate) {
		this.eventFromDate = eventFromDate;
	}

	public String getEventToDate() {
		return eventToDate;
	}

	public void setEventToDate(String eventToDate) {
		this.eventToDate = eventToDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
