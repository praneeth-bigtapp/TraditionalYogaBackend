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
