package com.traditional.yoga.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.RegistrationRequest;
import com.traditional.yoga.dto.response.EmailOtpResponse;
import com.traditional.yoga.interfaces.EmailService;
import com.traditional.yoga.model.QualificationModel;
import com.traditional.yoga.model.RegistrationModel;
import com.traditional.yoga.repository.AboutUsRepository;
import com.traditional.yoga.repository.CountryRepository;
import com.traditional.yoga.repository.GenderRepository;
import com.traditional.yoga.repository.MaritalStatusRepository;
import com.traditional.yoga.repository.QualificationRepository;
import com.traditional.yoga.repository.RegistrationRepository;
import com.traditional.yoga.utils.Constants;
import com.traditional.yoga.utils.GeneralUtils;
import com.traditional.yoga.utils.PasswordGenerator;

@Service
public class RegisterService {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
	AboutUsRepository aboutUsRepository;

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	MaritalStatusRepository maritalStatusRepository;

	@Autowired
	QualificationRepository qualificationRepository;
	
	@Autowired
	GenderRepository genderRepository;
	
	@Autowired
	CountryRepository countryRepository;

	@Autowired
	GeneralUtils generalUtils;

	@Autowired
	PasswordGenerator passwordGenerator;

	@Autowired
	EmailService emailService;

	@Autowired
	UserManagementService userManagementService;
	
	@Value("${yoga.credentials.body}")
	private String emailCredentialsBody;
	
	@Value("${yoga.otp.body}")
	private String emailOtpBody;
	

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Register related {} data", operationType);

		try {
			if (operationType.equals("aboutus")) {
				httpStatus = HttpStatus.OK;
				return aboutUsRepository.findAll();
			} else if (operationType.equals("maritalStatus")) {
				httpStatus = HttpStatus.OK;
				return maritalStatusRepository.findAll();
			} else if (operationType.equals("gender")) {
				httpStatus = HttpStatus.OK;
				return genderRepository.findAll();
			} else if (operationType.equals("country")) {
				httpStatus = HttpStatus.OK;
				return countryRepository.findAll();
			} else {
				message = "Unknown Operation";
				httpStatus = HttpStatus.NOT_ACCEPTABLE;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
				return new ResponseEntity<>(response, httpStatus);
			}

		} catch (Exception e) {
			message = "Unknown Error";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

	public Object enrollBasicStudent(RegistrationRequest registrationDto) {
		try {
			RegistrationModel newEnroll = new RegistrationModel();
			newEnroll.setFirstName(registrationDto.getFirstName());
			newEnroll.setMiddleName(registrationDto.getMiddleName());
			newEnroll.setLastName(registrationDto.getLastName());
			newEnroll.setEmailId(registrationDto.getEmailId());
			newEnroll.setMobileNumber(registrationDto.getMobileNumber());
			newEnroll.setDateOfBirth(registrationDto.getDateOfBirth());
			newEnroll.setGenderId(registrationDto.getGenderId());
			newEnroll.setHouseNumber(registrationDto.getHouseNumber());
			newEnroll.setStreet(registrationDto.getStreet());
			newEnroll.setTownCity(registrationDto.getTownCity());
			newEnroll.setCountry(registrationDto.getCountry());
			newEnroll.setState(registrationDto.getState());
			newEnroll.setPinCode(registrationDto.getPinCode());
			newEnroll.setMotherTongue(registrationDto.getMotherTongue());
			newEnroll.setEnglishCommunicate(registrationDto.getEnglishCommunicate());
			newEnroll.setAboutUsId(registrationDto.getAboutUsId());
			newEnroll.setTermsCondition(registrationDto.getTermsCondition());
			registrationRepository.save(newEnroll);
			message = "User Registered Sucessfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);

			LOG.info("Generating Password");
			String pwd = generatePassword(registrationDto.getEmailId());

			LOG.info("Saving User Credentions");
			RegistrationModel enrollDb = registrationRepository.getRegistrationByEmail(newEnroll.getEmailId());
			userManagementService.registerUsers(enrollDb, pwd);

			return new ResponseEntity<>(response, httpStatus);
		} catch (Exception e) {
			message = "Exception in Basic Registation";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

	public Object enrollFullStudent(RegistrationRequest registrationDto) {
		try {
			RegistrationModel newEnroll = registrationRepository
					.getRegistrationById(registrationDto.getRegistrationId());
			if (newEnroll != null) {
				newEnroll.setPassportPhoto(registrationDto.getPassportPhoto());
				newEnroll.setProfessionWorkingHours(registrationDto.getProfessionWorkingHours());
				newEnroll.setPrideQualification(registrationDto.getPrideQualification());
				newEnroll.setFamilyDetails(registrationDto.getFamilyDetails());
				newEnroll.setConsentFamily(registrationDto.getConsentFamily());
				newEnroll.setResistanceFamily(registrationDto.getResistanceFamily());
				newEnroll.setParticipatingFamily(registrationDto.getParticipatingFamily());
				newEnroll.setPastPractice(registrationDto.getPastPractice());
				newEnroll.setHobbies(registrationDto.getHobbies());
				newEnroll.setHobbiesAside(registrationDto.getHobbiesAside());
				newEnroll.setReferenceName(registrationDto.getReferenceName());
				newEnroll.setReferenceRelationship(registrationDto.getReferenceRelationship());
				newEnroll.setReferenceMobile(registrationDto.getReferenceMobile());
				newEnroll.setCourseBriefly(registrationDto.getCourseBriefly());

				Boolean professionStatus = registrationDto.getProfessionId().getProfessionId() == 0;
				if (Boolean.FALSE.equals(professionStatus))
					newEnroll.setProfessionId(registrationDto.getProfessionId());

				Boolean maritalStatus = registrationDto.getMaritalStatus().getMaritalStatusId() == 0;
				if (Boolean.FALSE.equals(maritalStatus))
					newEnroll.setMaritalStatus(registrationDto.getMaritalStatus());

				if (registrationDto.getParticipatingFamily().equals(Constants.YES)) {
					newEnroll.setParticipateName(registrationDto.getParticipateName());
				}

				Boolean educationalStatus = registrationDto.getEducationalId().getQualificationId() == 0;
				if (Boolean.FALSE.equals(educationalStatus)) {
					Boolean otherStatus = registrationDto.getEducationalId().getQualificationId() == -1;
					if (Boolean.TRUE.equals(otherStatus)) {
						addQualification(registrationDto.getOtherEducationalName());
						QualificationModel qualificationDb = qualificationRepository
								.getQualificationByName(registrationDto.getOtherEducationalName());
						newEnroll.setEducationalId(qualificationDb);
					} else {
						newEnroll.setEducationalId(registrationDto.getEducationalId());
					}
				}

				registrationRepository.save(newEnroll);
				message = "User Registered Sucessfully";
				httpStatus = HttpStatus.OK;
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
				return new ResponseEntity<>(response, httpStatus);
			} else {
				message = "Student your searching is doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
				return new ResponseEntity<>(response, httpStatus);
			}

		} catch (Exception e) {
			message = "Exception in Detailed Registation";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

	private void addQualification(String qualificationName) {
		LOG.info("Adding new Qualification");
		QualificationModel newQualification = new QualificationModel();
		newQualification.setQualificationName(qualificationName);
		newQualification.setCreatedBy("Praneeth");
		newQualification.setCreatedDate(generalUtils.getCurrentDate());
		qualificationRepository.save(newQualification);
		LOG.info("Qualification Adding Sucessfully");
	}

//	Email OTP Verification service
	public Object verifyEmail(String emailId) {
		EmailOtpResponse otpResponse = new EmailOtpResponse();
		try {
			String otp = emailService.generateOtp();
			String to = emailId;
			String subject = Constants.OTP_SUBJECT;
			String text = MessageFormat.format(emailOtpBody, otp);
			emailService.sendSimpleMessage(to, subject, text);

			message = "OTP send Sucessfully to mail ID : " + emailId;
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
			otpResponse.setOtp(otp);
			otpResponse.setResponse(response);
			return new ResponseEntity<>(otpResponse, httpStatus);
		} catch (Exception e) {
			message = "Unable to send mail, Exception!!";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

//	Generate Password
	private String generatePassword(String emailId) {
		String password = passwordGenerator.generatePassword();
		try {
			LOG.info("Password Generated sucessfully");
			String to = emailId;
			String subject = Constants.PASSWORD_SUBJECT;
			String text = MessageFormat.format(emailCredentialsBody, emailId, password);
			emailService.sendSimpleMessage(to, subject, text);

			message = "OTP send Sucessfully to mail ID : " + emailId;
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} catch (Exception e) {
			message = "Unable to send mail, Exception!!";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return password;
	}

}
