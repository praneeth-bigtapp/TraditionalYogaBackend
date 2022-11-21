package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.repository.CourseRepository;
import com.traditional.yoga.repository.DonationRepository;
import com.traditional.yoga.repository.EpurchaseInformation;
import com.traditional.yoga.repository.StudentRepository;

@Service
public class StudentService {

	private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EpurchaseInformation epurchaseInformation;
	
	@Autowired
	DonationRepository donationRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Student related {} data", operationType);

		try {
			if (operationType.equals("student")) {
				return studentRepository.findAll();
			} else if (operationType.equals("course")) {
				return courseRepository.findAll();
			} else if (operationType.equals("donation")) {
				return donationRepository.findAll();
			} else if (operationType.equals("ePurchase")) {
				return epurchaseInformation.findAll();
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
	
//	Student
	public Object manageStudent() {
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(studentRepository.getStudentById(1), httpStatus);
	}

}
