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
@Table(name = "task")
public class TaskModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_Id")
	private int taskId;

	@Column(name = "task_name")
	private String taskName;

	@OneToOne
	@JoinColumn(name = "courses_id", referencedColumnName = "courses_id")
	private CourseListModel coursesId;

	@Column(name = "Date_of_assignment")
	private String DateOfAssigement;

	@Column(name = "description")
	private String description;

	@Column(name = "Upload_media_file")
	private String mediafile;

	@Column(name = "Due_date")
	private String dueDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createDate;

	@Column(name = "updated_by")
	private String updateBy;

	@Column(name = "updated_date")
	private String updateDate;

	@Column(name = "is_active")
	private String isActive;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDateOfAssigement() {
		return DateOfAssigement;
	}

	public void setDateOfAssigement(String dateOfAssigement) {
		DateOfAssigement = dateOfAssigement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMediafile() {
		return mediafile;
	}

	public void setMediafile(String mediafile) {
		this.mediafile = mediafile;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public CourseListModel getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(CourseListModel coursesId) {
		this.coursesId = coursesId;
	}

}
