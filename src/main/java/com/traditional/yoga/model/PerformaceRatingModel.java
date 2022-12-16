package com.traditional.yoga.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "performace_rating")
public class PerformaceRatingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private CourseModel courseId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parameters_id", referencedColumnName = "parameters_id")
	private ParametersModel parametersId;

	@Column(name = "rating_good")
	private String ratingGood;

	@Column(name = "rating_avearage")
	private String ratingAvearage;

	@Column(name = "rating_poor")
	private String ratingPoor;

	@Column(name = "rating_redAlert")
	private String ratingRedAlert;

	@Column(name = "active")
	private String active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CourseModel getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseModel courseId) {
		this.courseId = courseId;
	}

	public String getRatingGood() {
		return ratingGood;
	}

	public ParametersModel getParametersId() {
		return parametersId;
	}

	public void setParametersId(ParametersModel parametersId) {
		this.parametersId = parametersId;
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
