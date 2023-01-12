package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.request.LoggingRequest;
import com.traditional.yoga.dto.response.LoggingResponse;

@Service
public class LoggingService {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingService.class);

	LoggingResponse response = new LoggingResponse();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;


//	Forgot Password
	public Object forgotPassword(LoggingRequest userDetails) {
		LOG.info("This is : {}", userDetails);
		return new ResponseEntity<>(response, httpStatus);
	}

}
