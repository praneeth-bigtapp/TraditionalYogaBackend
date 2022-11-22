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

import com.traditional.yoga.dto.request.StudentRequest;
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
	
	@PostMapping("/volunteer")
	public Object getStudentVolunter(@RequestHeader("token") String token, @RequestBody StudentRequest studentDto) {
		LOG.info("Entering into get volunter Method");
		return studentService.studentVolunter(studentDto);
	}

}
