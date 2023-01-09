package com.traditional.yoga.dto.request;

public class EPurchaseRequest {

	private int epurchaseId;
	private int studentId;
	private String date;
	private int purchaseAmount;
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
