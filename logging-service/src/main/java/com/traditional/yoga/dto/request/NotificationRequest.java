package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.NotificationCategoryModel;

public class NotificationRequest {

	private int notificationId;
	private NotificationCategoryModel categoryId;
	private String title;
	private String uploadFile;
	private String message;

	

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public NotificationCategoryModel getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(NotificationCategoryModel categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
