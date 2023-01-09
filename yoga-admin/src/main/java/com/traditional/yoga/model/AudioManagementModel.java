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
@Table(name = "audio_management")
public class AudioManagementModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "audio_management_id")
	private int id;

	@Column(name = "courses_id")
	private int courseId;

	@OneToOne
	@JoinColumn(name = "audio_category_id", referencedColumnName = "audio_category_id")
	private AudioCategoryLibaryModel audioCategoryId;

	@Column(name = "upload_category")
	private String uploadCategory;
	
	@OneToOne
	@JoinColumn(name = "audio_type", referencedColumnName = "audio_type_id")
	private AudioTypeModel audioType;

	@Column(name = "audio_file")
	private String audioFile;

	@Column(name = "audio_title")
	private String audioTitle;

	@Column(name = "audio_description")
	private String audioDesc;

	@Column(name = "audio_duration")
	private int audioDuration;

	@Column(name = "metakey_word")
	private String metakey;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_date")
	private String updatedDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "is_active")
	private String isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public AudioCategoryLibaryModel getAudioCategoryId() {
		return audioCategoryId;
	}

	public void setAudioCategoryId(AudioCategoryLibaryModel audioCategoryId) {
		this.audioCategoryId = audioCategoryId;
	}

	public AudioTypeModel getAudioType() {
		return audioType;
	}

	public void setAudioType(AudioTypeModel audioType) {
		this.audioType = audioType;
	}

	public String getUploadCategory() {
		return uploadCategory;
	}

	public void setUploadCategory(String uploadCategory) {
		this.uploadCategory = uploadCategory;
	}

	public String getAudioFile() {
		return audioFile;
	}

	public void setAudioFile(String audioFile) {
		this.audioFile = audioFile;
	}

	public String getAudioTitle() {
		return audioTitle;
	}

	public void setAudioTitle(String audioTitle) {
		this.audioTitle = audioTitle;
	}

	public String getAudioDesc() {
		return audioDesc;
	}

	public void setAudioDesc(String audioDesc) {
		this.audioDesc = audioDesc;
	}

	public int getAudioDuration() {
		return audioDuration;
	}

	public void setAudioDuration(int audioDuration) {
		this.audioDuration = audioDuration;
	}

	public String getMetakey() {
		return metakey;
	}

	public void setMetakey(String metakey) {
		this.metakey = metakey;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
