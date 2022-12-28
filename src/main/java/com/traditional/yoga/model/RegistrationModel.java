package com.traditional.yoga.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class RegistrationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registration_id")
	private int registrationId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "mobile_number")
	private Long mobileNumber;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@ManyToOne
	@JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
	private GenderModel genderId;

	@Column(name = "house_number")
	private String houseNumber;

	@Column(name = "street")
	private String street;

	@Column(name = "town_city")
	private String townCity;

	@Column(name = "country")
	private String country;

	@Column(name = "state")
	private String state;

	@Column(name = "pin_code")
	private int pinCode;

	@Column(name = "mother_tongue")
	private String motherTongue;

	@Column(name = "english_communicate")
	private String englishCommunicate;

//	@OneToOne(cascade = CascadeType.ALL)
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "about_us_id", referencedColumnName = "about_us_id")
	private AboutUsModel aboutUsId;

	@Column(name = "terms_condition")
	private String termsCondition;

	@Column(name = "passport_photo")
	private String passportPhoto;

	@ManyToOne
	@JoinColumn(name = "profession_id", referencedColumnName = "profession_id")
	private ProfessionsModel professionId;

	@Column(name = "profession_working_hours")
	private int professionWorkingHours;

	@ManyToOne
	@JoinColumn(name = "educational_id", referencedColumnName = "qualification_id")
	private QualificationModel educationalId;

	@Column(name = "pride_qualification")
	private String prideQualification;

	@Column(name = "martial_status")
	private String martialStatus;

	@Column(name = "family_details")
	private String familyDetails;

	@Column(name = "consent_family")
	private String consentFamily;

	@Column(name = "resistance_family")
	private String resistanceFamily;

	@Column(name = "participating_family")
	private String participatingFamily;

	@Column(name = "past_practice")
	private String pastPractice;

	@Column(name = "hobbies")
	private String hobbies;

	@Column(name = "hobbies_aside")
	private String hobbiesAside;

	@Column(name = "reference_name")
	private String referenceName;

	@Column(name = "reference_relationship")
	private String referenceRelationship;

	@Column(name = "reference_mobile")
	private Long referenceMobile;

	@Column(name = "course_briefly")
	private String courseBriefly;

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public GenderModel getGenderId() {
		return genderId;
	}

	public void setGenderId(GenderModel genderId) {
		this.genderId = genderId;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTownCity() {
		return townCity;
	}

	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public String getEnglishCommunicate() {
		return englishCommunicate;
	}

	public void setEnglishCommunicate(String englishCommunicate) {
		this.englishCommunicate = englishCommunicate;
	}

	public AboutUsModel getAboutUsId() {
		return aboutUsId;
	}

	public void setAboutUsId(AboutUsModel aboutUsId) {
		this.aboutUsId = aboutUsId;
	}

	public String getTermsCondition() {
		return termsCondition;
	}

	public void setTermsCondition(String termsCondition) {
		this.termsCondition = termsCondition;
	}

	public String getPassportPhoto() {
		return passportPhoto;
	}

	public void setPassportPhoto(String passportPhoto) {
		this.passportPhoto = passportPhoto;
	}

	public ProfessionsModel getProfessionId() {
		return professionId;
	}

	public void setProfessionId(ProfessionsModel professionId) {
		this.professionId = professionId;
	}

	public int getProfessionWorkingHours() {
		return professionWorkingHours;
	}

	public void setProfessionWorkingHours(int professionWorkingHours) {
		this.professionWorkingHours = professionWorkingHours;
	}

	public QualificationModel getEducationalId() {
		return educationalId;
	}

	public void setEducationalId(QualificationModel educationalId) {
		this.educationalId = educationalId;
	}

	public String getPrideQualification() {
		return prideQualification;
	}

	public void setPrideQualification(String prideQualification) {
		this.prideQualification = prideQualification;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(String familyDetails) {
		this.familyDetails = familyDetails;
	}

	public String getConsentFamily() {
		return consentFamily;
	}

	public void setConsentFamily(String consentFamily) {
		this.consentFamily = consentFamily;
	}

	public String getResistanceFamily() {
		return resistanceFamily;
	}

	public void setResistanceFamily(String resistanceFamily) {
		this.resistanceFamily = resistanceFamily;
	}

	public String getParticipatingFamily() {
		return participatingFamily;
	}

	public void setParticipatingFamily(String participatingFamily) {
		this.participatingFamily = participatingFamily;
	}

	public String getPastPractice() {
		return pastPractice;
	}

	public void setPastPractice(String pastPractice) {
		this.pastPractice = pastPractice;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getHobbiesAside() {
		return hobbiesAside;
	}

	public void setHobbiesAside(String hobbiesAside) {
		this.hobbiesAside = hobbiesAside;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getReferenceRelationship() {
		return referenceRelationship;
	}

	public void setReferenceRelationship(String referenceRelationship) {
		this.referenceRelationship = referenceRelationship;
	}

	public Long getReferenceMobile() {
		return referenceMobile;
	}

	public void setReferenceMobile(Long referenceMobile) {
		this.referenceMobile = referenceMobile;
	}

	public String getCourseBriefly() {
		return courseBriefly;
	}

	public void setCourseBriefly(String courseBriefly) {
		this.courseBriefly = courseBriefly;
	}

}
