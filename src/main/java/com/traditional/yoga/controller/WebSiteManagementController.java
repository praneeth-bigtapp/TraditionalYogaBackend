package com.traditional.yoga.controller;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.MultipartFile;

import com.traditional.yoga.dto.request.AlertRequest;
import com.traditional.yoga.dto.request.BannerViewRequest;
import com.traditional.yoga.dto.request.NotificationRequest;
import com.traditional.yoga.dto.request.PageRequest;
import com.traditional.yoga.dto.request.PearlsOfWisdomRequest;
import com.traditional.yoga.dto.request.PhotoGalleryRequest;
import com.traditional.yoga.dto.request.RegionRequest;
import com.traditional.yoga.dto.request.ScripcturesRequest;
import com.traditional.yoga.service.WebSiteManagementService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/webSite", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class WebSiteManagementController {

	private static final Logger LOG = LoggerFactory.getLogger(WebSiteManagementController.class);

	@Autowired
	private HttpServletRequest request;

	@Autowired
	WebSiteManagementService webSiteManagementService;

	/**
	 * Authentication for Generated Token
	 * 
	 * @param token
	 */
	private void authenticate(String token) {
		LOG.debug(token);
		LOG.info("Validating the Token");
	}
	
	@GetMapping("/getAll")
	public Object getAllalertdetails(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll {} Method in Web Site Management", operation);
		return webSiteManagementService.getAll(operation);
	}

	@PostMapping("/alerts")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody AlertRequest alertDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into Alert {} Method in Web Site Management", operation);
		return webSiteManagementService.alertManage(operation, alertDto);
	}

	@PostMapping("/banner")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody BannerViewRequest bannerViewdto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return webSiteManagementService.bannerMange(operation, bannerViewdto);
	}

	@PostMapping("/scripctures")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody ScripcturesRequest scripcuturesdto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return webSiteManagementService.managescripcutures(operation, scripcuturesdto);
	}

	@PostMapping("/notifcation")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody NotificationRequest notificationdto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return webSiteManagementService.managenotification(operation, notificationdto);
	}

	@PostMapping("/page")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody PageRequest pagedto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return webSiteManagementService.managepage(operation, pagedto);
	}

	@PostMapping("/region")
	public Object regionMange(@RequestHeader("token") String token, @RequestBody RegionRequest regiondto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return webSiteManagementService.regionMange(operation, regiondto);
	}

//	Photo Gallery
	@PostMapping("/photoUpload")
	public Object gallaryPhoto(@RequestHeader("token") String token,
			@RequestParam(required = true, value = "picture") MultipartFile file) {
		LOG.info("Hello");
		return webSiteManagementService.uploadGallary(file, request);
	}

	@PostMapping("/createGallary")
	public Object createGallary(@RequestHeader("token") String token,
			@RequestBody PhotoGalleryRequest photoGalleryRequestDto) {
		LOG.info("Creating a new gallery");
		return webSiteManagementService.createGallary(photoGalleryRequestDto);
	}
	
	
	@PostMapping("/wisdom")
	public Object managewisdom(@RequestHeader("token") String token, @RequestBody PearlsOfWisdomRequest wisdomdto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return webSiteManagementService.managewisdom(operation, wisdomdto);
	}
}
