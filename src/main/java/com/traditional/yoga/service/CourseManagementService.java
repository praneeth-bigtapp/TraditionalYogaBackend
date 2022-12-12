package com.traditional.yoga.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.CourseMediaPracticeRequest;
import com.traditional.yoga.dto.request.CourseMediaRequest;
import com.traditional.yoga.dto.request.CourseRequest;
import com.traditional.yoga.dto.request.PerformaceRatingRequest;
import com.traditional.yoga.model.CourseMediaModel;
import com.traditional.yoga.model.CourseMediaPracticeModel;
import com.traditional.yoga.model.CourseModel;
import com.traditional.yoga.model.PerformaceRatingModel;
import com.traditional.yoga.repository.ClassMediaRepository;
import com.traditional.yoga.repository.CourseCategoryRepository;
import com.traditional.yoga.repository.CourseMediaCategoryRepository;
import com.traditional.yoga.repository.CourseMediaPracticeRepository;
import com.traditional.yoga.repository.CourseMediaRepository;
import com.traditional.yoga.repository.CourseRepository;
import com.traditional.yoga.repository.PerformaceRatingRepository;

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
	CourseMediaCategoryRepository courseMediaCategoryRepository;

	@Autowired
	CourseMediaPracticeRepository courseMediaPracticeRepository;

	@Autowired
	PerformaceRatingRepository performaceRatingRepository;

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
			httpStatus = HttpStatus.OK;
			LOG.info("Performace Rating Fetched sucessfully");
			return new ResponseEntity<>(ratingData, httpStatus);
		} catch (Exception e) {
			message = "Error in Parameters performance rating";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

	public Object manageRating(PerformaceRatingRequest performanceRatingDto) {
		try {
			PerformaceRatingModel updateRating = performaceRatingRepository
					.getRatingById(performanceRatingDto.getPerformaceRatingId());
			
			if (updateRating != null) {
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
				return new ResponseEntity<>(response, httpStatus);
			} else {
				message = "Student details Doesn't exist";
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

}
