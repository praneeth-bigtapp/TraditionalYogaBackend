package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.AlertRequest;
import com.traditional.yoga.dto.request.BlackListRequest;
import com.traditional.yoga.dto.request.UserRequest;
import com.traditional.yoga.model.AlertModel;
import com.traditional.yoga.model.BlackListModel;
import com.traditional.yoga.model.UserModel;
import com.traditional.yoga.repository.BlackListUserRepository;

@Service
public class BlacklistUserService {
	private static final Logger LOG = LoggerFactory.getLogger(BlacklistUserService.class);

	@Autowired
	BlackListUserRepository blackListUserRepository;
	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching alert related {} data", operationType);

		try {
			if (operationType.equals("blacklistuser")) {
				return blackListUserRepository.findAll();
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

	public Object blacklistmanage(String operation, BlackListRequest blacklistdto) {

		this.httpStatus = HttpStatus.OK;
		BlackListModel blackListReq = new BlackListModel();
		blackListReq.setBlacklistuserId(blacklistdto.getBlacklistuserId());
		blackListReq.setBlacklistUserEmail(blacklistdto.getBlacklistUserEmail());
		blackListReq.setDate(blacklistdto.getDate());
		blackListReq.setComments(blacklistdto.getComments());

		try {

			if (operation.equals("add")) {
				addBlackListUser(blacklistdto);
			} else if (operation.equals("delete")) {
				deleteUsers(blacklistdto);
			}else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in blacklistuser";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addBlackListUser(BlackListRequest blacklistdto) {
		BlackListModel blacklistnew = blackListUserRepository.getblacklistuserById(blacklistdto.getBlacklistuserId());
		if (blacklistnew == null) {
			BlackListModel newList = new BlackListModel();
			newList.setBlacklistuserId(blacklistdto.getBlacklistuserId());
			newList.setBlacklistUserEmail(blacklistdto.getBlacklistUserEmail());
			newList.setDate(blacklistdto.getDate());
			newList.setComments(blacklistdto.getComments());
			blackListUserRepository.save(newList);
			message = "new blacklist user is  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		}
	}

	private void deleteUsers(BlackListRequest blacklistdto) {
		BlackListModel blacklistDb = blackListUserRepository.getblacklistuserById(blacklistdto.getBlacklistuserId());
		if (blacklistDb != null) {
			blackListUserRepository.deleteById(blacklistdto.getBlacklistuserId());
			message = "BlackListUser deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "backlistuser Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

}
