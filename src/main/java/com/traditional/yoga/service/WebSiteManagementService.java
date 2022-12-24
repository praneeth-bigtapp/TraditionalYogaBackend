package com.traditional.yoga.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.AlertRequest;
import com.traditional.yoga.dto.request.BannerViewRequest;
import com.traditional.yoga.dto.request.NotificationRequest;
import com.traditional.yoga.dto.request.PageRequest;
import com.traditional.yoga.dto.request.PearlsOfWisdomRequest;
import com.traditional.yoga.dto.request.PhotoGalleryRequest;
import com.traditional.yoga.dto.request.RegionRequest;
import com.traditional.yoga.dto.request.ScripcturesRequest;
import com.traditional.yoga.model.AlertModel;
import com.traditional.yoga.model.BannerModel;
import com.traditional.yoga.model.NotificationModel;
import com.traditional.yoga.model.PageModel;
import com.traditional.yoga.model.PearlsOfWisdomModel;
import com.traditional.yoga.model.PhotoGalleryModel;
import com.traditional.yoga.model.RegionModel;
import com.traditional.yoga.model.ScripcturesModel;
import com.traditional.yoga.repository.AlertRepository;
import com.traditional.yoga.repository.BannerViewRepository;
import com.traditional.yoga.repository.CountryRepository;
import com.traditional.yoga.repository.ImageGalleryRepository;
import com.traditional.yoga.repository.MasterCountryRepository;
import com.traditional.yoga.repository.NoticationCategoryRepository;
import com.traditional.yoga.repository.NoticationRepository;
import com.traditional.yoga.repository.PageRepository;
import com.traditional.yoga.repository.PearlsOfWisdomRepository;
import com.traditional.yoga.repository.PhotoGalleryRepository;
import com.traditional.yoga.repository.RegionRepository;
import com.traditional.yoga.repository.ScripcturesRepository;
import com.traditional.yoga.utils.Constants;
import com.traditional.yoga.utils.GeneralUtils;

@Service
public class WebSiteManagementService {

	private static final Logger LOG = LoggerFactory.getLogger(WebSiteManagementService.class);

	@Autowired
	GeneralUtils generalUtils;

	@Autowired
	AlertRepository alertRepository;

	@Autowired
	BannerViewRepository bannerRepository;

	@Autowired
	ScripcturesRepository scripcturesRepository;

	@Autowired
	NoticationRepository noticationRepository;

	@Autowired
	NoticationCategoryRepository noticationCategoryRepository;

	@Autowired
	PageRepository pageRepository;

	@Autowired
	RegionRepository regionRepository;

	@Autowired
	PhotoGalleryRepository photoGalleryRepository;

	@Autowired
	ImageGalleryRepository imageGalleryRepository;

	@Autowired
	PearlsOfWisdomRepository pearlsOfWisdomRepository;

	@Autowired
	MasterCountryRepository masterCountryRepository;

	@Autowired
	CountryRepository countryRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Web Site Management related {} data", operationType);
		try {
			if (operationType.equals("pages")) {
				httpStatus = HttpStatus.OK;
				return null;
			} else if (operationType.equals("photoGallery")) {
				httpStatus = HttpStatus.OK;
				return photoGalleryRepository.findAll();
			} else if (operationType.equals("banner")) {
				httpStatus = HttpStatus.OK;
				return bannerRepository.findAll();
			} else if (operationType.equals("alerts")) {
				httpStatus = HttpStatus.OK;
				return alertRepository.findAll();
			} else if (operationType.equals("alertCategory")) {
				httpStatus = HttpStatus.OK;
				return "alerts Category";
			} else if (operationType.equals("scripctures")) {
				httpStatus = HttpStatus.OK;
				return scripcturesRepository.findAll();
			} else if (operationType.equals("notication")) {
				httpStatus = HttpStatus.OK;
				return noticationRepository.findAll();
			} else if (operationType.equals("noticationCategory")) {
				httpStatus = HttpStatus.OK;
				return noticationCategoryRepository.findAll();
			} else if (operationType.equals("page")) {
				httpStatus = HttpStatus.OK;
				return pageRepository.findAll();
			} else if (operationType.equals("wisdom")) {
				httpStatus = HttpStatus.OK;
				return pearlsOfWisdomRepository.findAll();
			} else if (operationType.equals("region")) {
				httpStatus = HttpStatus.OK;
				return regionRepository.findAll();
			} else if (operationType.equals("regionsList")) {
				httpStatus = HttpStatus.OK;
				return masterCountryRepository.findAll();
			} else if (operationType.equals("country")) {
				httpStatus = HttpStatus.OK;
				return countryRepository.findAll();
			} else {
				message = Constants.UNKNOWN_OPERATION;
				httpStatus = HttpStatus.NOT_ACCEPTABLE;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
				return new ResponseEntity<>(response, httpStatus);
			}

		} catch (Exception e) {
			message = Constants.EXCEPTION + " in Web site Manaement";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

	/////// ALERT ONLY ADD OPERATION /////////

	public Object manageAlert(String operation, AlertRequest alertdto) {

		try {
			if (operation.equals(Constants.ADD)) {
				addalert(alertdto);
			} else if (operation.equals(Constants.UPDATE)) {
				updateAlert(alertdto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteAlert(alertdto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = Constants.EXCEPTION + " in Alerts";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addalert(AlertRequest alertdto) {
		AlertModel newAlert = alertRepository.getalertById(alertdto.getAlertId());
		if (newAlert == null) {
			AlertModel newlist = new AlertModel();

			newlist.setCategoryId(alertdto.getCategoryId());
			newlist.setAlertDescription(alertdto.getAlertDescription());
			newlist.setStartDate(alertdto.getStartDate());
			newlist.setEndDate(alertdto.getEndDate());

			alertRepository.save(newlist);
			message = "new alert is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateAlert(AlertRequest alertDto) {
		AlertModel alertDb = alertRepository.getalertById(alertDto.getAlertId());
		if (alertDb != null) {
			alertDb.setCategoryId(alertDto.getCategoryId());
			alertDb.setAlertDescription(alertDto.getAlertDescription());
			alertDb.setStartDate(alertDto.getStartDate());
			alertDb.setEndDate(alertDto.getEndDate());
			alertRepository.save(alertDb);
			message = "alert updated successfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "alert not found";
			httpStatus = HttpStatus.NOT_FOUND;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteAlert(AlertRequest alertdto) {
		AlertModel newAlert = alertRepository.getalertById(alertdto.getAlertId());
		if (newAlert != null) {
			alertRepository.deleteById(newAlert.getAlertId());
			message = "quote deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.DOES_NOT_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	///// BANNER ONLY ADD OPERATION //////////

	public Object bannerMange(String operation, BannerViewRequest bannerViewdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(Constants.ADD)) {
				addBanner(bannerViewdto);
			} else if (operation.equals(Constants.SAVE)) {
				updateBanner(bannerViewdto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteBanner(bannerViewdto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = Constants.BANNER_EXCEPTION;
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addBanner(BannerViewRequest bannerDto) {
		BannerModel bannerDb = bannerRepository.getbannerbyId(bannerDto.getBannerId());
		if (bannerDb == null) {
			BannerModel newBanner = new BannerModel();
			newBanner.setBannerName(bannerDto.getBannerName());
			newBanner.setCourseTitle(bannerDto.getCourseTitle());
			newBanner.setImagePath(bannerDto.getImagePath());
			newBanner.setFromDate(bannerDto.getFromDate());
			newBanner.setToDate(bannerDto.getToDate());
			newBanner.setDescription(bannerDto.getDescription());
			newBanner.setCategoryId(bannerDto.getCategoryId());
			newBanner.setDateOfAdd(generalUtils.getCurrentDate());
			newBanner.setCreatedDate(generalUtils.getCurrentDate());
			newBanner.setIsActive("Y");

			bannerRepository.save(newBanner);
			httpStatus = HttpStatus.OK;
			message = "new banner is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "banner is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateBanner(BannerViewRequest bannerDto) {
		BannerModel bannerDb = bannerRepository.getbannerbyId(bannerDto.getBannerId());
		if (bannerDb != null) {
			bannerDb.setBannerName(bannerDto.getBannerName());
			bannerDb.setCourseTitle(bannerDto.getCourseTitle());
			bannerDb.setImagePath(bannerDto.getImagePath());
			bannerDb.setFromDate(bannerDto.getFromDate());
			bannerDb.setToDate(bannerDto.getToDate());
			bannerDb.setDescription(bannerDto.getDescription());
			bannerDb.setCategoryId(bannerDto.getCategoryId());
			bannerDb.setDateOfAdd(generalUtils.getCurrentDate());
			bannerDb.setUpdateDate(generalUtils.getCurrentDate());
			bannerRepository.save(bannerDb);
			httpStatus = HttpStatus.OK;
			message = "banner is updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "banner is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteBanner(BannerViewRequest bannerDto) {
		BannerModel bannerDb = bannerRepository.getbannerbyId(bannerDto.getBannerId());
		if (bannerDb != null) {
			bannerRepository.deleteById(bannerDto.getBannerId());

			httpStatus = HttpStatus.OK;
			message = "banner is deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "banner is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	public Object manageScripcutures(String operation, ScripcturesRequest scripcuturesdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(Constants.ADD)) {
				addScripcutures(scripcuturesdto);
			} else if (operation.equals(Constants.SAVE)) {
				updateScripcutures(scripcuturesdto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteScripcutures(scripcuturesdto);
			}
		} catch (Exception e) {
			message = Constants.EXCEPTION + " in scriptures creation";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);

	}

	private void addScripcutures(ScripcturesRequest scripcuturesdto) {
		ScripcturesModel scripctureDb = scripcturesRepository.checkscripcturesId(scripcuturesdto.getScripcturesId());
		if (scripctureDb == null) {
			ScripcturesModel newScripctures = new ScripcturesModel();
			newScripctures.setUploadFile(scripcuturesdto.getUploadFile());
			newScripctures.setCoverImage(scripcuturesdto.getCoverImage());
			newScripctures.setTitle(scripcuturesdto.getTitle());
			newScripctures.setDescription(scripcuturesdto.getDescription());
			newScripctures.setMetaKeyWords(scripcuturesdto.getMetaKeyWords());

			scripcturesRepository.save(newScripctures);
			message = "new scripcture is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateScripcutures(ScripcturesRequest scripcuturesdto) {
		ScripcturesModel scripcturesDb = scripcturesRepository.checkscripcturesId(scripcuturesdto.getScripcturesId());
		if (scripcturesDb != null) {
			scripcturesDb.setUploadFile(scripcuturesdto.getUploadFile());
			scripcturesDb.setCoverImage(scripcuturesdto.getCoverImage());
			scripcturesDb.setTitle(scripcuturesdto.getTitle());
			scripcturesDb.setDescription(scripcuturesdto.getDescription());
			scripcturesDb.setMetaKeyWords(scripcuturesdto.getMetaKeyWords());

			scripcturesRepository.save(scripcturesDb);
			message = "scripctures is updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.DOES_NOT_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteScripcutures(ScripcturesRequest scripcuturesdto) {
		ScripcturesModel scripctureDb = scripcturesRepository.checkscripcturesId(scripcuturesdto.getScripcturesId());
		if (scripctureDb != null) {
			scripcturesRepository.deleteById(scripcuturesdto.getScripcturesId());
			message = "Scripcture is deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.OPERATION_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	public Object manageNotification(String operation, NotificationRequest notificationdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(Constants.ADD)) {
				addNotification(notificationdto);
			} else if (operation.equals(Constants.SAVE)) {
				updateNotification(notificationdto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteNotification(notificationdto);
			}
		} catch (Exception e) {
			message = Constants.EXCEPTION + " in scriptures creation";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addNotification(NotificationRequest notificationdto) {
		NotificationModel notificationModel = noticationRepository
				.getnotificationById(notificationdto.getNotificationId());
		if (notificationModel == null) {
			NotificationModel notification = new NotificationModel();

			notification.setCategoryId(notificationdto.getCategoryId());
			notification.setTitle(notificationdto.getTitle());
			notification.setUploadFile(notificationdto.getUploadFile());
			notification.setMessage(notificationdto.getMessage());
			noticationRepository.save(notification);
			message = "new notification is added successfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateNotification(NotificationRequest notificationdto) {
	    NotificationModel notificationModel = noticationRepository
	            .getnotificationById(notificationdto.getNotificationId());
	    if (notificationModel != null) {
	        notificationModel.setCategoryId(notificationdto.getCategoryId());
	        notificationModel.setTitle(notificationdto.getTitle());
	        notificationModel.setUploadFile(notificationdto.getUploadFile());
	        notificationModel.setMessage(notificationdto.getMessage());
	        noticationRepository.save(notificationModel);
	        message = "notification is updated successfully";
	        LOG.info(message);
	        response = new Response(message, httpStatus.value(), null);
	    } else {
	        message = "notification not found";
	        httpStatus = HttpStatus.NOT_FOUND;
	        LOG.error(message);
	        response = new Response(message, httpStatus.value(), message);
	    }
	}


	private void deleteNotification(NotificationRequest notificationdto) {
		NotificationModel notification = noticationRepository.getnotificationById(notificationdto.getNotificationId());
		if (notification != null) {
			noticationRepository.deleteById(notificationdto.getNotificationId());
			message = "notification is deleted successfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.OPERATION_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	/////////////////////// PAGE////////////////////////////////////////
	//// ALL CURD OPERATION FOR THE PAGE /////////////////////////////

	public Object managepage(String operation, PageRequest pagedto) {

		try {
			if (operation.equals(Constants.ADD)) {
				addpage(pagedto);
			} else if (operation.equals(Constants.UPDATE)) {
				updatepage(pagedto);
			} else if (operation.equals(Constants.DELETE)) {
				deletepage(pagedto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in page";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	// delete page

	private void deletepage(PageRequest pagedto) {
		PageModel pageModelnew = pageRepository.getpageById(pagedto.getPageId());
		if (pageModelnew != null) {
			pageRepository.deleteById(pageModelnew.getPageId());
			message = "page deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "page Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	// update page

	private void updatepage(PageRequest pagedto) {
		PageModel pageModelnew = pageRepository.getpageById(pagedto.getPageId());
		if (pageModelnew != null) {
			pageModelnew.setPageTitle(pagedto.getPageTitle());
			pageModelnew.setPageText(pagedto.getPageText());
			pageModelnew.setHoverTitle(pagedto.getHoverTitle());
			pageModelnew.setRelatedTags(pagedto.getRelatedTags());
			pageModelnew.setDescription(pagedto.getDescription());
			pageModelnew.setSubject(pagedto.getSubject());
			pageModelnew.setCaptcha(pagedto.getCaptcha());
			pageRepository.save(pageModelnew);
			message = "page saved sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "page Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	// add page

	private void addpage(PageRequest pagedto) {

		PageModel pageModelnew = pageRepository.getpageById(pagedto.getPageId());
		if (pageModelnew == null) {
			PageModel pagelist = new PageModel();
			pagelist.setPageTitle(pagedto.getPageTitle());
			pagelist.setPageText(pagedto.getPageText());
			pagelist.setHoverTitle(pagedto.getHoverTitle());
			pagelist.setRelatedTags(pagedto.getRelatedTags());
			pagelist.setDescription(pagedto.getDescription());
			pagelist.setSubject(pagedto.getSubject());
			pagelist.setCaptcha(pagedto.getCaptcha());
			pageRepository.save(pagelist);
			message = "new page is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		}
	}

	public Object regionMange(String operation, RegionRequest regiondto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(Constants.ADD)) {
				addRegion(regiondto);
			} else if (operation.equals(Constants.UPDATE)) {
				RegionModel newRegion = regionRepository.getRegionById(regiondto.getRegionId());
				if (newRegion != null) {
					RegionModel regioncheck = regionRepository.getRegionByname(regiondto.getRegionName());
					if (regioncheck == null) {
						newRegion.setRegionName(regiondto.getRegionName());
						newRegion.setCountryName(regiondto.getCountryName());
						newRegion.setPartId(regiondto.getPartId());
						newRegion.setStates(regiondto.getStates());
						regionRepository.save(newRegion);
						message = "new region is  updated sucessfully";
						LOG.info(message);
						response = new Response(message, httpStatus.value(), null);
					} else {
						message = "Updated region is already exist";
						httpStatus = HttpStatus.CONFLICT;
						LOG.error(message);
						response = new Response(message, httpStatus.value(), message);
					}
				}

			} else if (operation.equals(Constants.DELETE)) {
				RegionModel newRegion = regionRepository.getRegionById(regiondto.getRegionId());
				if (newRegion != null) {
					regionRepository.deleteById(newRegion.getRegionId());
					message = "region deleted sucessfully";
					LOG.info(message);
					response = new Response(message, httpStatus.value(), null);
				} else {
					message = "region Doesn't exist";
					httpStatus = HttpStatus.CONFLICT;
					LOG.error(message);
					response = new Response(message, httpStatus.value(), message);
				}
			}

			else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = Constants.BANNER_EXCEPTION;
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	// add region //

	private void addRegion(RegionRequest regiondto) {
		RegionModel regionDb = regionRepository.getRegionById(regiondto.getRegionId());
		if (regionDb == null) {
			RegionModel newRegion = new RegionModel();
			newRegion.setRegionName(regiondto.getRegionName());
			newRegion.setCountryName(regiondto.getCountryName());
			newRegion.setPartId(regiondto.getPartId());
			newRegion.setStates(regiondto.getStates());
			regionRepository.save(newRegion);
			message = "new region is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

//	Photo Gallery

	public Object mangeGallary(PhotoGalleryRequest photoGalleryRequestDto, String operation) {
		try {
			if (operation.equals(Constants.ADD)) {
				addPhotoGallery(photoGalleryRequestDto);
			} else if (operation.equals(Constants.SAVE)) {
				updatePhotoGallery(photoGalleryRequestDto);
			} else if (operation.equals(Constants.ACTIVE)) {
				activePhotoGallery(photoGalleryRequestDto);
			} else if (operation.equals(Constants.DELETE)) {
				deletePhotoGallery(photoGalleryRequestDto);
			} else {
				message = Constants.OPERATION_ERROR;
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

	private void addPhotoGallery(PhotoGalleryRequest photoGalleryRequestDto) {
		PhotoGalleryModel newGallery = photoGalleryRepository.getGalleryName(photoGalleryRequestDto.getGalleryName());
		if (newGallery == null) {
			newGallery = new PhotoGalleryModel();
			newGallery.setGalleryName(photoGalleryRequestDto.getGalleryName());
			newGallery.setGalleryDescription(photoGalleryRequestDto.getGalleryDescription());
			newGallery.setFromDate(photoGalleryRequestDto.getFromDate());
			newGallery.setToDate(photoGalleryRequestDto.getToDate());
			newGallery.setCreatedDate(generalUtils.getCurrentDate());
			photoGalleryRepository.save(newGallery);
			httpStatus = HttpStatus.OK;
			message = "new gallery is created sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Gallery Already Exits";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updatePhotoGallery(PhotoGalleryRequest photoGalleryRequestDto) {
		PhotoGalleryModel photoGalleryDb = photoGalleryRepository
				.getPhotoGallery(photoGalleryRequestDto.getPhotoGalleryId());
		if (photoGalleryDb != null) {
			photoGalleryDb.setGalleryName(photoGalleryRequestDto.getGalleryName());
			photoGalleryDb.setGalleryDescription(photoGalleryRequestDto.getGalleryDescription());
			photoGalleryDb.setFromDate(photoGalleryRequestDto.getFromDate());
			photoGalleryDb.setToDate(photoGalleryRequestDto.getToDate());
			photoGalleryDb.setUpdatedDate(generalUtils.getCurrentDate());
			photoGalleryRepository.save(photoGalleryDb);
			httpStatus = HttpStatus.OK;
			message = "photo gallery is updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "photo gallery is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void activePhotoGallery(PhotoGalleryRequest photoGalleryRequestDto) {
		PhotoGalleryModel photoGalleryDb = photoGalleryRepository
				.getPhotoGallery(photoGalleryRequestDto.getPhotoGalleryId());
		if (photoGalleryDb != null) {
			photoGalleryDb.setActive(photoGalleryRequestDto.getActive());
			photoGalleryRepository.save(photoGalleryDb);
			httpStatus = HttpStatus.OK;
			message = "photo gallery is updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "photo gallery is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deletePhotoGallery(PhotoGalleryRequest photoGalleryRequestDto) {
		PhotoGalleryModel photoGalleryDb = photoGalleryRepository
				.getPhotoGallery(photoGalleryRequestDto.getPhotoGalleryId());
		if (photoGalleryDb != null) {
			photoGalleryRepository.deleteById(photoGalleryRequestDto.getPhotoGalleryId());
			httpStatus = HttpStatus.OK;
			message = "photo gallery is deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "photo gallery is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	public Object uploadGallary(MultipartFile file, HttpServletRequest request) {

		if (!file.isEmpty()) {
			try {
				String uploadsDir = "/photoGallery/";
				String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);

				if (!new File(realPathtoUploads).exists()) {
					new File(realPathtoUploads).mkdir();
				}
				LOG.info("realPathtoUploads = {}", realPathtoUploads);

				String orgName = file.getOriginalFilename();
				String filePath = realPathtoUploads + orgName;
				File dest = new File(filePath);
				file.transferTo(dest);

				httpStatus = HttpStatus.OK;
				message = "file uploaded sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} catch (Exception e) {
				message = "Exception in banner creation";
				httpStatus = HttpStatus.EXPECTATION_FAILED;
				LOG.error(message);
				LOG.error(e.getLocalizedMessage());
				response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
			}
		} else {
			message = "File is empty, no image select";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

		return new ResponseEntity<>(response, httpStatus);
	}

//////Pears of wisdom /////////////

	public Object managewisdom(String operation, PearlsOfWisdomRequest wisdomdto) {

		try {
			if (operation.equals("add")) {
				addwisdom(wisdomdto);
			} else if (operation.equals("update")) {
				updatewisdom(wisdomdto);
			} else if (operation.equals("delete")) {
				deleteWisdom(wisdomdto);
			} else if (operation.equals("active")) {
				activateWisdom(wisdomdto);
			} else if (operation.equals("deactive")) {
				deactivateWisdom(wisdomdto);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in Role";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void deleteWisdom(PearlsOfWisdomRequest wisdomDto) {
		PearlsOfWisdomModel wisdomModel = pearlsOfWisdomRepository.findById(wisdomDto.getQuoteId()).orElse(null);
		if (wisdomModel != null) {
			pearlsOfWisdomRepository.delete(wisdomModel);
			String message = "Quote deleted successfully";
			LOG.info(message);
			response = new Response(message, HttpStatus.OK.value(), null);
		} else {
			String message = "Quote does not exist";
			LOG.error(message);
			response = new Response(message, HttpStatus.CONFLICT.value(), message);
		}
	}

	private void updatewisdom(PearlsOfWisdomRequest wisdomdto) {
		PearlsOfWisdomModel wisdommodelnew = pearlsOfWisdomRepository.getwisdomById(wisdomdto.getQuoteId());
		if (wisdommodelnew != null) {
			// Update the fields of the wisdommodelnew quote
			wisdommodelnew.setQuoteTitle(wisdomdto.getQuoteTitle());
			wisdommodelnew.setQuote(wisdomdto.getQuote());
			wisdommodelnew.setQuoteDate(wisdomdto.getQuoteDate());
			wisdommodelnew.setQuoteType(wisdomdto.getQuoteType());

			// Save the updated quote to the repository
			pearlsOfWisdomRepository.save(wisdommodelnew);

			message = "Quote updated successfully";
			LOG.info(message);
			response = new Response(message, HttpStatus.OK.value(), null);
		} else {
			message = "Quote does not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void addwisdom(PearlsOfWisdomRequest wisdomdto) {
		PearlsOfWisdomModel wisdommodelnew = pearlsOfWisdomRepository.getwisdomById(wisdomdto.getQuoteId());
		if (wisdommodelnew == null) {
			PearlsOfWisdomModel wisdomlist = new PearlsOfWisdomModel();

			wisdomlist.setQuoteTitle(wisdomdto.getQuoteTitle());
			wisdomlist.setQuote(wisdomdto.getQuote());
			wisdomlist.setQuoteDate(wisdomdto.getQuoteDate());
			wisdomlist.setQuoteType(wisdomdto.getQuoteType());
			wisdomlist.setIsActive("Y");

			pearlsOfWisdomRepository.save(wisdomlist);
			message = "new quote is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		}
	}

	private void activateWisdom(PearlsOfWisdomRequest wisdomdto) {
		PearlsOfWisdomModel wisdomModel = pearlsOfWisdomRepository.findById(wisdomdto.getQuoteId()).orElse(null);
		if (wisdomModel != null) {
			wisdomModel.setIsActive("Y");
			pearlsOfWisdomRepository.save(wisdomModel);
			String message = "Quote activated successfully";
			LOG.info(message);
			response = new Response(message, HttpStatus.OK.value(), null);
		} else {
			String message = "Quote does not exist";
			LOG.error(message);
			response = new Response(message, HttpStatus.CONFLICT.value(), message);
		}
	}

	private void deactivateWisdom(PearlsOfWisdomRequest wisdomdto) {
		PearlsOfWisdomModel wisdomModel = pearlsOfWisdomRepository.findById(wisdomdto.getQuoteId()).orElse(null);
		if (wisdomModel != null) {
			wisdomModel.setIsActive("N");
			pearlsOfWisdomRepository.save(wisdomModel);
			String message = "Quote deactivated successfully";
			LOG.info(message);
			response = new Response(message, HttpStatus.OK.value(), null);
		}
	}
}
