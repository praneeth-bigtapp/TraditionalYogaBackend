package com.traditional.yoga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donation")
public class DonationModel {

	@Id
	@Column(name = "donation_id")
	private String donationId;

	@Column(name = "student_id")
	private String studentId;

	@Column(name = "date")
	private String date;

	@Column(name = "amount_donation")
	private String amountDonation;

	@Column(name = "description")
	private String description;

	@Column(name = "mode_of_payment")
	private String modeOfPayment;

	public String getDonationId() {
		return donationId;
	}

	public void setDonationId(String donationId) {
		this.donationId = donationId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmountDonation() {
		return amountDonation;
	}

	public void setAmountDonation(String amountDonation) {
		this.amountDonation = amountDonation;
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
