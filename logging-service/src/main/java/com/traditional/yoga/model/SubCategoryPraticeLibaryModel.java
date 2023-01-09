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
@Table(name = "sub_category_praticelibary")
public class SubCategoryPraticeLibaryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_category_id")
	private int subCategoryId;

	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private LibaryCategoryModel categoryId;

	@Column(name = "sub_category_name")
	private String subCategoryName;

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public LibaryCategoryModel getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(LibaryCategoryModel categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

}
