package com.traditional.yoga.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.StudentRequest;
import com.traditional.yoga.model.DonationModel;
import com.traditional.yoga.model.EPurchaseInformation;
import com.traditional.yoga.model.StudentModel;
import com.traditional.yoga.model.VolunteerModel;
import com.traditional.yoga.repository.CourseRepository;
import com.traditional.yoga.repository.DonationRepository;
import com.traditional.yoga.repository.EpurchaseInformation;
import com.traditional.yoga.repository.StudentRepository;
import com.traditional.yoga.repository.VolunteerRepository;

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
	
	@Autowired
	VolunteerRepository volunteerRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Student related {} data", operationType);

		try {
			if (operationType.equals("student")) {
				httpStatus = HttpStatus.OK;
				return studentRepository.findAll();
			} else if (operationType.equals("course")) {
				httpStatus = HttpStatus.OK;
				return courseRepository.findAll();
			} else if (operationType.equals("donation")) {
				httpStatus = HttpStatus.OK;
				return donationRepository.findAll();
			} else if (operationType.equals("ePurchase")) {
				httpStatus = HttpStatus.OK;
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
	public Object studentProfile(StudentRequest studentDto) {
		httpStatus = HttpStatus.OK;
		StudentModel std = studentRepository.getStudentById(studentDto.getStudentId());
		return new ResponseEntity<>(std, httpStatus);
	}
	
	public Object studentDonation(StudentRequest studentDto) {
		List<DonationModel> std = donationRepository.getDonationByStudentId(studentDto.getStudentId());
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(std, httpStatus);
	}
	
	public Object studentPurchase(StudentRequest studentDto) {
		List<EPurchaseInformation> std = epurchaseInformation.getPurchaseByStudentId(studentDto.getStudentId());
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(std, httpStatus);
	}
	
	public Object studentVolunter(StudentRequest studentDto) {
		List<VolunteerModel> std = volunteerRepository.getVolunteerByStudentId(studentDto.getStudentId());
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(std, httpStatus);
	}

}
