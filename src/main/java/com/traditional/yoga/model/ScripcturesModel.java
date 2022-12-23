package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "scripctures")
public class ScripcturesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scripctures_id")
	private int scripcturesId;
	@Lob
	@Column(name = "coverpage_image")
	private String coverImage;
	@Column(name = "upload_file")
	private String uploadFile;
	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;
	@Column(name = "meta_keywords")
	private String metaKeyWords;

	public int getScripcturesId() {
		return scripcturesId;
	}

	public void setScripcturesId(int scripcturesId) {
		this.scripcturesId = scripcturesId;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMetaKeyWords() {
		return metaKeyWords;
	}

	public void setMetaKeyWords(String metaKeyWords) {
		this.metaKeyWords = metaKeyWords;
	}

}
