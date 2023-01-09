package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.CountryModel;

public class DonationRequest {

	private int donationId;
	private int studentId;

	private CountryModel countryId;
	private String donarName;
	private String panNumber;

	private String date;
	private String amountDonated;
	private String description;
	private String modeOfPayment;

	private String registerMember;

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public CountryModel getCountryId() {
		return countryId;
	}

	public void setCountryId(CountryModel countryId) {
		this.countryId = countryId;
	}

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
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

	public String getRegisterMember() {
		return registerMember;
	}

	public void setRegisterMember(String registerMember) {
		this.registerMember = registerMember;
	}

}
