package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.repository.DonationRepository;

@Service
public class DonationService {

	private static final Logger LOG = LoggerFactory.getLogger(DonationService.class);

	@Autowired
	DonationRepository donationRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll() {
		LOG.info("Fetching Donation amount data");
		try {
			httpStatus = HttpStatus.OK;
			return new ResponseEntity<>(donationRepository.findAll(), httpStatus);
		} catch (Exception e) {
			message = "Unknown Error";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

}
