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
@Table(name = "online_exams")
public class OnlineExamsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exams_id")
	private int examsId;

	@OneToOne
	@JoinColumn(name = "courses_id", referencedColumnName = "courses_id")
	private CourseListModel courseId;

	@OneToOne
	@JoinColumn(name = "Test_id", referencedColumnName = "test_id")
	private TestTypeModel testId;

	@Column(name = "name_of_test")
	private String nameofTest;

	@OneToOne
	@JoinColumn(name = "level_Id", referencedColumnName = "level_Id")
	private LevelOfTestModel levelId;

	@Column(name = "upload_file")
	private String fileUpload;

	@Column(name = "description")
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

	public LevelOfTestModel getLevelId() {
		return levelId;
	}

	public void setLevelId(LevelOfTestModel levelId) {
		this.levelId = levelId;
	}

	public String getNameofTest() {
		return nameofTest;
	}

	public void setNameofTest(String nameofTest) {
		this.nameofTest = nameofTest;
	}

	public TestTypeModel getTestId() {
		return testId;
	}

	public void setTestId(TestTypeModel testId) {
		this.testId = testId;
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
