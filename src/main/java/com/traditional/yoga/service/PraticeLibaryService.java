package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.ClassMediaLiveclassRequest;
import com.traditional.yoga.dto.request.ClassMediaShortVideoRequest;
import com.traditional.yoga.dto.request.PraticeLibaryRequest;
import com.traditional.yoga.model.ClassMediaLiveClassModel;
import com.traditional.yoga.model.ClassMediaShortVideoModel;
import com.traditional.yoga.model.PraticeLibaryModel;
import com.traditional.yoga.repository.CategoryLibaryRepository;
import com.traditional.yoga.repository.ClassMediaLiveClassRepository;
import com.traditional.yoga.repository.ClassMediaShortVideoRepository;
import com.traditional.yoga.repository.PraticeLibaryRepository;
import com.traditional.yoga.repository.SubCategoryPraticeRepsoitory;
import com.traditional.yoga.utils.Constants;
import com.traditional.yoga.utils.GeneralUtils;

@Service
public class PraticeLibaryService {

	private static final Logger LOG = LoggerFactory.getLogger(PraticeLibaryService.class);

	@Autowired
	GeneralUtils generalUtils;

	@Autowired
	PraticeLibaryRepository praticeLibaryRepository;
	@Autowired
	CategoryLibaryRepository categoryLibaryRepository;

	@Autowired
	SubCategoryPraticeRepsoitory subCategoryPraticeRepsoitory;

	@Autowired
	ClassMediaLiveClassRepository classMediaLiveClassRepository;

	@Autowired
	ClassMediaShortVideoRepository classMediaShortVideoRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching praticeLibary related {} data", operationType);

		try {
			if (operationType.equals("praticeLibary")) {
				httpStatus = HttpStatus.OK;
				return praticeLibaryRepository.findAll();
			} else if (operationType.equals("shortVideo")) {
				httpStatus = HttpStatus.OK;
				return classMediaShortVideoRepository.findAll();
			} else if (operationType.equals("liveclass")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(classMediaLiveClassRepository.findAll(), httpStatus);
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

	////// Class Media Live Class

	public Object manageClassMediaLive(String operation, ClassMediaLiveclassRequest classDto) {
		this.httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(Constants.ADD)) {
				addLiveClass(classDto);
			} else if (operation.equals(Constants.UPDATE)) {
				updateLiveClass(classDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteLiveClass(classDto.getLiveClassId());
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding tasks";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	/// ADD LIVE CLASS ///

	private void addLiveClass(ClassMediaLiveclassRequest classDto) {
		ClassMediaLiveClassModel classNew = classMediaLiveClassRepository
				.getClassMediaLiveclass(classDto.getLiveClassId());
		if (classNew == null) {
			ClassMediaLiveClassModel classlist = new ClassMediaLiveClassModel();
			classlist.setCoursesId(classDto.getCoursesId());
			classlist.setClassLink(classDto.getClassLink());
			classlist.setClassDate(classDto.getClassDate());
			classlist.setTitle(classDto.getTitle());
			classlist.setDescription(classDto.getDescription());
			classlist.setCreatedDate(generalUtils.getCurrentDate());
			classlist.setIsActive("Y");
			classMediaLiveClassRepository.save(classlist);
			message = "new LiveClass added to ClassMedia sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Task " + Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	// update the classMedia LiveClass

	private void updateLiveClass(ClassMediaLiveclassRequest classDto) {
		ClassMediaLiveClassModel classToUpdate = classMediaLiveClassRepository
				.getClassMediaLiveclass(classDto.getLiveClassId());
		if (classToUpdate == null) {
			message = "Live class with ID " + classDto.getLiveClassId() + " not found";
			httpStatus = HttpStatus.NOT_FOUND;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		} else {
			classToUpdate.setCoursesId(classDto.getCoursesId());
			classToUpdate.setClassLink(classDto.getClassLink());
			classToUpdate.setClassDate(classDto.getClassDate());
			classToUpdate.setTitle(classDto.getTitle());
			classToUpdate.setDescription(classDto.getDescription());
			classToUpdate.setIsActive("Y");
			classMediaLiveClassRepository.save(classToUpdate);
			message = "Live class updated successfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		}
	}

	// delete the classMedia

	private void deleteLiveClass(int liveClassId) {
		ClassMediaLiveClassModel classToDelete = classMediaLiveClassRepository.getClassMediaLiveclass(liveClassId);
		if (classToDelete == null) {
			message = "Live class with ID " + liveClassId + " not found";
			httpStatus = HttpStatus.NOT_FOUND;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		} else {
			classMediaLiveClassRepository.delete(classToDelete);
			message = "Live class with ID " + liveClassId + " deleted successfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		}
	}

	// class media_shortVideo

	public Object manageShortVideo(String operation, ClassMediaShortVideoRequest shortDto) {
		this.httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(Constants.ADD)) {
				addShortVideo(shortDto);
			} else if (operation.equals(Constants.UPDATE)) {
				updateShortVideo(shortDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteShortVideo(shortDto.getShortVideoId());
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding tasks";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addShortVideo(ClassMediaShortVideoRequest shortDto) {
		ClassMediaShortVideoModel classNew = classMediaShortVideoRepository
				.getshortVideobyId(shortDto.getShortVideoId());
		if (classNew == null) {
			ClassMediaShortVideoModel classlist = new ClassMediaShortVideoModel();
			classlist.setCoursesId(shortDto.getCoursesId());
			classlist.setPraticeLibaryId(shortDto.getPraticeLibaryId());
			classlist.setSubCategoryId(shortDto.getSubCategoryId());
			classlist.setVideoLink(shortDto.getVideoLink());
			classlist.setTitle(shortDto.getTitle());
			classlist.setDescription(shortDto.getDescription());
			classlist.setClassDate(shortDto.getClassDate());
			classlist.setDuration(shortDto.getDuration());
			classlist.setCreatedDate(generalUtils.getCurrentDate());
			classlist.setIsActive("Y");
			classMediaShortVideoRepository.save(classlist);
			message = "new LiveClass added to ClassMedia sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Task " + Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	private void updateShortVideo(ClassMediaShortVideoRequest shortDto) {
		ClassMediaShortVideoModel classNew = classMediaShortVideoRepository
				.getshortVideobyId(shortDto.getShortVideoId());
		if (classNew == null) {
			message = "Short video with ID " + shortDto.getShortVideoId() + " does not exist";
			httpStatus = HttpStatus.NOT_FOUND;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		} else {
			classNew.setCoursesId(shortDto.getCoursesId());
			classNew.setPraticeLibaryId(shortDto.getPraticeLibaryId());
			classNew.setSubCategoryId(shortDto.getSubCategoryId());
			classNew.setVideoLink(shortDto.getVideoLink());
			classNew.setTitle(shortDto.getTitle());
			classNew.setDescription(shortDto.getDescription());
			classNew.setClassDate(shortDto.getClassDate());
			classNew.setDuration(shortDto.getDuration());
			classNew.setUpdatedDate(generalUtils.getCurrentDate());
			classMediaShortVideoRepository.save(classNew);
			message = "Short video with ID " + shortDto.getShortVideoId() + " updated successfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		}
	}

	private void deleteShortVideo(int shortVideoId) {
		ClassMediaShortVideoModel classNew = classMediaShortVideoRepository.getshortVideobyId(shortVideoId);
		if (classNew == null) {
			message = "Short video with ID " + shortVideoId + " does not exist";
			httpStatus = HttpStatus.NOT_FOUND;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		} else {
			classMediaShortVideoRepository.delete(classNew);
			message = "Short video with ID " + shortVideoId + " deleted successfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		}
	}

}
