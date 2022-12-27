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
import com.traditional.yoga.repository.SubCategoryPraticeRepsoitory;
import com.traditional.yoga.utils.Constants;

@Service
public class PraticeLibaryService {

	private static final Logger LOG = LoggerFactory.getLogger(PraticeLibaryService.class);

	@Autowired
	PraticeLibaryRepository praticeLibaryRepository;
	@Autowired
	CategoryLibaryRepository categoryLibaryRepository;

	@Autowired
	SubCategoryPraticeRepsoitory subCategoryPraticeRepsoitory;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching praticeLibary related {} data", operationType);

		try {
			if (operationType.equals("praticeLibary")) {
				httpStatus = HttpStatus.OK;
				return praticeLibaryRepository.findAll();
			} else if (operationType.equals("categoryLibary")) {
				return new ResponseEntity<>(categoryLibaryRepository.findAll(), httpStatus);
			} else if (operationType.equals("subCategory")) {
				return new ResponseEntity<>(subCategoryPraticeRepsoitory.findAll(), httpStatus);
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
			if (type.equals("praticeLibary")) {
				recordSession(operation, praticelibaryDto);
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
//			newlibary.setLibraryCategoryId(
//					categoryLibaryRepository.getpraticecategoryById(praticelibaryDto.getLibraryCategoryId()));
//			
			newlibary.setLibraryCategoryId(praticelibaryDto.getLibraryCategoryId());
			newlibary.setSubCategoryId(
					subCategoryPraticeRepsoitory.getsubCategorybyId(praticelibaryDto.getSubCategoryId()));
			newlibary.setVideoLink(praticelibaryDto.getVideoLink());
			newlibary.setDuration(praticelibaryDto.getDuration());
			newlibary.setTitle(praticelibaryDto.getTitle());
			newlibary.setMessage(praticelibaryDto.getMessage());
			newlibary.setMetaKeyword(praticelibaryDto.getMetaKeyword());

			praticeLibaryRepository.save(newlibary);
			message = "pratice Libary is  added sucessfully";
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

//			praticeDb.setLibraryCategoryId(
//					categoryLibaryRepository.getpraticecategoryById(praticelibaryDto.getLibraryCategoryId()));
			praticeDb.setLibraryCategoryId(praticelibaryDto.getLibraryCategoryId());
			praticeDb.setSubCategoryId(
					subCategoryPraticeRepsoitory.getsubCategorybyId(praticelibaryDto.getSubCategoryId()));
			praticeDb.setVideoLink(praticelibaryDto.getVideoLink());
			praticeDb.setDuration(praticelibaryDto.getDuration());
			praticeDb.setTitle(praticelibaryDto.getTitle());
			praticeDb.setMessage(praticelibaryDto.getMessage());
			praticeDb.setMetaKeyword(praticelibaryDto.getMetaKeyword());
			praticeLibaryRepository.save(praticeDb);
			message = "Pratice Libary  is  updated sucessfully";
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
			message = "Pratice Libary is  deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Pratice Libary is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

}
