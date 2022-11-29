package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.AlertRequest;
import com.traditional.yoga.dto.request.BannerViewRequest;
import com.traditional.yoga.dto.request.ScripcturesRequest;
import com.traditional.yoga.model.AlertModel;
import com.traditional.yoga.model.BannerViewModel;
import com.traditional.yoga.model.ScripcturesModel;
import com.traditional.yoga.repository.AlertRepository;
import com.traditional.yoga.repository.BannerViewRepository;
import com.traditional.yoga.repository.ScripcturesRepository;

@Service
public class WebSiteManagementService {

	private static final Logger LOG = LoggerFactory.getLogger(WebSiteManagementService.class);

	@Autowired
	AlertRepository alertRepository;

	@Autowired
	BannerViewRepository bannerRepository;

	@Autowired
	ScripcturesRepository scripcturesRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Web Site Management related {} data", operationType);
		try {
			if (operationType.equals("pages")) {
				httpStatus = HttpStatus.OK;
//				return studentRepository.findAll();
			} else if (operationType.equals("photoGallery")) {
				httpStatus = HttpStatus.OK;
//				return courseRepository.findAll();
			} else if (operationType.equals("videoGallery")) {
				httpStatus = HttpStatus.OK;
//				return donationRepository.findAll();
			} else if (operationType.equals("testimonials")) {
				httpStatus = HttpStatus.OK;
//				return epurchaseInformation.findAll();
			} else if (operationType.equals("banner")) {
				httpStatus = HttpStatus.OK;
				return bannerRepository.findAll();
			} else if (operationType.equals("alerts")) {
				httpStatus = HttpStatus.OK;
				return alertRepository.findAll();
			} else if (operationType.equals("alertCategory")) {
				httpStatus = HttpStatus.OK;
//				return alertRepository.findAll();
			} else if (operationType.equals("scripctures")) {
				httpStatus = HttpStatus.OK;
				return scripcturesRepository.findAll();
			} else {
				message = "Unknown Operation";
				httpStatus = HttpStatus.NOT_ACCEPTABLE;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
				return new ResponseEntity<>(response, httpStatus);
			}

		} catch (Exception e) {
			message = "Unknown Error";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
		return new ResponseEntity<>(response, httpStatus);
	}

//	Alerts
	public Object alertManage(String operation, AlertRequest alertdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals("add")) {
				AlertModel newAlert = new AlertModel();
				newAlert.setCategoryId(alertdto.getCategoryId());
				newAlert.setAlertDescription(alertdto.getAlertDescription());
				newAlert.setStartDate(alertdto.getStartDate());
				newAlert.setEndDate(alertdto.getEndDate());
				alertRepository.save(newAlert);
				message = "New Alert added Sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in alert";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

//	Banner
	public Object bannerMange(String operation, BannerViewRequest bannerViewdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals("add")) {
				BannerViewModel bannernew = bannerRepository.getbannerbyId(bannerViewdto.getBannerId());
				if (bannernew == null) {
					BannerViewModel bannerList = new BannerViewModel();
//					bannerList.setBannerId(bannerViewdto.getBannerId());
					bannerList.setCategoryId(bannerViewdto.getCategoryId());
					bannerList.setBannerName(bannerViewdto.getBannerName());
					bannerList.setDate(bannerList.getDate());

					bannerRepository.save(bannerList);
					message = "new banner is  added sucessfully";
					LOG.info(message);
					response = new Response(message, httpStatus.value(), null);
				}
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in banner creation";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	public Object managescripcutures(String operation, ScripcturesRequest scripcuturesdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals("add")) {
				ScripcturesModel scripcturesModelnew = scripcturesRepository.checkscripcturesId(scripcuturesdto.getScripcturesId());
				if (scripcturesModelnew == null) {
					ScripcturesModel scripctureslist = new ScripcturesModel();
//					scripctureslist.setScripcturesId(scripcuturesdto.getScripcturesId());
					scripctureslist.setUploadFile(scripcuturesdto.getUploadFile());
					scripctureslist.setCoverImage(scripcuturesdto.getCoverImage());
					scripctureslist.setTitle(scripcuturesdto.getTitle());
					scripctureslist.setDescription(scripcuturesdto.getDescription());
					scripctureslist.setMetaKeyWords(scripcuturesdto.getMetaKeyWords());
					
					scripcturesRepository.save(scripctureslist);
					message = "new scripctures is  added sucessfully";
					LOG.info(message);
					response = new Response(message, httpStatus.value(), null);
				} else {
					message = "Operation Doesn't exist";
					httpStatus = HttpStatus.CONFLICT;
					LOG.error(message);
					response = new Response(message, httpStatus.value(), message);
				}
			}
		} catch (Exception e) {
			message = "Exception in scriptures creation";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);

	}
}
