package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.ChiefMentorDetails;
import com.traditional.yoga.dto.GratitudeMessages;
import com.traditional.yoga.dto.MentorDetails;
import com.traditional.yoga.dto.Notifications;
import com.traditional.yoga.dto.PerformanceReport;
import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.response.DashBoardResponse;
import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.RegisteredStudentModel;
import com.traditional.yoga.repository.ClassMediaLiveClassRepository;
import com.traditional.yoga.repository.ClassMediaShortVideoRepository;
import com.traditional.yoga.repository.CoursesListRepository;
import com.traditional.yoga.repository.PraticeLibaryRepository;
import com.traditional.yoga.repository.RegisteredStudentRepository;
import com.traditional.yoga.repository.RegistrationRepository;

@Service
public class DashBoardService {

	private static final Logger LOG = LoggerFactory.getLogger(DashBoardService.class);

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	RegisteredStudentRepository registeredStudentRepository;

	@Autowired
	CoursesListRepository coursesListRepository;

	@Autowired
	ClassMediaLiveClassRepository classMediaLiveClassRepository;

	@Autowired
	ClassMediaShortVideoRepository classMediaShortVideoRepository;

	@Autowired
	PraticeLibaryRepository praticeLibaryRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Student related {} data", operationType);
		try {
			if (operationType.equals("")) {
				httpStatus = HttpStatus.OK;
				return null;
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

//	Dashboard
	public Object manageDashboard(int studentId) {
		DashBoardResponse dashboard = new DashBoardResponse();
		MentorDetails mentor = new MentorDetails();
		ChiefMentorDetails chiefMentor = new ChiefMentorDetails();
		PerformanceReport performance = new PerformanceReport();
		GratitudeMessages gratitude = new GratitudeMessages();
		Notifications notifications = new Notifications();
		try {
			RegisteredStudentModel std = registeredStudentRepository.getRegisteredByStudentId(studentId);

//			Mentor
			String fNameMentor = std.getMentorId().getFirstName();
			String lNameMentor = std.getMentorId().getLastName();
			String fullNameMentor = fNameMentor + " " + lNameMentor;
			mentor.setMentorId(std.getMentorId().getRegistrationId());
			mentor.setMentorName(fullNameMentor);
			mentor.setMentorNumber(std.getMentorId().getMobileNumber());
			dashboard.setMentor(mentor);

//			Chief Mentor
			String fNameChiefMentor = std.getMentorId().getFirstName();
			String lNameChiefMentor = std.getMentorId().getLastName();
			String fullNameChiefMentor = fNameChiefMentor + " " + lNameChiefMentor;
			chiefMentor.setChiefMentorId(std.getMentorId().getRegistrationId());
			chiefMentor.setChiefMentorName(fullNameChiefMentor);
			chiefMentor.setChiefMentorNumber(std.getMentorId().getMobileNumber());
			dashboard.setChiefMentorDetails(chiefMentor);
			httpStatus = HttpStatus.OK;
			return new ResponseEntity<>(dashboard, httpStatus);
		} catch (Exception e) {
			message = "Unknown Error";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

//	Course Details
	public Object manageCourseDetails(int courseId) {
		try {
			CourseListModel course = coursesListRepository.getcoursesListById(courseId);
			httpStatus = HttpStatus.OK;
			return new ResponseEntity<>(course, httpStatus);
		} catch (Exception e) {
			message = "Unknown Error";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

//	Course Details
	public Object manageWatchHours(String operation) {
		try {
			if (operation.equals("liveClasses")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(classMediaLiveClassRepository.findAll(), httpStatus);
			} else if (operation.equals("shortVideo")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(classMediaShortVideoRepository.findAll(), httpStatus);
			} else if (operation.equals("praticeLibrary")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(praticeLibaryRepository.findAll(), httpStatus);
			} else {
				message = "Unknown Operation";
				httpStatus = HttpStatus.NOT_ACCEPTABLE;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
				return new ResponseEntity<>(response, httpStatus);
			}

		} catch (Exception e) {
			message = "Exception Error";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

}
