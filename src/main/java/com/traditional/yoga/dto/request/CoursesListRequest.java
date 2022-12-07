package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.MasterCategoryModel;

public class CoursesListRequest {

	private int coursesId;
	
	private MasterCategoryModel categorieId;

	private String coursesName;

	private String description;

	private String startDate;

	private String endDate;
	
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
