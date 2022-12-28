package com.traditional.yoga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.dto.request.RegistrationRequest;
import com.traditional.yoga.service.RegisterService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	RegisterService registerService;

	@GetMapping("/getAll")
	public Object getAllRegsiterDetails(@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return registerService.getAll(operation);
	}
	
	@PostMapping("/enroll")	
	public Object enrollment(@RequestBody RegistrationRequest registrationDto) {
		LOG.info("Entering into register Method");
		return registerService.enrollBasicStudent(registrationDto);
	}
	
	@PostMapping("/enrollDetailed")
	public Object enrollmentFull(@RequestBody RegistrationRequest registrationDto) {
		LOG.info("Entering into register Method");
		return registerService.enrollFullStudent(registrationDto);
	}
}
