package com.traditional.yoga.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.dto.request.GrattitudeMessageRequest;
import com.traditional.yoga.model.NotificationModel;
import com.traditional.yoga.service.StudentModuleService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/studentModule", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentModuleController {

	private static final Logger LOG = LoggerFactory.getLogger(StudentModuleController.class);
	
	@Autowired
	StudentModuleService studentModuleService;
	
	
    public static final String PAST_COURSES = "pastCourses";
    
	@GetMapping("/getAll")
	public Object getAllStudentDetails(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return studentModuleService.getAll(operation);
	}
	
	@PostMapping("/Grattitdue-message")
	public Object managemessage(@RequestHeader("token") String token, @RequestBody GrattitudeMessageRequest messageDto,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return studentModuleService.manageMessage(operation, messageDto);
	}

	 @GetMapping("pastcourses/{studentId}")
	    public Object getPastCourses(@PathVariable int studentId) {
	        return studentModuleService.getPastCourses(studentId);
	    }
	
	 
	 @GetMapping("/notification/{categoryId}")
	    public List<NotificationModel> getNotificationByCategoryId(@PathVariable int categoryId) {
	        return studentModuleService.getNotificationByCategoryId(categoryId);
	    }
}
