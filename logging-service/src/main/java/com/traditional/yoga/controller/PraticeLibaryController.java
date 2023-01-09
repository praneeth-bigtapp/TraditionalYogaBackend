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

import com.traditional.yoga.dto.request.ClassMediaGlipmses;
import com.traditional.yoga.dto.request.ClassMediaLiveclassRequest;
import com.traditional.yoga.dto.request.ClassMediaShortVideoRequest;
import com.traditional.yoga.dto.request.LanguageRequest;
import com.traditional.yoga.dto.request.PraticeLibaryRequest;
import com.traditional.yoga.service.PraticeLibaryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/libary", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PraticeLibaryController {

	private static final Logger LOG = LoggerFactory.getLogger(PraticeLibaryController.class);

	@Autowired
	PraticeLibaryService praticeLibaryService;

	/**
	 * Authentication for Generated Token
	 * 
	 * @param token
	 */
	private void authenticate(String token) {
		LOG.debug(token);
		LOG.info("Validating the Token");
	}

	@GetMapping("/getAllLibary")
	public Object getLibaryDetails(@RequestHeader("token") String token, @RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		authenticate(token);
		return praticeLibaryService.getAll(operation);
	}

	@PostMapping("/praticeLibary")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody PraticeLibaryRequest praticelibaryDto,
			@RequestParam("operation") String operation, @RequestParam("type") String type) {
		authenticate(token);
		return praticeLibaryService.managelibary(operation, type, praticelibaryDto);
	}

	@PostMapping("/language")
	public Object managelangauge(@RequestHeader("token") String token, @RequestBody LanguageRequest languageDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return praticeLibaryService.managelangauge(operation, languageDto);
	}

	@PostMapping("/liveClass")
	public Object manageClassMediaLive(@RequestHeader("token") String token,
			@RequestBody ClassMediaLiveclassRequest classDto, @RequestParam("operation") String operation) {
		authenticate(token);
		return praticeLibaryService.manageClassMediaLive(operation, classDto);
	}

	@PostMapping("/shortVideo")
	public Object manageClassMediaLive(@RequestHeader("token") String token,
			@RequestBody ClassMediaShortVideoRequest shortDto, @RequestParam("operation") String operation) {
		authenticate(token);
		return praticeLibaryService.manageShortVideo(operation, shortDto);
	}

	@PostMapping("/glimpses")
	public Object manageGlimpses(@RequestHeader("token") String token, @RequestBody ClassMediaGlipmses glimpsesDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return praticeLibaryService.manageGlimpses(operation, glimpsesDto);
	}
}
