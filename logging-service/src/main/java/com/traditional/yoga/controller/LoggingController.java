package com.traditional.yoga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.dto.request.LoggingRequest;
import com.traditional.yoga.service.LoggingService;

@CrossOrigin("*")
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoggingController {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingController.class);
	
	@Autowired
	LoggingService loginService;

	@PostMapping("/loggers")
	public Object forgotPassword(@RequestBody LoggingRequest passwordRequest) {
		LOG.info("Entering into Forgot Password Method");
		return loginService.forgotPassword(passwordRequest);
	}
	
	
}
