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

import com.traditional.yoga.dto.request.CourseMediaPracticeRequest;
import com.traditional.yoga.dto.request.CourseMediaRequest;
import com.traditional.yoga.dto.request.CourseRequest;
import com.traditional.yoga.dto.request.PerformaceRatingRequest;
import com.traditional.yoga.service.CourseManagementService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseManagementController {

	private static final Logger LOG = LoggerFactory.getLogger(CourseManagementController.class);

	@Autowired
	CourseManagementService courseManagementService;

	@GetMapping("/getAll")
	public Object getAllStudentDetails(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll {} Method", operation);
		return courseManagementService.getAll(operation);
	}

//	Course
	@PostMapping("/addCourse")
	public Object courseManage(@RequestHeader("token") String token, @RequestBody CourseRequest courseDto) {
		LOG.info("Entering into Course");
		return courseManagementService.addCourse(courseDto);
	}

	@PostMapping("/addCourseMedia")
	public Object courseMediaManage(@RequestHeader("token") String token,
			@RequestBody CourseMediaRequest courseMediaDto, @RequestParam("type") String type) {
		LOG.info("Entering into Course Media");
		return courseManagementService.courseMediaManage(courseMediaDto, type);
	}

	@PostMapping("/addCourseMediaPractice")
	public Object courseMediaPraticeManage(@RequestHeader("token") String token,
			@RequestBody CourseMediaPracticeRequest courseMediaDto) {
		LOG.info("Entering into Course Media");
		return courseManagementService.courseMediaPraticeManage(courseMediaDto);
	}

//	Parameters performance rating
	@GetMapping("/performance/data")
	public Object getRating(@RequestHeader("token") String token, @RequestParam("courseId") int courseId) {
		LOG.info("Entering into getAll Method");
		return courseManagementService.getRating(courseId);
	}

	@PostMapping("/performance/updateRating")
	public Object manageRating(@RequestHeader("token") String token,
			@RequestBody PerformaceRatingRequest performanceRatingDto) {
		LOG.info("Entering into getAll Method");
		return courseManagementService.manageRating(performanceRatingDto);
	}

}
