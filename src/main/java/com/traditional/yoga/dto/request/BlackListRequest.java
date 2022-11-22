package com.traditional.yoga.dto.request;

public class BlackListRequest {

	private int blacklistuserId;
	private String blacklistUserEmail;
	private String comments;
	private String date;

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

}
