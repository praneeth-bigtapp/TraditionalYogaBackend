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
@Table(name = "my_course_material")
public class CourseListModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courses_id")
	private int coursesId;

	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "categories_id")
	private MasterCategoryModel categorieId;

	@Column(name = "courses_name")
	private String coursesName;

	@Column(name = "description")
	private String description;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "application_closer_date")
	private String applicationClouserDate;

	public int getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(int coursesId) {
		this.coursesId = coursesId;
	}

	public String getCoursesName() {
		return coursesName;
	}

	public void setCoursesName(String coursesName) {
		this.coursesName = coursesName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public MasterCategoryModel getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(MasterCategoryModel categorieId) {
		this.categorieId = categorieId;
	}

	public String getApplicationClouserDate() {
		return applicationClouserDate;
	}

	public void setApplicationClouserDate(String applicationClouserDate) {
		this.applicationClouserDate = applicationClouserDate;
	}

}
