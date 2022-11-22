package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.BannerViewRequest;
import com.traditional.yoga.model.BannerViewModel;
import com.traditional.yoga.repository.BannerViewRepository;

@Service
public class BannerService {
	private static final Logger LOG = LoggerFactory.getLogger(BannerService.class);

	@Autowired
	BannerViewRepository bannerViewRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching alert related {} data", operationType);

		try {
			if (operationType.equals("bannerview")) {
				return bannerViewRepository.findAll();
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

	public Object bannermange(String operation, BannerViewRequest BannerViewdto) {

		this.httpStatus = HttpStatus.OK;
		BannerViewModel bannerReq = new BannerViewModel();
		bannerReq.setBannerId(BannerViewdto.getBannerId());
		bannerReq.setBannerName(BannerViewdto.getBannerName());
		bannerReq.setCategoryId(BannerViewdto.getCategoryId());
		bannerReq.setDate(BannerViewdto.getDate());
		try {

			if (operation.equals("add")) {
				addBanner(BannerViewdto);
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

	private void addBanner(BannerViewRequest BannerViewdto) {
		BannerViewModel bannernew = bannerViewRepository.getbannerbyId(BannerViewdto.getBannerId());
		if (bannernew == null) {
			BannerViewModel bannerList = new BannerViewModel();
			bannerList.setBannerId(bannerList.getBannerId());
			bannerList.setCategoryId(bannerList.getCategoryId());
			bannerList.setBannerName(bannerList.getBannerName());
			bannerList.setDate(bannerList.getDate());

			bannerViewRepository.save(bannerList);
			message = "new banner is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		}
	}

}
