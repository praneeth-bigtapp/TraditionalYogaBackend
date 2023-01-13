package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "guruji_replies_student")
public class GurujiRepliesStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private int messageId;

	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "registration_id")
	private RegistrationModel studentId;

	@OneToOne
	@JoinColumn(name = "guruji_id", referencedColumnName = "role_id")
	private RoleModel gurujiId;

	@Column(name = "message")
	private String message;

	@Column(name = "date_replies")
	private String dateOfReplies;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private String updatedDate;

	@Column(name = "is_active")
	private String isActive;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public RegistrationModel getStudentId() {
		return studentId;
	}

	public void setStudentId(RegistrationModel studentId) {
		this.studentId = studentId;
	}

	public RoleModel getGurujiId() {
		return gurujiId;
	}

	public void setGurujiId(RoleModel gurujiId) {
		this.gurujiId = gurujiId;
	}

	public String getDateOfReplies() {
		return dateOfReplies;
	}

	public void setDateOfReplies(String dateOfReplies) {
		this.dateOfReplies = dateOfReplies;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
