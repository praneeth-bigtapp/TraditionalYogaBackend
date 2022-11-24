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
import com.traditional.yoga.dto.request.BannerViewRequest;
import com.traditional.yoga.service.WebSiteManagementService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/webSite", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class WebSiteManagementController {

	private static final Logger LOG = LoggerFactory.getLogger(WebSiteManagementController.class);

	@Autowired
	WebSiteManagementService webSiteManagementService;

	@GetMapping("/getAll")
	public Object getAllalertdetails(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		LOG.info("Entering into getAll {} Method in Web Site Management", operation);
		return webSiteManagementService.getAll(operation);
	}

	@PostMapping("/alerts")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody AlertRequest alertDto,
			@RequestParam("operation") String operation) {
//		authenticate(token);
		LOG.info("Entering into Alert {} Method in Web Site Management", operation);
		return webSiteManagementService.alertManage(operation, alertDto);
	}

	@PostMapping("/banner")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody BannerViewRequest BannerViewdto,
			@RequestParam("operation") String operation) {
//		authenticate(token);
		return webSiteManagementService.bannerMange(operation, BannerViewdto);
	}

}
