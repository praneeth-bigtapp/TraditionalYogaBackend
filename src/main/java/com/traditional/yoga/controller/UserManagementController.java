package com.traditional.yoga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserManagementController {

	private static final Logger LOG = LoggerFactory.getLogger(UserManagementController.class);

	private void authenticate(String token) {
		LOG.debug(token);
		LOG.info("Validating the Token");
//		authResponse = (Response) jwtTokenUtil.validateUserToken(token);
	}

	@GetMapping("/getAll")
	public Object getAllDetails(@RequestHeader("token") String token, @RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		authenticate(token);
		return null;
	}
}
