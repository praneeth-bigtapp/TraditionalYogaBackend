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
import com.traditional.yoga.utils.Constants;

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
			if (operationType.equals("praticeLibary")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(praticeLibaryRepository.findAll(), httpStatus);
			} else if (operationType.equals("categoryLibary")) {
				return new ResponseEntity<>(categoryLibaryRepository.findAll(), httpStatus);
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

	public Object managelibary(String operation, String type, PraticeLibaryRequest praticelibaryDto) {

		this.httpStatus = HttpStatus.OK;
		try {
			if (type.equals("recordSession")) {
				recordSession(operation, praticelibaryDto);
			} else if (type.equals("shortVideo")) {
				shortVideo(operation, praticelibaryDto);
			} else if (type.equals("glimpses")) {
				glimpses(operation, praticelibaryDto);
			} else {
				message = Constants.TYPE_ERROR;
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

	private void recordSession(String operation, PraticeLibaryRequest praticelibaryDto) {
		try {
			if (operation.equals(Constants.ADD)) {
				addRecordSession(praticelibaryDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateRecordSession(praticelibaryDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteRecordSession(praticelibaryDto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in Record Session";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
	}

	private void addRecordSession(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticemodel = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticemodel == null) {
			PraticeLibaryModel newlibary = new PraticeLibaryModel();
			newlibary.setCategoryId(Constants.RECORDED_SESSION);
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
			message = "Pratice Libary is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateRecordSession(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticeDb = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticeDb != null) {
			praticeDb.setCategoryId(Constants.RECORDED_SESSION);
			praticeDb.setVideoLink(praticelibaryDto.getVideoLink());
			praticeDb.setDuration(praticelibaryDto.getDuration());
			praticeDb.setTitle(praticelibaryDto.getTitle());
			praticeDb.setMessage(praticelibaryDto.getMessage());
			praticeDb.setMetaKeyword(praticelibaryDto.getMetaKeyword());
			praticeLibaryRepository.save(praticeDb);
			message = "Pratice Libary Record-session video link is  updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Pratice Libary is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteRecordSession(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticeDb = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticeDb != null) {
			praticeLibaryRepository.deleteById(praticelibaryDto.getPraticeLibaryId());
			message = "Pratice Libary Record-session video link is  deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Pratice Libary is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void shortVideo(String operation, PraticeLibaryRequest praticelibaryDto) {
		try {
			if (operation.equals(Constants.ADD)) {
				addShortVideo(praticelibaryDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateShortVideo(praticelibaryDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteShortVideo(praticelibaryDto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in Short Video";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
	}

	private void addShortVideo(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticemodel = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticemodel == null) {
			PraticeLibaryModel newlibary = new PraticeLibaryModel();
			newlibary.setCategoryId(Constants.SHORT_VIDEOS);
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
			message = "This video is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateShortVideo(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticeDb = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticeDb != null) {
			praticeDb.setCategoryId(Constants.SHORT_VIDEOS);
			praticeDb.setVideoLink(praticelibaryDto.getVideoLink());
			praticeDb.setDuration(praticelibaryDto.getDuration());
			praticeDb.setTitle(praticelibaryDto.getTitle());
			praticeDb.setMessage(praticelibaryDto.getMessage());
			praticeDb.setMetaKeyword(praticelibaryDto.getMetaKeyword());

			praticeLibaryRepository.save(praticeDb);
			message = "Short video link is  updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "This video is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteShortVideo(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticemodelDb = praticeLibaryRepository
				.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticemodelDb != null) {
			praticeLibaryRepository.deleteById(praticelibaryDto.getPraticeLibaryId());
			message = "Short video link is  deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "This video is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void glimpses(String operation, PraticeLibaryRequest praticelibaryDto) {
		try {
			if (operation.equals(Constants.ADD)) {
				addGlimpses(praticelibaryDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateGlimpses(praticelibaryDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteGlimpses(praticelibaryDto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in glimpses";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}

	}

	private void addGlimpses(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticeModel = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticeModel == null) {
			PraticeLibaryModel newGlimpse = new PraticeLibaryModel();
			newGlimpse.setCategoryId(Constants.GLIMPSES);
			newGlimpse.setVideoLink(praticelibaryDto.getVideoLink());
			newGlimpse.setDuration(praticelibaryDto.getDuration());
			newGlimpse.setTitle(praticelibaryDto.getTitle());
			newGlimpse.setMessage(praticelibaryDto.getMessage());
			newGlimpse.setMetaKeyword(praticelibaryDto.getMetaKeyword());

			praticeLibaryRepository.save(newGlimpse);
			message = "Glimpses record is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Glimpses record is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateGlimpses(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticeDb = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticeDb != null) {
			praticeDb.setCategoryId(Constants.GLIMPSES);
			praticeDb.setVideoLink(praticelibaryDto.getVideoLink());
			praticeDb.setDuration(praticelibaryDto.getDuration());
			praticeDb.setTitle(praticelibaryDto.getTitle());
			praticeDb.setMessage(praticelibaryDto.getMessage());
			praticeDb.setMetaKeyword(praticelibaryDto.getMetaKeyword());

			praticeLibaryRepository.save(praticeDb);
			message = "Glimpses record is updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Glimpses record is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteGlimpses(PraticeLibaryRequest praticelibaryDto) {
		PraticeLibaryModel praticeDb = praticeLibaryRepository.getpraticeById(praticelibaryDto.getPraticeLibaryId());
		if (praticeDb != null) {
			praticeLibaryRepository.deleteById(praticelibaryDto.getPraticeLibaryId());
			message = "Glimpses record is deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Glimpses record is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

}
