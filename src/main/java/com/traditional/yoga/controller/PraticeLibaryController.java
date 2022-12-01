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

import com.traditional.yoga.dto.request.PraticeLibaryRequest;
import com.traditional.yoga.service.PraticeLibaryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/libary", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PraticeLibaryController {

	private static final Logger LOG = LoggerFactory.getLogger(PraticeLibaryController.class);

	@Autowired
	PraticeLibaryService praticeLibaryService;

	@GetMapping("/getAllLibary")
	public Object getLibaryDetails(@RequestHeader("token") String token, @RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
//		authenticate(token);
		return praticeLibaryService.getAll(operation);
	}

	@PostMapping("/praticeLibary")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody PraticeLibaryRequest praticelibaryDto,
			@RequestParam("operation") String operation) {
//		authenticate(token);
		return praticeLibaryService.managelibary(operation, praticelibaryDto);
	}
}
