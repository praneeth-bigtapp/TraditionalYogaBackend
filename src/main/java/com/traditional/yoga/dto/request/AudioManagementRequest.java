package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.AudioCategoryLibaryModel;
import com.traditional.yoga.model.AudioTypeModel;

public class AudioManagementRequest {

	private int id;
	private int courseId;
	private AudioCategoryLibaryModel audioCategoryId;
	private String uploadCategory;
	private String audioFile;
	private AudioTypeModel audioType;
	private String audioTitle;
	private String audioDesc;
	private int audioDuration;
	private String metakey;
	private String active;

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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
