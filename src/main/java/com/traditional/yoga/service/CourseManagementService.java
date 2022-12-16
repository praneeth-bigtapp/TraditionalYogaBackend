package com.traditional.yoga.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.ParameterSectionA;
import com.traditional.yoga.dto.ParameterSectionB;
import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.AudioManagementRequest;
import com.traditional.yoga.dto.request.CourseMediaPracticeRequest;
import com.traditional.yoga.dto.request.CourseMediaRequest;
import com.traditional.yoga.dto.request.CourseRequest;
import com.traditional.yoga.dto.request.PerformaceRatingRequest;
import com.traditional.yoga.dto.response.ParameterResponse;
import com.traditional.yoga.model.AudioManagementModel;
import com.traditional.yoga.model.CourseMediaModel;
import com.traditional.yoga.model.CourseMediaPracticeModel;
import com.traditional.yoga.model.CourseModel;
import com.traditional.yoga.model.PerformaceRatingModel;
import com.traditional.yoga.repository.AudioManagementRepository;
import com.traditional.yoga.repository.ClassMediaRepository;
import com.traditional.yoga.repository.CourseCategoryRepository;
import com.traditional.yoga.repository.CourseMediaCategoryRepository;
import com.traditional.yoga.repository.CourseMediaPracticeRepository;
import com.traditional.yoga.repository.CourseMediaRepository;
import com.traditional.yoga.repository.CourseMediaTypeRepository;
import com.traditional.yoga.repository.CourseRepository;
import com.traditional.yoga.repository.PerformaceRatingRepository;
import com.traditional.yoga.utils.Constants;

@Service
public class CourseManagementService {

	private static final Logger LOG = LoggerFactory.getLogger(CourseManagementService.class);

	@Autowired
	CourseCategoryRepository courseCategoryRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ClassMediaRepository classMediaRepository;

	@Autowired
	CourseMediaRepository courseMediaRepository;

	@Autowired
	CourseMediaTypeRepository courseMediaTypeRepository;

	@Autowired
	CourseMediaCategoryRepository courseMediaCategoryRepository;

	@Autowired
	CourseMediaPracticeRepository courseMediaPracticeRepository;

	@Autowired
	PerformaceRatingRepository performaceRatingRepository;

	@Autowired
	AudioManagementRepository audioManagementRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Student related {} data", operationType);

		try {
			if (operationType.equals("courseCategory")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(courseCategoryRepository.findAll(), httpStatus);
			} else if (operationType.equals("classMedia")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(classMediaRepository.findAll(), httpStatus);
			} else if (operationType.equals("courseMediaCategory")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(courseMediaCategoryRepository.findAll(), httpStatus);
			} else if (operationType.equals("courseMediaPractice")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(courseMediaPracticeRepository.findAll(), httpStatus);
			} else if (operationType.equals("courseMediaType")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(courseMediaTypeRepository.findAll(), httpStatus);
			} else if (operationType.equals("audio")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(audioManagementRepository.findAll(), httpStatus);
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

	public Object addCourse(CourseRequest courseDto) {
		CourseModel newCourse = new CourseModel();
		newCourse.setCategory(courseDto.getCategory());
		newCourse.setCourseName(courseDto.getCourseName());
		newCourse.setCourseType(courseDto.getCourseType());
		newCourse.setSection(courseDto.getSection());
		newCourse.setEndDate(courseDto.getEndDate());
		newCourse.setStartDate(courseDto.getStartDate());
		newCourse.setCourseDuration(courseDto.getCourseDuration());
		newCourse.setVerficationRequired(courseDto.getVerficationRequired());
		newCourse.setCurrentStatus(courseDto.getCurrentStatus());
		courseRepository.save(newCourse);

		httpStatus = HttpStatus.OK;
		message = "Course added sucessfully";
		LOG.info(message);
		response = new Response(message, httpStatus.value(), null);
		return new ResponseEntity<>(response, httpStatus);
	}

	public Object courseMediaManage(CourseMediaRequest courseMediaDto, String type) {

		try {
			if (type.equals("video")) {
				CourseMediaModel newCourseMedia = new CourseMediaModel();
				newCourseMedia.setCourseLink(courseMediaDto.getCourseLink());
				newCourseMedia.setCourseId(null);
				newCourseMedia.setDate(courseMediaDto.getDate());
				newCourseMedia.setTitle(courseMediaDto.getTitle());
				newCourseMedia.setDescription(courseMediaDto.getDescription());
				courseMediaRepository.save(newCourseMedia);
				httpStatus = HttpStatus.OK;
				message = "Course Media added sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else if (type.equals("shortVideo")) {
				CourseMediaModel newCourseMedia = new CourseMediaModel();
				newCourseMedia.setCourseId(null);
				newCourseMedia.setCourseLink(courseMediaDto.getCourseLink());
				newCourseMedia.setDate(courseMediaDto.getDate());
				newCourseMedia.setDuration(courseMediaDto.getDuration());
				newCourseMedia.setTitle(courseMediaDto.getTitle());
				newCourseMedia.setCatgoryId(courseMediaDto.getCatgoryId());
				newCourseMedia.setDescription(courseMediaDto.getDescription());
				courseMediaRepository.save(newCourseMedia);
				httpStatus = HttpStatus.OK;
				message = "Course Short Video added sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else if (type.equals("glimpses")) {
				CourseMediaModel newCourseMedia = new CourseMediaModel();
				newCourseMedia.setCourseId(null);
				newCourseMedia.setDate(courseMediaDto.getDate());
				newCourseMedia.setFileName(courseMediaDto.getFileName());
				courseMediaRepository.save(newCourseMedia);
				httpStatus = HttpStatus.OK;
				message = "Glimpses added sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
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

	public Object courseMediaPraticeManage(CourseMediaPracticeRequest courseMediaDto) {

		try {
			CourseMediaPracticeModel newCourseMedia = new CourseMediaPracticeModel();
			newCourseMedia.setUploadMediaFile(courseMediaDto.getUploadMediaFile());
			newCourseMedia.setVideoLink(courseMediaDto.getVideoLink());
			newCourseMedia.setTitle(courseMediaDto.getTitle());
			newCourseMedia.setDescription(courseMediaDto.getDescription());
			newCourseMedia.setDuration(courseMediaDto.getDuration());
			newCourseMedia.setMetaKeyword(courseMediaDto.getMetaKeyword());
			courseMediaPracticeRepository.save(newCourseMedia);
			httpStatus = HttpStatus.OK;
			message = "Course Media added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);

		} catch (Exception e) {
			message = "Exception in Role";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}

		return new ResponseEntity<>(response, httpStatus);
	}

//	Parameters performance rating
	public Object getRating(int courseId) {
		try {
			List<PerformaceRatingModel> ratingData = performaceRatingRepository.getRatingByCourseId(courseId);
			ParameterResponse parameterResponse = new ParameterResponse();
			List<ParameterSectionA> record1 = new ArrayList<>();
			List<ParameterSectionB> record2 = new ArrayList<>();
			for (PerformaceRatingModel rating : ratingData) {
				int id = rating.getParametersId().getSection();
				if (id == 2) {
					ParameterSectionA parameterSectionA = new ParameterSectionA();
					parameterSectionA.setPerformanceId(rating.getId());
					parameterSectionA.setCourseId(rating.getCourseId().getCourseId());
					parameterSectionA.setCourseName(rating.getCourseId().getCourseName());
					parameterSectionA.setParametersId(rating.getParametersId().getParametersId());
					parameterSectionA.setParametersName(rating.getParametersId().getParametersName());
					parameterSectionA.setRatingGood(rating.getRatingGood());
					parameterSectionA.setRatingAvearage(rating.getRatingAvearage());
					parameterSectionA.setRatingPoor(rating.getRatingPoor());
					parameterSectionA.setRatingRedAlert(rating.getRatingRedAlert());
					parameterSectionA.setActive(rating.getActive());
					record1.add(parameterSectionA);
				} else if (id == 1) {
					ParameterSectionB parameterSectionB = new ParameterSectionB();
					parameterSectionB.setPerformanceId(rating.getId());
					parameterSectionB.setCourseId(rating.getCourseId().getCourseId());
					parameterSectionB.setCourseName(rating.getCourseId().getCourseName());
					parameterSectionB.setParametersId(rating.getParametersId().getParametersId());
					parameterSectionB.setParametersName(rating.getParametersId().getParametersName());
					parameterSectionB.setRating(rating.getRatingGood());
					parameterSectionB.setActive(rating.getActive());
					record2.add(parameterSectionB);
				} else {
					LOG.error("Section for paramerter is missmatched");
				}
			}
			parameterResponse.setSectionA(record1);
			parameterResponse.setSectionB(record2);

			httpStatus = HttpStatus.OK;
			LOG.info("Performace Rating Fetched sucessfully");
			return new ResponseEntity<>(parameterResponse, httpStatus);
		} catch (Exception e) {
			message = "Error in Parameters performance rating";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

	public Object manageRating(PerformaceRatingRequest performanceRatingDto, int section) {
		try {
			PerformaceRatingModel updateRating = performaceRatingRepository
					.getRatingById(performanceRatingDto.getPerformaceRatingId());

			if (updateRating != null) {
				updateRating(performanceRatingDto, updateRating, section);
				return new ResponseEntity<>(response, httpStatus);
			} else {
				message = "Performance Parameter details Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
				return new ResponseEntity<>(response, httpStatus);
			}
		} catch (Exception e) {
			message = "Error in Parameters performance rating";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

	private void updateRating(PerformaceRatingRequest performanceRatingDto, PerformaceRatingModel updateRating,
			int section) {
		if (section == 1) {
			updateRating.setRatingGood(performanceRatingDto.getRatingGood());
			updateRating.setRatingAvearage(performanceRatingDto.getRatingAvearage());
			updateRating.setRatingPoor(performanceRatingDto.getRatingPoor());
			updateRating.setRatingRedAlert(performanceRatingDto.getRatingRedAlert());
			updateRating.setActive(performanceRatingDto.getActive());
			performaceRatingRepository.save(updateRating);
			httpStatus = HttpStatus.OK;
			message = "Performance Rating updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else if (section == 2) {
			updateRating.setRatingGood(performanceRatingDto.getRatingGood());
			updateRating.setActive(performanceRatingDto.getActive());
			performaceRatingRepository.save(updateRating);
			httpStatus = HttpStatus.OK;
			message = "Performance Rating updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			httpStatus = HttpStatus.CONFLICT;
			message = "No such Section is present";
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
		updateRating.setRatingGood(performanceRatingDto.getRatingGood());
		updateRating.setRatingAvearage(performanceRatingDto.getRatingAvearage());
		updateRating.setRatingPoor(performanceRatingDto.getRatingPoor());
		updateRating.setRatingRedAlert(performanceRatingDto.getRatingRedAlert());
		updateRating.setActive(performanceRatingDto.getActive());
		performaceRatingRepository.save(updateRating);
		httpStatus = HttpStatus.OK;
		message = "Student Mapped sucessfully";
		LOG.info(message);
		response = new Response(message, httpStatus.value(), null);
	}

//	Audio
	public Object manageAudio(String operation, AudioManagementRequest audioManagementDto) {
		try {
			if (operation.equals(Constants.ADD)) {
				addAudio(audioManagementDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateAudio(audioManagementDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteAudio(audioManagementDto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Error in Audio";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addAudio(AudioManagementRequest audioManagementDto) {
		AudioManagementModel newAudio = new AudioManagementModel();
		newAudio.setCourseId(audioManagementDto.getCourseId());
		newAudio.setAudioCategoryId(audioManagementDto.getAudioCategoryId());
		newAudio.setUploadCategory(audioManagementDto.getUploadCategory());
		newAudio.setAudioFile(audioManagementDto.getAudioFile());
		newAudio.setAudioTitle(audioManagementDto.getAudioTitle());
		newAudio.setAudioDesc(audioManagementDto.getAudioDesc());
		newAudio.setAudioDuration(audioManagementDto.getAudioDuration());
		newAudio.setMetakey(audioManagementDto.getMetakey());
		newAudio.setActive(audioManagementDto.getActive());
		audioManagementRepository.save(newAudio);
		message = "Audio details added sucessfully";
		LOG.info(message);
		response = new Response(message, httpStatus.value(), null);
	}

	private void updateAudio(AudioManagementRequest audioManagementDto) {
		AudioManagementModel userDb = audioManagementRepository.getAudioById(audioManagementDto.getId());
		if (userDb != null) {
			userDb.setCourseId(audioManagementDto.getCourseId());
			userDb.setAudioCategoryId(audioManagementDto.getAudioCategoryId());
			userDb.setUploadCategory(audioManagementDto.getUploadCategory());
			userDb.setAudioFile(audioManagementDto.getAudioFile());
			userDb.setAudioTitle(audioManagementDto.getAudioTitle());
			userDb.setAudioDesc(audioManagementDto.getAudioDesc());
			userDb.setAudioDuration(audioManagementDto.getAudioDuration());
			userDb.setMetakey(audioManagementDto.getMetakey());
			userDb.setActive(audioManagementDto.getActive());
			audioManagementRepository.save(userDb);
			message = "Audio details added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Audio details are not found";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteAudio(AudioManagementRequest audioManagementDto) {
		AudioManagementModel userDb = audioManagementRepository.getAudioById(audioManagementDto.getId());
		if (userDb != null) {
			audioManagementRepository.deleteById(audioManagementDto.getId());
			message = "Audio details deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Audio details are not found";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

}
