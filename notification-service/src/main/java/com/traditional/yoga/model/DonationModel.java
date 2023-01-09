package com.traditional.yoga.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donation")
public class DonationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donation_id")
	private int donationId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "donar_id", referencedColumnName = "donar_id")
	private DonarModel donarId;

	@Column(name = "date")
	private String date;

	@Column(name = "amount_donated")
	private String amountDonated;

	@Column(name = "description")
	private String description;

	@Column(name = "mode_of_payement")
	private String modeOfPayment;

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public String getDate() {
		return date;
	}

	public DonarModel getDonarId() {
		return donarId;
	}

	public void setDonarId(DonarModel donarId) {
		this.donarId = donarId;
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
