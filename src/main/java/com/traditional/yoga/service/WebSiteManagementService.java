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
import com.traditional.yoga.dto.request.NotificationRequest;
import com.traditional.yoga.dto.request.PageRequest;
import com.traditional.yoga.dto.request.RoleRequest;
import com.traditional.yoga.dto.request.ScripcturesRequest;
import com.traditional.yoga.model.AlertModel;
import com.traditional.yoga.model.BannerViewModel;
import com.traditional.yoga.model.NotificationModel;
import com.traditional.yoga.model.PageModel;
import com.traditional.yoga.model.RoleModel;
import com.traditional.yoga.model.ScripcturesModel;
import com.traditional.yoga.repository.AlertRepository;
import com.traditional.yoga.repository.BannerViewRepository;
import com.traditional.yoga.repository.NoticationRepository;
import com.traditional.yoga.repository.PageRepository;
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

	@Autowired
	NoticationRepository noticationRepository;

	@Autowired
	PageRepository pageRepository;

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
			} else if (operationType.equals("notication")) {
				httpStatus = HttpStatus.OK;
				return noticationRepository.findAll();
			} else if (operationType.equals("page")) {
				httpStatus = HttpStatus.OK;
				return pageRepository.findAll();
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
				ScripcturesModel scripcturesModelnew = scripcturesRepository
						.checkscripcturesId(scripcuturesdto.getScripcturesId());
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

	public Object managenotification(String operation, NotificationRequest notificationdto) {
		httpStatus = HttpStatus.OK;
		try {
			if (operation.equals("add")) {
				NotificationModel notificationModelnew = noticationRepository
						.getnotificationById(notificationdto.getNoticationId());
				if (notificationModelnew == null) {
					NotificationModel noticationlist = new NotificationModel();

					noticationlist.setCategoryId(notificationdto.getCategoryId());
					noticationlist.setUploadFile(notificationdto.getUploadFile());
					noticationlist.setMessage(notificationdto.getMessage());
					noticationRepository.save(noticationlist);
					message = "new notification is  added sucessfully";
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

//	public Object managepage(String operation, PageRequest pagedto) {
//		httpStatus = HttpStatus.OK;
//		try {
//			if (operation.equals("add"))
//
//			{
//				PageModel pageModelnew = pageRepository.getpageById(pagedto.getPageId());
//				if (pageModelnew == null) {
//					PageModel pagelist = new PageModel();
//					pagelist.setPageTitle(pagedto.getPageTitle());
//					pagelist.setPageText(pagedto.getPageText());
//					pagelist.setHoverTitle(pagedto.getHoverTitle());
//					pagelist.setRelatedTags(pagedto.getRelatedTags());
//					pagelist.setDescription(pagedto.getDescription());
//					pagelist.setSubject(pagedto.getSubject());
//					pagelist.setCaptcha(pagedto.getCaptcha());
//					pageRepository.save(pagelist);
//					message = "new page is  added sucessfully";
//					LOG.info(message);
//					response = new Response(message, httpStatus.value(), null);
//				} else {
//					message = "Operation Doesn't exist";
//					httpStatus = HttpStatus.CONFLICT;
//					LOG.error(message);
//					response = new Response(message, httpStatus.value(), message);
//				}
//			}
//		} catch (Exception e) {
//			message = "Exception in page creation";
//			httpStatus = HttpStatus.EXPECTATION_FAILED;
//			LOG.error(message);
//			LOG.error(e.getLocalizedMessage());
//			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
//		}
//		return new ResponseEntity<>(response, httpStatus);
//
//	}

	public Object managepage(String operation, PageRequest pagedto) {

		try {
			if (operation.equals("add")) {
				addpage(pagedto);
			} else if (operation.equals("update")) {
				updatepage(pagedto);
			}else if (operation.equals("delete")) {
				deleteRole(pagedto);
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

	private void deleteRole(PageRequest pagedto) {
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
			PageModel pageCheck=pageRepository.getpageByname(pagedto.getPageTitle());
			if (pageCheck == null) {
				pageModelnew.setPageTitle(pagedto.getPageTitle());
				pageModelnew.setPageText(pagedto.getPageText());
				pageModelnew.setHoverTitle(pagedto.getHoverTitle());
				pageModelnew.setRelatedTags(pagedto.getRelatedTags());
				pageModelnew.setDescription(pagedto.getDescription());
				pageModelnew.setSubject(pagedto.getSubject());
				pageModelnew.setCaptcha(pagedto.getCaptcha());
				message = "page saved sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} 
			else {
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

}
