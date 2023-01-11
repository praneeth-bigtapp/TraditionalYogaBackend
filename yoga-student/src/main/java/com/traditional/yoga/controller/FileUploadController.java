package com.traditional.yoga.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.traditional.yoga.service.WebSiteManagementService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/upload", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
public class FileUploadController {

//	private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);
//
//	@Autowired
//	private HttpServletRequest request;
//
//	@Autowired
////	WebSiteManagementService webSiteManagementService;
//
//	/**
//	 * Authentication for Generated Token
//	 * 
//	 * @param token
//	 */
//	private void authenticate(String token) {
//		LOG.debug(token);
//		LOG.info("Validating the Token");
//	}
//
////	Photo Gallery
//	@PostMapping("/photoGallery")
//	public Object gallaryPhoto(@RequestHeader("token") String token,
//			@RequestParam(required = true, value = "picture") MultipartFile file) {
//		authenticate(token);
//		LOG.info("Hello");
//		return webSiteManagementService.uploadGallary(file, request);
//	}
}
