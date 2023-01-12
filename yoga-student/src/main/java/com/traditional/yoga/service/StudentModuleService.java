package com.traditional.yoga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.GrattitudeMessageRequest;
import com.traditional.yoga.model.GrattitudeMessageModel;
import com.traditional.yoga.model.NotificationModel;
import com.traditional.yoga.model.UserCoursesModel;
import com.traditional.yoga.repository.GrattittudeMessageRepository;
import com.traditional.yoga.repository.NoticationRepository;
import com.traditional.yoga.repository.UserCoursesRepository;
import com.traditional.yoga.utils.StudentConstants;

@Service
public class StudentModuleService {

	private static final Logger LOG = LoggerFactory.getLogger(StudentModuleService.class);
	 public static final String PAST_COURSES = "pastCourses";

	@Autowired
	GrattittudeMessageRepository grattittudeMessageRepository;
	
	@Autowired
	UserCoursesRepository userCoursesRepository;
	
	@Autowired
	NoticationRepository noticationRepository;
	
	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;
	

	public Object getAll(String operationType) {
		LOG.info("Fetching Student related {} data", operationType);

		try {
			if (operationType.equals("grattitudeMessage")) {
				httpStatus = HttpStatus.OK;
				return grattittudeMessageRepository.findAll();
			}
			else {
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

	
	//past courses//
	
	 public Object getPastCourses(int studentId) {
	        this.httpStatus = HttpStatus.OK;
	        List<UserCoursesModel> pastCourses = new ArrayList<>();
	        try {
	            pastCourses = userCoursesRepository.getUserCourses(studentId);
	            if (pastCourses.isEmpty()) {
	                message = "No past courses found for student with id: " + studentId;
	                LOG.info(message);
	            }
	        } catch (Exception e) {
	            message = "Error Occured while retriving the past courses";
	            httpStatus = HttpStatus.EXPECTATION_FAILED;
	            LOG.error(message);
	            LOG.error(e.getLocalizedMessage());
	        }
	        return new ResponseEntity<>(pastCourses, httpStatus);
	    }

	//Gratitude message//
	public Object manageMessage(String operation, GrattitudeMessageRequest messageDto) {
		this.httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(StudentConstants.ADD)) {
				addmessage(messageDto);
			} else if (operation.equals(StudentConstants.UPDATE)) {
				updatemessage(messageDto);
			} else if (operation.equals(StudentConstants.DELETE)) {
				deletemessage(messageDto.getMessageId());
			} else {
				message = StudentConstants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding messages";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addmessage(GrattitudeMessageRequest messagedto) {
		GrattitudeMessageModel newMessage = grattittudeMessageRepository.getMessagebyId(messagedto.getMessageId());
		if (newMessage == null) {
			GrattitudeMessageModel newlist = new GrattitudeMessageModel();
			newlist.setStudentId(messagedto.getStudentId());
			newlist.setReflectionLiveClass(messagedto.getReflectionLiveClass());
			newlist.setReflectionPraticeSession(messagedto.getReflectionPraticeSession());
			newlist.setReflectionPersonalTransformation(messagedto.getReflectionPersonalTransformation());
			newlist.setVedicNutraceutialsProducts(messagedto.getVedicNutraceutialsProducts());
			newlist.setFileUpload(messagedto.getFileUpload());
			grattittudeMessageRepository.save(newlist);
			message = "grattidue Message is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = StudentConstants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}
	private void updatemessage(GrattitudeMessageRequest messagedto) {
	    GrattitudeMessageModel existingMessage = grattittudeMessageRepository.getMessagebyId(messagedto.getMessageId());
	    if (existingMessage != null) {
	        existingMessage.setStudentId(messagedto.getStudentId());
	        existingMessage.setReflectionLiveClass(messagedto.getReflectionLiveClass());
	        existingMessage.setReflectionPraticeSession(messagedto.getReflectionPraticeSession());
	        existingMessage.setReflectionPersonalTransformation(messagedto.getReflectionPersonalTransformation());
	        existingMessage.setVedicNutraceutialsProducts(messagedto.getVedicNutraceutialsProducts());
	        existingMessage.setFileUpload(messagedto.getFileUpload());
	        grattittudeMessageRepository.save(existingMessage);
	        message = "grattidue Message is updated sucessfully";
	        LOG.info(message);
	        response = new Response(message, httpStatus.value(), null);
	    } else {
	        message = "grattitude message not found";
	        httpStatus = HttpStatus.NOT_FOUND;
	        LOG.error(message);
	        response = new Response(message, httpStatus.value(), message);
	    }
	}

	private void deletemessage(int messageId) {
	    GrattitudeMessageModel existingMessage = grattittudeMessageRepository.getMessagebyId(messageId);
	    if (existingMessage != null) {
	        grattittudeMessageRepository.delete(existingMessage);
	        message = "grattidue message is deleted sucessfully";
	        LOG.info(message);
	        response = new Response(message, httpStatus.value(), null);
	    } else {
	        message = "grattitude message not found";
	        httpStatus = HttpStatus.NOT_FOUND;
	        LOG.error(message);
	        response = new Response(message, httpStatus.value(), message);
	    }
	}

	
	///Notification
	
	
	public List<NotificationModel> getNotificationByCategoryId(int categoryId) {
        List<NotificationModel> allNotification = noticationRepository.findAll();
        return allNotification.stream().filter(notification -> notification.getCategoryId().getCategoryId() == categoryId).collect(Collectors.toList());
    }
	
}
