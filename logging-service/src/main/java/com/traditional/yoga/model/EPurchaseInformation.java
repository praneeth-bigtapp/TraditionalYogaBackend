package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "epurchaseinformation")
public class EPurchaseInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "epurchase_id")
	private int epurchaseId;

	@Column(name = "student_id")
	private int studentId;

	@Column(name = "date")
	private String date;

	@Column(name = "purchase_amount")
	private int purchaseAmount;

	@Column(name = "products_purchase")
	private String productPurchase;

	public int getEpurchaseId() {
		return epurchaseId;
	}

	public void setEpurchaseId(int epurchaseId) {
		this.epurchaseId = epurchaseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getProductPurchase() {
		return productPurchase;
	}

	public void setProductPurchase(String productPurchase) {
		this.productPurchase = productPurchase;
	}

}
