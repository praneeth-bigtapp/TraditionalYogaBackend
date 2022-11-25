package com.traditional.yoga.dto.request;

public class DonationRequest {

	private int donationId;
	private int studentId;
	private String date;
	private String amountDonated;
	private String description;
	private String modeOfPayment;

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
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

	public String getAmountDonated() {
		return amountDonated;
	}

	public void setAmountDonated(String amountDonated) {
		this.amountDonated = amountDonated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

}
