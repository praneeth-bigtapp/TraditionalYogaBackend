package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.PraticeLibaryRequest;
import com.traditional.yoga.model.PraticeLibaryModel;
import com.traditional.yoga.repository.CategoryLibaryRepository;
import com.traditional.yoga.repository.PraticeLibaryRepository;

@Service
public class PraticeLibaryService {

	private static final Logger LOG = LoggerFactory.getLogger(PraticeLibaryService.class);

	@Autowired
	PraticeLibaryRepository praticeLibaryRepository;
	@Autowired
	CategoryLibaryRepository categoryLibaryRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching praticeLibary related {} data", operationType);

		try {
			if (operationType.equals("praticelibary")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(praticeLibaryRepository.findAll(), httpStatus);
			}  else if(operationType.equals("categorylibary")) {
				return new ResponseEntity<>(categoryLibaryRepository.findAll(), httpStatus);
			}else {
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

	public Object managelibary(String operation, PraticeLibaryRequest praticelibaryDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("recordsession")) {
				addrecordsession(praticelibaryDto);
			} else if (operation.equals("shortvideo")) {
				addshortvideo(praticelibaryDto);
			} else if (operation.equals("glimpses")) {
				addglimpses(praticelibaryDto);
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

	private void addrecordsession(PraticeLibaryRequest praticelibaryDto) {

		PraticeLibaryModel praticemodel = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticemodel == null) {
			PraticeLibaryModel newlibary = new PraticeLibaryModel();
			newlibary.setCategoryId(1);
			newlibary.setVideoLink(praticelibaryDto.getVideoLink());
			newlibary.setDuration(praticelibaryDto.getDuration());
			newlibary.setTitle(praticelibaryDto.getTitle());
			newlibary.setMessage(praticelibaryDto.getMessage());
			newlibary.setMetaKeyword(praticelibaryDto.getMetaKeyword());

			praticeLibaryRepository.save(newlibary);
			message = "Record-session video link is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "User is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void addshortvideo(PraticeLibaryRequest praticelibaryDto) {

		PraticeLibaryModel praticemodel = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticemodel == null) {
			PraticeLibaryModel newlibary = new PraticeLibaryModel();
			newlibary.setCategoryId(4);
			newlibary.setVideoLink(praticelibaryDto.getVideoLink());
			newlibary.setDuration(praticelibaryDto.getDuration());
			newlibary.setTitle(praticelibaryDto.getTitle());
			newlibary.setMessage(praticelibaryDto.getMessage());
			newlibary.setMetaKeyword(praticelibaryDto.getMetaKeyword());

			praticeLibaryRepository.save(newlibary);
			message = "Short video link is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "This video  is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void addglimpses(PraticeLibaryRequest praticelibaryDto) {

		PraticeLibaryModel praticemodel = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticemodel == null) {
			PraticeLibaryModel newlibary = new PraticeLibaryModel();
			newlibary.setCategoryId(3);
			newlibary.setVideoLink(praticelibaryDto.getVideoLink());
			newlibary.setDuration(praticelibaryDto.getDuration());
			newlibary.setTitle(praticelibaryDto.getTitle());
			newlibary.setMessage(praticelibaryDto.getMessage());
			newlibary.setMetaKeyword(praticelibaryDto.getMetaKeyword());

			praticeLibaryRepository.save(newlibary);
			message = "Record-session video link is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "User is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

}
