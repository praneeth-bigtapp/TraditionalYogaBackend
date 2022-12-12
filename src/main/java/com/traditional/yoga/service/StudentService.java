package com.traditional.yoga.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.BlackListRequest;
import com.traditional.yoga.dto.request.DonationRequest;
import com.traditional.yoga.dto.request.EPurchaseRequest;
import com.traditional.yoga.dto.request.StudentRequest;
import com.traditional.yoga.dto.request.VolunteerRequest;
import com.traditional.yoga.dto.response.MemberResponse;
import com.traditional.yoga.model.BlackListModel;
import com.traditional.yoga.model.CourseModel;
import com.traditional.yoga.model.DonationModel;
import com.traditional.yoga.model.EPurchaseInformation;
import com.traditional.yoga.model.StudentModel;
import com.traditional.yoga.model.VolunteerModel;
import com.traditional.yoga.repository.BlackListUserRepository;
import com.traditional.yoga.repository.CourseRepository;
import com.traditional.yoga.repository.DonationRepository;
import com.traditional.yoga.repository.EpurchaseInformation;
import com.traditional.yoga.repository.StudentRepository;
import com.traditional.yoga.repository.VolunteerRepository;
import com.traditional.yoga.utils.GeneralUtils;

@Service
public class StudentService {

	private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	GeneralUtils generalUtils;

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

	@Autowired
	BlackListUserRepository blackListUserRepository;

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
			} else if (operationType.equals("blackListUser")) {
				httpStatus = HttpStatus.OK;
				return blackListUserRepository.findAll();
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

//	By course
	public Object getAllByCourse(String operationType, int courseId) {
		LOG.info("Fetching Student related {} data", operationType);

		try {
			int maxStd = studentRepository.getCountByCourseId(courseId);
			int mappedStd = studentRepository.getCountByMentor(courseId);
			int notMapped = maxStd - mappedStd;
			if (operationType.equals("member")) {
				MemberResponse member = new MemberResponse();
				member.setUserApplied(notMapped);
				member.setUserMapped(mappedStd);
				member.setStudents(studentRepository.getStudentByCourseId(courseId));
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(member, httpStatus);
			} else if (operationType.equals("mentor")) {
				MemberResponse member = new MemberResponse();
				member.setUserApplied(notMapped);
				member.setUserMapped(mappedStd);
				member.setStudents(studentRepository.getStudentByMentor(courseId));
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(member, httpStatus);
			} else if (operationType.equals("chiefMentor")) {
				LOG.info("Chief Mentor Map");
				MemberResponse member = new MemberResponse();
				member.setUserApplied(notMapped);
				member.setUserMapped(mappedStd);
				member.setStudents(studentRepository.getStudentByMentor(courseId));
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(member, httpStatus);
			}  else {
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

//	Donation
	public Object studentDonation(StudentRequest studentDto) {
		List<DonationModel> std = donationRepository.getDonationByStudentId(studentDto.getStudentId());
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(std, httpStatus);
	}

	public Object viewDonation(DonationRequest donationDto) {
		DonationModel std = donationRepository.getDonationById(donationDto.getDonationId());
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(std, httpStatus);
	}

//	E Purchase
	public Object studentPurchase(StudentRequest studentDto) {
		List<EPurchaseInformation> std = epurchaseInformation.getPurchaseByStudentId(studentDto.getStudentId());
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(std, httpStatus);
	}

	public Object addStudentPurchase(EPurchaseRequest purchaseDto) {
		EPurchaseInformation newPurchase = new EPurchaseInformation();
		newPurchase.setDate(purchaseDto.getDate());
		newPurchase.setStudentId(purchaseDto.getStudentId());
		newPurchase.setPurchaseAmount(purchaseDto.getPurchaseAmount());
		newPurchase.setProductPurchase(purchaseDto.getProductPurchase());
		epurchaseInformation.save(newPurchase);

		httpStatus = HttpStatus.OK;
		message = "Purchase added sucessfully";
		LOG.info(message);
		response = new Response(message, httpStatus.value(), null);
		return new ResponseEntity<>(response, httpStatus);
	}

//	Volunteer
	public Object studentVolunter(StudentRequest studentDto) {
		List<VolunteerModel> std = volunteerRepository.getVolunteerByStudentId(studentDto.getStudentId());
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(std, httpStatus);
	}

	public Object addStudentVolunter(VolunteerRequest volunteerDto) {
		VolunteerModel newVolunteer = new VolunteerModel();
		newVolunteer.setStudentId(volunteerDto.getStudentId());
		newVolunteer.setCategoryName(volunteerDto.getCategoryName());
		newVolunteer.setCourseId(volunteerDto.getCourseId());
		newVolunteer.setStartDate(volunteerDto.getStartDate());
		newVolunteer.setEndDate(volunteerDto.getEndDate());
		newVolunteer.setServedAs(volunteerDto.getServedAs());
		newVolunteer.setNoOfMembers(volunteerDto.getNoOfMembers());
		volunteerRepository.save(newVolunteer);

		httpStatus = HttpStatus.OK;
		message = "Volunter added sucessfully";
		LOG.info(message);
		response = new Response(message, httpStatus.value(), null);
		return new ResponseEntity<>(response, httpStatus);
	}

//	Block List Users
	public Object blockListUsersManage(String operation, BlackListRequest blockListDto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals("add")) {
				addBlockListUser(blockListDto);
			} else if (operation.equals("delete")) {
				deleteBlockListUser(blockListDto);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in blacklistuser";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addBlockListUser(BlackListRequest blockListDto) {
		BlackListModel blackListNew = blackListUserRepository.getBlackListByEmail(blockListDto.getBlacklistUserEmail());
		if (blackListNew == null) {
			BlackListModel newList = new BlackListModel();
			newList.setBlacklistUserEmail(blockListDto.getBlacklistUserEmail());
			newList.setComments(blockListDto.getComments());
			newList.setDate(generalUtils.getCurrentDate());
			blackListUserRepository.save(newList);
			httpStatus = HttpStatus.OK;
			message = "new blacklist user is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "User mail id Already is in Backlist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteBlockListUser(BlackListRequest blockListDto) {
		BlackListModel blacklistDb = blackListUserRepository.getBlackListById(blockListDto.getBlacklistuserId());
		if (blacklistDb != null) {
			blackListUserRepository.deleteById(blockListDto.getBlacklistuserId());
			httpStatus = HttpStatus.OK;
			message = "BlackListUser deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "backlistuser Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

//	Map User To Course
	public Object mapStudentCourse(StudentRequest studentDto) {
		StudentModel mapCourse = studentRepository.getStudentById(studentDto.getStudentId());
		if (mapCourse != null) {
			CourseModel course = new CourseModel();
			mapCourse.setStudentCategory(studentDto.getStudentCategory());
			course.setCourseId(studentDto.getCourseId());
			mapCourse.setCourseId(course);
			studentRepository.save(mapCourse);
			httpStatus = HttpStatus.OK;
			message = "Student Mapped sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
			return new ResponseEntity<>(response, httpStatus);
		} else {
			message = "Student details Doesn't exist, So Course is unable to map";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
			return new ResponseEntity<>(response, httpStatus);
		}
	}

//	Map User to Mentor
	public Object mapStudentMentor(StudentRequest studentDto) {
		StudentModel mapMentor = studentRepository.getStudentById(studentDto.getStudentId());
		if (mapMentor != null) {
			mapMentor.setMentorId(studentDto.getMentorId());
			studentRepository.save(mapMentor);
			httpStatus = HttpStatus.OK;
			message = "User Mapped to Mentor sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
			return new ResponseEntity<>(response, httpStatus);
		} else {
			message = "Student details Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
			return new ResponseEntity<>(response, httpStatus);
		}
	}

//	Map User to Chief Mentor
	public Object mapStudentChiefMentor(StudentRequest studentDto) {
		StudentModel mapCourse = studentRepository.getStudentById(studentDto.getStudentId());
		if (mapCourse != null) {
			mapCourse.setChiefMentorId(studentDto.getChiefMentorId());
			studentRepository.save(mapCourse);
			httpStatus = HttpStatus.OK;
			message = "User Mapped to Chief Mentor sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
			return new ResponseEntity<>(response, httpStatus);
		} else {
			message = "Student details Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
			return new ResponseEntity<>(response, httpStatus);
		}
	}
	
//	Map Region to Mentor
	public Object mapRegionMentor(StudentRequest studentDto) {
		StudentModel mapCourse = studentRepository.getStudentById(studentDto.getStudentId());
		if (mapCourse != null) {
			mapCourse.setMentorRegion(studentDto.getMentorRegion());
			studentRepository.save(mapCourse);
			httpStatus = HttpStatus.OK;
			message = "Mentor Region is Mapped sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
			return new ResponseEntity<>(response, httpStatus);
		} else {
			message = "Student details Doesn't exist for Mentor Region";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
			return new ResponseEntity<>(response, httpStatus);
		}
	}

}
