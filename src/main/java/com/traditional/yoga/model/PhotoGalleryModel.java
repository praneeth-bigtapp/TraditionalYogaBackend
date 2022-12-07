package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photo_gallery")
public class PhotoGalleryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photo_gallery_id")
	private int photoGalleryId;

	@Column(name = "gallery_name")
	private String galleryName;

	@Column(name = "gallery_description")
	private String galleryDescription;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private String updatedDate;

	@Column(name = "no_of_photo")
	private int noOfPhoto;

	@Column(name = "image_id")
	private int imageId;

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

}
