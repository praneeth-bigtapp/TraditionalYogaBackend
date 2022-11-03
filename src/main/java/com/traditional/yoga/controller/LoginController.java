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
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.dto.request.ChangePasswordRequest;
import com.traditional.yoga.dto.request.LoginRequest;
import com.traditional.yoga.service.LoginService;

@CrossOrigin("*")
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public Object loginUser(@RequestBody LoginRequest userDetails) {
		LOG.info("Entering into loginUser Method");
		return loginService.loginUser(userDetails);
	}

	@GetMapping("/logout")
	public Object logoutUser() {
		LOG.info("Entering into logoutUser Method");
		return null;
	}

	@PostMapping("/changePassword")
	public Object changePassword(@RequestHeader("token") String token,
			@RequestBody ChangePasswordRequest passwordRequest) {
		LOG.info("Entering into changePassword Method");
		return null;
	}
}
