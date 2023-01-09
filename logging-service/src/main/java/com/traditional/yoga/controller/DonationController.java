package com.traditional.yoga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.service.DonationService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/donation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DonationController {

	private static final Logger LOG = LoggerFactory.getLogger(DonationController.class);
	
	@Autowired
	DonationService donationService;
	
	@GetMapping("/getAll")
	public Object getAllStudentDetails(@RequestHeader("token") String token) {
		LOG.info("Entering into getAll Donation Method");
		return donationService.getAll();
	}
}
