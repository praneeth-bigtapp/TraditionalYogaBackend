package com.traditional.yoga.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.traditional.yoga.model.RegistrationModel;
import com.traditional.yoga.service.RegisterService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	RegisterService registerService;

	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/getAll")
	public Object getAllRegsiterDetails(@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return registerService.getAll(operation);
	}
	
	@PostMapping("/enroll")	
	public Object enrollment(@RequestBody RegistrationRequest registrationDto) {
		LOG.info("Entering into register Method");
		String ipAddress = request.getRemoteAddr();
		return registerService.enrollBasicStudent(registrationDto, ipAddress);
	}
	
	@PostMapping("/enrollDetailed")
	public Object enrollmentFull(@RequestBody RegistrationRequest registrationDto) {
		LOG.info("Entering into register Method");
		return registerService.enrollFullStudent(registrationDto);
	}
	
	@PostMapping("/verifyEmail")
	public Object emailVerify(@RequestBody RegistrationRequest registrationDto) {
		LOG.info("Entering into email verification Method");
		return registerService.verifyEmail(registrationDto.getEmailId());
	}
	
//	@PostMapping("/otp")
//	public Object otpVerify(@RequestBody RegistrationRequest registrationDto) {
//		LOG.info("Entering into otp verification Method");
//		return "OPT validated";
//	}
	
	@GetMapping("/suspecousUsers")
	public List<RegistrationModel> getSuspecousUsers(
			@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "pinCode", required = false) String pinCode,
			@RequestParam(name = "address", required = false) String address) {
		return registerService.getSuspecousUsers(firstName, lastName, pinCode, address);
	}

}
