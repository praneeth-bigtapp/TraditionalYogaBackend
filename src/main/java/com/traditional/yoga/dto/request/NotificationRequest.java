package com.traditional.yoga.dto.request;

public class NotificationRequest {

	private int noticationId;
	private int categoryId;
	private String uploadFile;
	private String message;

	public int getNoticationId() {
		return noticationId;
	}

	public void setNoticationId(int noticationId) {
		this.noticationId = noticationId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
