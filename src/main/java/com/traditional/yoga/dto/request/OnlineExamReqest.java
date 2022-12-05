package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.TestTypeModel;
import com.traditional.yoga.model.levelofTestModel;

public class OnlineExamReqest {

	private int examsId;
	private CourseListModel courseId;
	private TestTypeModel testId;
	private String nameofTest;
	private levelofTestModel levelId;
	private String fileUpload;
	private String description;

	public int getExamsId() {
		return examsId;
	}

	public void setExamsId(int examsId) {
		this.examsId = examsId;
	}

	public CourseListModel getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseListModel courseId) {
		this.courseId = courseId;
	}

	public TestTypeModel getTestId() {
		return testId;
	}

	public void setTestId(TestTypeModel testId) {
		this.testId = testId;
	}

	public String getNameofTest() {
		return nameofTest;
	}

	public void setNameofTest(String nameofTest) {
		this.nameofTest = nameofTest;
	}

	public levelofTestModel getLevelId() {
		return levelId;
	}

	public void setLevelId(levelofTestModel levelId) {
		this.levelId = levelId;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
