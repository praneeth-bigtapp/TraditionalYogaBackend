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
			} else if (operationType.equals("videoGallery")) {
				httpStatus = HttpStatus.OK;
				return "Video Gallery";
			} else if (operationType.equals("testimonials")) {
				httpStatus = HttpStatus.OK;
				return "Testimonoals";
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
	}

	/////// ALERT ONLY ADD OPERATION /////////

	public Object managealert(String operation, AlertRequest alertdto) {

		try {
			if (operation.equals("add")) {
				addalert(alertdto);
			} else if (operation.equals("update")) {
				updatealert(alertdto);
			} else if (operation.equals("delete")) {
				deletequote(alertdto);
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

	private void addalert(AlertRequest alertdto) {
		AlertModel newAlert = alertRepository.getalertById(alertdto.getAlertId());
		if (newAlert == null) {
			AlertModel newlist = new AlertModel();

			newlist.setCategoryId(alertdto.getCategoryId());
			newlist.setAlertDescription(alertdto.getAlertDescription());
			newlist.setStartDate(alertdto.getStartDate());
			newlist.setEndDate(alertdto.getEndDate());

			alertRepository.save(newlist);
			message = "new quote is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.OPERATION_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updatealert(AlertRequest alertdto) {
		AlertModel newAlert = alertRepository.getalertById(alertdto.getAlertId());
		if (newAlert != null) {
			AlertModel newAlertCheck = alertRepository.getalertBydescription(alertdto.getAlertDescription());
			AlertModel newAlertCheck1 = alertRepository.getalertBystartdate(alertdto.getStartDate());
			AlertModel newAlertCheck2 = alertRepository.getalertByenddate(alertdto.getStartDate());

			if (newAlertCheck == null || newAlertCheck1 == null || newAlertCheck2 == null) {
				newAlert.setCategoryId(alertdto.getCategoryId());
				newAlert.setAlertDescription(alertdto.getAlertDescription());
				newAlert.setStartDate(alertdto.getStartDate());
				newAlert.setEndDate(alertdto.getEndDate());

				alertRepository.save(newAlert);
				message = "quote saved sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Updated quote is already exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

		} else {
			message = Constants.ALERT_EXCEPTION;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	private void deletequote(AlertRequest alertdto) {
		AlertModel newAlert = alertRepository.getalertById(alertdto.getAlertId());
		if (newAlert != null) {
			alertRepository.deleteById(newAlert.getAlertId());
			message = "quote deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.DOES_NOT_EXISTS;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	///// BANNER ONLY ADD OPERATION //////////

	public Object bannerMange(String operation, BannerViewRequest bannerViewdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals("add")) {
				BannerModel bannernew = bannerRepository.getbannerbyId(bannerViewdto.getBannerId());
				if (bannernew == null) {
					BannerModel bannerList = new BannerModel();
					bannerList.setBannerName(bannerViewdto.getBannerName());
					bannerList.setCourseTitle(bannerViewdto.getCourseTitle());
					bannerList.setImagePath(bannerViewdto.getImagePath());
					bannerList.setFromDate(bannerViewdto.getFromDate());
					bannerList.setToDate(bannerViewdto.getToDate());
					bannerList.setDescription(bannerViewdto.getDescription());
					bannerList.setCategoryId(bannerViewdto.getCategoryId());
					bannerList.setDateOfAdd(generalUtils.getCurrentDate());
					bannerRepository.save(bannerList);
					message = "new banner is  added sucessfully";
					LOG.info(message);
					response = new Response(message, httpStatus.value(), null);
				}
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

	public Object managescripcutures(String operation, ScripcturesRequest scripcuturesdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals("add")) {
				ScripcturesModel scripcturesModelnew = scripcturesRepository
						.checkscripcturesId(scripcuturesdto.getScripcturesId());
				if (scripcturesModelnew == null) {
					ScripcturesModel scripctureslist = new ScripcturesModel();
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
					message = Constants.OPERATION_ERROR;
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

	public Object managenotification(String operation, NotificationRequest notificationdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals("add")) {
				NotificationModel notificationModelnew = noticationRepository
						.getnotificationById(notificationdto.getNoticationId());
				if (notificationModelnew == null) {
					NotificationModel noticationlist = new NotificationModel();

					noticationlist.setCategoryId(
							noticationCategoryRepository.getnotificationById(notificationdto.getCategoryId()));
//					noticationlist.setCategoryId(notificationdto.getCategoryId());
					noticationlist.setTitle(notificationdto.getTitle());
					noticationlist.setUploadFile(notificationdto.getUploadFile());
					noticationlist.setMessage(notificationdto.getMessage());
					noticationRepository.save(noticationlist);
					message = "new notification is  added sucessfully";
					LOG.info(message);
					response = new Response(message, httpStatus.value(), null);
				} else {
					message = Constants.OPERATION_ERROR;
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

	/////////////////////// PAGE////////////////////////////////////////
	//// ALL CURD OPERATION FOR THE PAGE /////////////////////////////

	public Object managepage(String operation, PageRequest pagedto) {

		try {
			if (operation.equals("add")) {
				addpage(pagedto);
			} else if (operation.equals("update")) {
				updatepage(pagedto);
			} else if (operation.equals("delete")) {
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

	private void updatepage(PageRequest pagedto) {
		PageModel pageModelnew = pageRepository.getpageById(pagedto.getPageId());
		if (pageModelnew != null) {
			PageModel pageCheck = pageRepository.getpageByname(pagedto.getPageTitle());
			PageModel descriptionCheck = pageRepository.getpageBydescription(pagedto.getDescription());
			PageModel titlecheck = pageRepository.getpageBytext(pagedto.getPageText());
			if (pageCheck == null || descriptionCheck == null || titlecheck == null) {
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
				message = "Updated Role is already exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

		} else {
			message = "page Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

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
			if (operation.equals("add")) {
				RegionModel newregion = regionRepository.getRegionById(regiondto.getRegionId());
				if (newregion == null) {
					RegionModel regionList = new RegionModel();
					regionList.setRegionName(regiondto.getRegionName());
					regionList.setCountryName(regiondto.getCountryName());
					regionList.setPartId(regiondto.getPartId());
					regionList.setStates(regiondto.getStates());
					regionRepository.save(regionList);
					message = "new region is  added sucessfully";
					LOG.info(message);
					response = new Response(message, httpStatus.value(), null);
				}
			} else if (operation.equals("update")) {
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

			} else if (operation.equals("delete")) {
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

//	Photo Gallery
	public Object createGallary(PhotoGalleryRequest photoGalleryRequestDto) {
		try {
			PhotoGalleryModel newGallery = photoGalleryRepository
					.getGalleryName(photoGalleryRequestDto.getGalleryName());
			if (newGallery == null) {
				newGallery = new PhotoGalleryModel();
				newGallery.setGalleryName(photoGalleryRequestDto.getGalleryName());
				newGallery.setGalleryDescription(photoGalleryRequestDto.getGalleryDescription());
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
		} catch (Exception e) {
			message = "Exception in banner creation";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
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

	////// Pears of wisdom /////////////

	public Object managewisdom(String operation, PearlsOfWisdomRequest wisdomdto) {

		try {
			if (operation.equals("add")) {
				addwisdom(wisdomdto);
			} else if (operation.equals("update")) {
				updatewisdom(wisdomdto);
			} else if (operation.equals("delete")) {
				deletewisdom(wisdomdto);
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

	private void deletewisdom(PearlsOfWisdomRequest wisdomdto) {
		PearlsOfWisdomModel wisdommodelnew = pearlsOfWisdomRepository.getwisdomById(wisdomdto.getQuoteId());
		if (wisdommodelnew != null) {
			pearlsOfWisdomRepository.deleteById(wisdommodelnew.getQuoteId());
			message = "quote deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "quote Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updatewisdom(PearlsOfWisdomRequest wisdomdto) {
		PearlsOfWisdomModel wisdommodelnew = pearlsOfWisdomRepository.getwisdomById(wisdomdto.getQuoteId());
		if (wisdommodelnew != null) {
			PearlsOfWisdomModel wisdommodelcheck = pearlsOfWisdomRepository.getwisdomBytitle(wisdomdto.getQuoteTitle());
			PearlsOfWisdomModel wisdommodelcheck1 = pearlsOfWisdomRepository.getwisdomBydate(wisdomdto.getQuoteDate());
			PearlsOfWisdomModel wisdommodelcheck2 = pearlsOfWisdomRepository.getwisdomByquote(wisdomdto.getQuote());

			if (wisdommodelcheck == null || wisdommodelcheck1 == null || wisdommodelcheck2 == null) {
				wisdommodelnew.setQuoteTitle(wisdomdto.getQuoteTitle());
				wisdommodelnew.setQuote(wisdomdto.getQuote());
				wisdommodelnew.setQuoteDate(wisdomdto.getQuoteDate());
				wisdommodelnew.setQuoteType(wisdomdto.getQuoteType());
				pearlsOfWisdomRepository.save(wisdommodelnew);
				message = "quote saved sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Updated quote is already exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

		} else {
			message = "quote Doesn't exist";
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
}
