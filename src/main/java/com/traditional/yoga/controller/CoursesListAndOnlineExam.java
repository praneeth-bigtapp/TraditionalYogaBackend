package com.traditional.yoga.controller;

import javax.transaction.Transactional;

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

import com.traditional.yoga.dto.request.CourseRequest;
import com.traditional.yoga.dto.request.CoursesListRequest;
import com.traditional.yoga.dto.request.OnlineExamReqest;
import com.traditional.yoga.dto.request.UserRequest;
import com.traditional.yoga.service.CoursesandOnlineexamService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/courseList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CoursesListAndOnlineExam {
	
	private static final Logger LOG = LoggerFactory.getLogger(CourseManagementController.class);
	
	
	@Autowired
	CoursesandOnlineexamService coursesListService;
	
	
	@GetMapping("/getAll")
	public Object getAllStudentDetails(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return coursesListService.getAll(operation);
	}
	
	@PostMapping("/coursesList")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody CoursesListRequest courseListDto,
			@RequestParam("operation") String operation) {
//		authenticate(token);
		return coursesListService.managecourses(operation, courseListDto);
	}
	
	@PostMapping("/onlineexam")
	public Object onlineexams(@RequestHeader("token") String token, @RequestBody OnlineExamReqest onlineexamDto,
			@RequestParam("operation") String operation) {
//		authenticate(token);
		return coursesListService.onlineexams(operation, onlineexamDto);
	}
	
	
	

}
