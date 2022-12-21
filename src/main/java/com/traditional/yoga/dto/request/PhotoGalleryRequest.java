package com.traditional.yoga.dto.request;

public class PhotoGalleryRequest {

	private int photoGalleryId;
	private String galleryName;
	private String galleryDescription;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private int noOfPhoto;
	private int imageId;
	private String active;

	public int getPhotoGalleryId() {
		return photoGalleryId;
	}

	public void setPhotoGalleryId(int photoGalleryId) {
		this.photoGalleryId = photoGalleryId;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	public String getGalleryDescription() {
		return galleryDescription;
	}

	public void setGalleryDescription(String galleryDescription) {
		this.galleryDescription = galleryDescription;
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

	public int getNoOfPhoto() {
		return noOfPhoto;
	}

	public void setNoOfPhoto(int noOfPhoto) {
		this.noOfPhoto = noOfPhoto;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
