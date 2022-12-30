package com.traditional.yoga.dto.request;

import com.traditional.yoga.model.AboutUsModel;
import com.traditional.yoga.model.GenderModel;
import com.traditional.yoga.model.MaritalStatusModel;
import com.traditional.yoga.model.ProfessionsModel;
import com.traditional.yoga.model.QualificationModel;

public class RegistrationRequest {

	private int registrationId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private Long mobileNumber;
	private String dateOfBirth;
	private GenderModel genderId;
	private String houseNumber;
	private String street;
	private String townCity;
	private String country;
	private String state;
	private int pinCode;
	private String motherTongue;
	private String englishCommunicate;
	private AboutUsModel aboutUsId;
	private String termsCondition;
	private String passportPhoto;
	private ProfessionsModel professionId;
	private int professionWorkingHours;
	private QualificationModel educationalId;
	private String otherEducationalName;
	private String prideQualification;
	private MaritalStatusModel maritalStatus;
	private String familyDetails;
	private String consentFamily;
	private String resistanceFamily;
	private String participatingFamily;
	private String participateName;
	private String pastPractice;
	private String hobbies;
	private String hobbiesAside;
	private String referenceName;
	private String referenceRelationship;
	private Long referenceMobile;
	private String courseBriefly;
	private String otp;

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

	public String getOtherEducationalName() {
		return otherEducationalName;
	}

	public void setOtherEducationalName(String otherEducationalName) {
		this.otherEducationalName = otherEducationalName;
	}

	public String getPrideQualification() {
		return prideQualification;
	}

	public void setPrideQualification(String prideQualification) {
		this.prideQualification = prideQualification;
	}

	public MaritalStatusModel getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatusModel maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	public String getParticipateName() {
		return participateName;
	}

	public void setParticipateName(String participateName) {
		this.participateName = participateName;
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

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
