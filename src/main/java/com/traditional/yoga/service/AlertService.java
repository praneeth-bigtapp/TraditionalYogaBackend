package com.traditional.yoga.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.AlertRequest;
import com.traditional.yoga.dto.request.UserRequest;
import com.traditional.yoga.model.AlertModel;
import com.traditional.yoga.model.UserModel;
import com.traditional.yoga.repository.AlertRepository;import com.traditional.yoga.repository.StudentRepository;
@Service
public class AlertService {
	private static final Logger LOG = LoggerFactory.getLogger(AlertService.class);

	@Autowired
	AlertRepository alertRepository;
	
	
	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching alert related {} data", operationType);

		try {
			if (operationType.equals("alert")) {
				return alertRepository.findAll();
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
	
	public Object alertmanage(String operation, AlertRequest alertdto) {

		this.httpStatus = HttpStatus.OK;
		AlertModel alertReq = new AlertModel();
		alertReq.setAlertId(alertdto.getAlertId());
		alertReq.setCategoryId(alertdto.getCategoryId());
		alertReq.setAlertDescription(alertdto.getAlertDescription());
		alertReq.setStartDate(alertdto.getStartDate());
		alertReq.setEndDate(alertdto.getEndDate());
		try {

			if (operation.equals("add")) {
				addalert(alertdto);
			}else {
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
	
	
	private void addalert(AlertRequest alertdto) {
		AlertModel alertnew = alertRepository.getalertById(alertdto.getAlertId());
		System.out.println(alertdto.getAlertId());
		if (alertnew == null) {
			AlertModel newalert =new AlertModel();
			newalert.setAlertId(alertdto.getAlertId());
			newalert.setCategoryId(alertdto.getCategoryId());
			newalert.setAlertDescription(alertdto.getAlertDescription());
			newalert.setStartDate(alertdto.getStartDate());
			newalert.setEndDate(alertdto.getEndDate());
			alertRepository.save(newalert);
			message = "new alert added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} 
	}

}
