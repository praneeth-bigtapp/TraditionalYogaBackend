package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.RegistrationRequest;
import com.traditional.yoga.model.RegistrationModel;
import com.traditional.yoga.repository.AboutUsRepository;
import com.traditional.yoga.repository.RegistrationRepository;

@Service
public class RegisterService {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
	AboutUsRepository aboutUsRepository;

	@Autowired
	RegistrationRepository registrationRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Register related {} data", operationType);

		try {
			if (operationType.equals("aboutus")) {
				httpStatus = HttpStatus.OK;
				return aboutUsRepository.findAll();
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
			RegistrationModel newEnroll = registrationRepository.getRegistrationById(registrationDto.getRegistrationId());
			if (newEnroll != null) {
				newEnroll.setPassportPhoto(registrationDto.getPassportPhoto());
				newEnroll.setProfessionId(registrationDto.getProfessionId());
				newEnroll.setProfessionWorkingHours(registrationDto.getProfessionWorkingHours());
				newEnroll.setEducationalId(registrationDto.getEducationalId());
				newEnroll.setPrideQualification(registrationDto.getPrideQualification());
				newEnroll.setMartialStatus(registrationDto.getMartialStatus());
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
}
