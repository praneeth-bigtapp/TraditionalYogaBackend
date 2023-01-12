package com.traditional.yoga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.service.DashBoardService;

@CrossOrigin("*")
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DashboardController {

	private static final Logger LOG = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	DashBoardService dashBoardService;

	@GetMapping("/getAll")
	public Object getDashboard(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return dashBoardService.getAll(operation);
	}
	
	@GetMapping("/dashboard")
	public Object manageDashboard(@RequestHeader("token") String token,
			@RequestParam("studentId") int studentId) {
		LOG.info("Entering into getAll{} Method", studentId);
		return dashBoardService.manageDashboard(studentId);
	}
	
	@GetMapping("/courseDetails")
	public Object manageCourseDetails(@RequestHeader("token") String token,
			@RequestParam("courseId") int courseId) {
		LOG.info("Entering into getAll{} Method", courseId);
		return dashBoardService.manageCourseDetails(courseId);
	}
	
	@GetMapping("/course/watchHours")
	public Object manageWatchHours(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return dashBoardService.manageWatchHours(operation);
	}
}
