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
@Table(name = "donar_records")
public class DonarModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donar_id")
	private int donarId;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;
	
	
	@Column(name = "donar_name")
	private String donarName;

	@Column(name = "pan_number")
	private String panNumber;
	
	

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "indian_citizen")
	private String indianCitizen;

	
	@OneToOne
	@JoinColumn(name = "country_id", referencedColumnName = "country_id")
	private CountryModel countryId;

	@Column(name = "tax_benefits")
	private String taxBenefits;

	@Column(name = "identity_proof")
	private String identityProof;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "donation_amount")
	private int donationAmount;

	@Column(name = "stripe_credit_card")
	private int stripeCreditCard;

	@Column(name = "card_name")
	private String cardName;

	@Column(name = "message")
	private String message;

	public int getDonarId() {
		return donarId;
	}

	public void setDonarId(int donarId) {
		this.donarId = donarId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getIndianCitizen() {
		return indianCitizen;
	}

	public void setIndianCitizen(String indianCitizen) {
		this.indianCitizen = indianCitizen;
	}

	

	public String getTaxBenefits() {
		return taxBenefits;
	}

	public void setTaxBenefits(String taxBenefits) {
		this.taxBenefits = taxBenefits;
	}

	public String getIdentityProof() {
		return identityProof;
	}

	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public int getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(int donationAmount) {
		this.donationAmount = donationAmount;
	}

	public int getStripeCreditCard() {
		return stripeCreditCard;
	}

	public void setStripeCreditCard(int stripeCreditCard) {
		this.stripeCreditCard = stripeCreditCard;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public CountryModel getCountryId() {
		return countryId;
	}

	public void setCountryId(CountryModel countryId) {
		this.countryId = countryId;
	}

	
	
}
