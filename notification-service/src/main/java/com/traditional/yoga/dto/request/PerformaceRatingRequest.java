package com.traditional.yoga.dto.request;

public class PerformaceRatingRequest {

	private int performaceRatingId;
	private int courseId;
	private String performaceName;
	private String ratingGood;
	private String ratingAvearage;
	private String ratingPoor;
	private String ratingRedAlert;
	private String active;

	public int getPerformaceRatingId() {
		return performaceRatingId;
	}

	public void setPerformaceRatingId(int performaceRatingId) {
		this.performaceRatingId = performaceRatingId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getPerformaceName() {
		return performaceName;
	}

	public void setPerformaceName(String performaceName) {
		this.performaceName = performaceName;
	}

	public String getRatingGood() {
		return ratingGood;
	}

	public void setRatingGood(String ratingGood) {
		this.ratingGood = ratingGood;
	}

	public String getRatingAvearage() {
		return ratingAvearage;
	}

	public void setRatingAvearage(String ratingAvearage) {
		this.ratingAvearage = ratingAvearage;
	}

	public String getRatingPoor() {
		return ratingPoor;
	}

	public void setRatingPoor(String ratingPoor) {
		this.ratingPoor = ratingPoor;
	}

	public String getRatingRedAlert() {
		return ratingRedAlert;
	}

	public void setRatingRedAlert(String ratingRedAlert) {
		this.ratingRedAlert = ratingRedAlert;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
