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

import com.traditional.yoga.dto.request.AlertRequest;
import com.traditional.yoga.dto.request.BlackListRequest;
import com.traditional.yoga.service.BlacklistUserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/blacklistuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class BlackListUserController {
	private static final Logger LOG = LoggerFactory.getLogger(BlackListUserController.class);

	@Autowired
	BlacklistUserService blacklistUserService;

	@GetMapping("/getAll")
	public Object getAllalertdetails(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		return blacklistUserService.getAll(operation);
	}
	
	@PostMapping("/")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody   BlackListRequest blacklistdto,
			@RequestParam("operation") String operation) {
//		authenticate(token);
		return blacklistUserService.blacklistmanage(operation, blacklistdto);
	}
}
