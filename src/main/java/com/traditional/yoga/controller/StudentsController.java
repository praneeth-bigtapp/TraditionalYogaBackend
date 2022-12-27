package com.traditional.yoga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.dto.request.BlackListRequest;
import com.traditional.yoga.dto.request.DonationRequest;
import com.traditional.yoga.dto.request.EPurchaseRequest;
import com.traditional.yoga.dto.request.StudentRequest;
import com.traditional.yoga.dto.request.VolunteerRequest;
import com.traditional.yoga.service.StudentService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsController {

	private static final Logger LOG = LoggerFactory.getLogger(StudentsController.class);

	@Autowired
	StudentService studentService;

	@GetMapping("/getAll")
	public Object getAllStudentDetails(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return studentService.getAll(operation);
	}

	@GetMapping("/getAllByCourse")
	public Object getAllStudentByCourse(@RequestHeader("token") String token, @RequestParam("type") String type,
			@RequestParam("courseId") int courseId) {
		LOG.info("Entering into getAll Method");
		return studentService.getAllByCourse(type, courseId);
	}

	@PostMapping("/profile")
	public Object getStudentDetails(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Entering into get Student Method");
		return studentService.studentProfile(studentDto);
	}

	@PostMapping("/donation")
	public Object getStudentDonation(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Entering into get donation Method");
		return studentService.studentDonation(studentDto);
	}

	@PostMapping("/purchase")
	public Object getStudentPurchase(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Entering into get purchase Method");
		return studentService.studentPurchase(studentDto);
	}
	
	@PostMapping("/courseProfile")
	public Object getStudentProfile(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Entering into get purchase Method");
		return studentService.studentCourseProfile(studentDto);
	}

	@PostMapping("/purchase/add")
	public Object addStudentPurchase(@RequestHeader("token") String token, @RequestBody EPurchaseRequest purchaseDto) {
		LOG.info("Entering into get purchase Method");
		return studentService.addStudentPurchase(purchaseDto);
	}

	@PostMapping("/volunteer")
	public Object getStudentVolunter(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Entering into get volunter Method");
		return studentService.studentVolunter(studentDto);
	}

	@PostMapping("/volunteer/add")
	public Object addStudentVolunter(@RequestHeader("token") String token, @RequestBody VolunteerRequest volunteerDto) {
		LOG.info("Entering into add volunter Method");
		return studentService.addStudentVolunter(volunteerDto);
	}

	@PostMapping("/blockListUsers")
	public Object manageBlockListUsers(@RequestHeader("token") String token, @RequestBody BlackListRequest blockListDto,
			@RequestParam("operation") String operation) {
		return studentService.blockListUsersManage(operation, blockListDto);
	}

	@PostMapping("/donationView")
	public Object getDonation(@RequestHeader("token") String token, @RequestBody DonationRequest donationDto) {
		LOG.info("Entering into get donation Method");
		return studentService.viewDonation(donationDto);
	}

	@PostMapping("/mapUserCourse")
	public Object mapStudent(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Entering into get volunter Method");
		return studentService.mapStudentCourse(studentDto);
	}

	@PostMapping("/mapMentor")
	public Object mapMentor(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Mapping mentor to students");
		return studentService.mapStudentMentor(studentDto);
	}

	@PostMapping("/mapChiefMentor")
	public Object mapChiefMenber(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Mapping chief mentor to students");
		return studentService.mapStudentChiefMentor(studentDto);
	}
	
	@PostMapping("/mapMentorRegion")
	public Object mapMenberRegion(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Mapping Region to Mentor to students");
		return studentService.mapRegionMentor(studentDto);
	}

}
