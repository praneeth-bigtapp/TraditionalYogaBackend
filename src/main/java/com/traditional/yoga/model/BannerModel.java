package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banner")
public class BannerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "banner_id")
	private int bannerId;

	@Column(name = "banner_name")
	private String bannerName;

	@Column(name = "course_title")
	private String courseTitle;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "from_date")
	private String fromDate;

	@Column(name = "to_date")
	private String toDate;

	@Column(name = "description")
	private String description;

	@Column(name = "categeory_id")
	private int categoryId;

	@Column(name = "date_of_add")
	private String dateOfAdd;

	public int getBannerId() {
		return bannerId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDateOfAdd() {
		return dateOfAdd;
	}

	public void setDateOfAdd(String dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}

}
