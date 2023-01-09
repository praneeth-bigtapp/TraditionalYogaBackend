package com.traditional.yoga.dto.request;

public class ScripcturesRequest {

	private int scripcturesId;
	private String coverImage;
	private String uploadFile;
	private String description;
	private String title;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetaKeyWords() {
		return metaKeyWords;
	}

	public void setMetaKeyWords(String metaKeyWords) {
		this.metaKeyWords = metaKeyWords;
	}

}
