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
import com.traditional.yoga.dto.request.CreateAlbumRequest;
import com.traditional.yoga.dto.request.PerformaceRatingRequest;
import com.traditional.yoga.dto.response.ParameterResponse;
import com.traditional.yoga.model.AudioManagementModel;
import com.traditional.yoga.model.CourseMediaModel;
import com.traditional.yoga.model.CourseMediaPracticeModel;
import com.traditional.yoga.model.CreateAlbumModel;
import com.traditional.yoga.model.PerformaceRatingModel;
import com.traditional.yoga.repository.AudioCategoryLibaryRepository;
import com.traditional.yoga.repository.AudioManagementRepository;
import com.traditional.yoga.repository.CourseMediaCategoryRepository;
import com.traditional.yoga.repository.CourseMediaPracticeRepository;
import com.traditional.yoga.repository.CourseMediaRepository;
import com.traditional.yoga.repository.CourseMediaTypeRepository;
import com.traditional.yoga.repository.CreateAlbumRepository;
import com.traditional.yoga.repository.MasterAudioRepository;
import com.traditional.yoga.repository.PerformaceRatingRepository;
import com.traditional.yoga.utils.Constants;
import com.traditional.yoga.utils.GeneralUtils;

@Service
public class CourseManagementService {

	private static final Logger LOG = LoggerFactory.getLogger(CourseManagementService.class);

	@Autowired
	GeneralUtils generalUtils;

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

	@Autowired
	MasterAudioRepository masterAudioRepository;

	@Autowired
	AudioCategoryLibaryRepository audioCategoryLibaryRepository;

	@Autowired
	CreateAlbumRepository albumRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching Student related {} data", operationType);

		try {
			if (operationType.equals("courseMediaCategory")) {
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
			} else if (operationType.equals("audio-type")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(masterAudioRepository.findAll(), httpStatus);
			} else if (operationType.equals("audio-category")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(audioCategoryLibaryRepository.findAll(), httpStatus);
			} else if (operationType.equals("createAlbum")) {
				httpStatus = HttpStatus.OK;
				return new ResponseEntity<>(albumRepository.findAll(), httpStatus);

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

	public Object courseMediaManage(CourseMediaRequest courseMediaDto, String operation, String type) {
		try {
			if (type.equals("video")) {
				courseVideo(courseMediaDto, operation);
			} else if (type.equals("shortVideo")) {
				courseShortVideo(courseMediaDto, operation);
			} else if (type.equals("glimpses")) {
				glimpses(courseMediaDto, operation);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in Course Media";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void glimpses(CourseMediaRequest courseMediaDto, String operation) {
		if (operation.equals(Constants.ADD)) {
			addCourseGlimpses(courseMediaDto);
		} else if (operation.equals(Constants.SAVE)) {
			updateCourseGlimpses(courseMediaDto);
		} else if (operation.equals(Constants.DELETE)) {
			deleteCourseGlimpses(courseMediaDto);
		} else {
			message = Constants.OPERATION_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	private void addCourseGlimpses(CourseMediaRequest courseMediaDto) {
		CourseMediaModel newCourseMedia = new CourseMediaModel();
		newCourseMedia.setCourseId(courseMediaDto.getCourseId());
		newCourseMedia.setDate(courseMediaDto.getDate());
		newCourseMedia.setFileName(courseMediaDto.getFileName());

		courseMediaRepository.save(newCourseMedia);
		httpStatus = HttpStatus.OK;
		message = "Course Glimpses added sucessfully";
		LOG.info(message);
		response = new Response(message, httpStatus.value(), null);
	}

	private void updateCourseGlimpses(CourseMediaRequest courseMediaDto) {
		CourseMediaModel courseMediaDb = courseMediaRepository.getCourseMediaById(courseMediaDto.getCourseMediaId());
		if (courseMediaDb != null) {
			courseMediaDb.setCourseId(courseMediaDto.getCourseId());
			courseMediaDb.setDate(courseMediaDto.getDate());
			courseMediaDb.setFileName(courseMediaDto.getFileName());

			courseMediaRepository.save(courseMediaDb);
			httpStatus = HttpStatus.OK;
			message = "Course Glimpses updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Course Glimpses is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteCourseGlimpses(CourseMediaRequest courseMediaDto) {
		CourseMediaModel courseMediaDb = courseMediaRepository.getCourseMediaById(courseMediaDto.getCourseMediaId());
		if (courseMediaDb != null) {
			courseMediaRepository.deleteById(courseMediaDto.getCourseMediaId());
			httpStatus = HttpStatus.OK;
			message = "Course Glimpses deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Course Glimpses is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	//// short VIDEO/////
	private void courseShortVideo(CourseMediaRequest courseMediaDto, String operation) {
		if (operation.equals(Constants.ADD)) {
			addCourseShortVideo(courseMediaDto);
		} else if (operation.equals(Constants.SAVE)) {
			updateCourseShortVideo(courseMediaDto);
		} else if (operation.equals(Constants.DELETE)) {
			deleteCourseShortVideo(courseMediaDto);
		} else {
			message = Constants.OPERATION_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void addCourseShortVideo(CourseMediaRequest courseMediaDto) {
		CourseMediaModel newCourseMedia = new CourseMediaModel();
		newCourseMedia.setCourseId(courseMediaDto.getCourseId());
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
	}

	private void updateCourseShortVideo(CourseMediaRequest courseMediaDto) {
		CourseMediaModel courseShortVideoDb = courseMediaRepository
				.getCourseMediaById(courseMediaDto.getCourseMediaId());

		if (courseShortVideoDb != null) {
			courseShortVideoDb.setCourseId(courseMediaDto.getCourseId());
			courseShortVideoDb.setCourseLink(courseMediaDto.getCourseLink());
			courseShortVideoDb.setDate(courseMediaDto.getDate());
			courseShortVideoDb.setDuration(courseMediaDto.getDuration());
			courseShortVideoDb.setTitle(courseMediaDto.getTitle());
			courseShortVideoDb.setCatgoryId(courseMediaDto.getCatgoryId());
			courseShortVideoDb.setDescription(courseMediaDto.getDescription());

			courseMediaRepository.save(courseShortVideoDb);
			httpStatus = HttpStatus.OK;
			message = "Course Short Video updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Course Short Video is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteCourseShortVideo(CourseMediaRequest courseMediaDto) {
		CourseMediaModel courseShortVideoDb = courseMediaRepository
				.getCourseMediaById(courseMediaDto.getCourseMediaId());

		if (courseShortVideoDb != null) {
			courseMediaRepository.deleteById(courseMediaDto.getCourseMediaId());
			httpStatus = HttpStatus.OK;
			message = "Course Short Video delete sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Course Short Video is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void courseVideo(CourseMediaRequest courseMediaDto, String operation) {
		if (operation.equals(Constants.ADD)) {
			addCourseVideo(courseMediaDto);
		} else if (operation.equals(Constants.SAVE)) {
			updateCourseVideo(courseMediaDto);
		} else if (operation.equals(Constants.DELETE)) {
			deleteCourseVideo(courseMediaDto);
		} else {
			message = Constants.OPERATION_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	private void addCourseVideo(CourseMediaRequest courseMediaDto) {
		CourseMediaModel newCourseMedia = new CourseMediaModel();
		newCourseMedia.setCourseLink(courseMediaDto.getCourseLink());
		newCourseMedia.setCourseId(courseMediaDto.getCourseId());
		newCourseMedia.setDate(courseMediaDto.getDate());
		newCourseMedia.setTitle(courseMediaDto.getTitle());
		newCourseMedia.setDescription(courseMediaDto.getDescription());

		courseMediaRepository.save(newCourseMedia);
		httpStatus = HttpStatus.OK;
		message = "Course Video added sucessfully";
		LOG.info(message);
		response = new Response(message, httpStatus.value(), null);
	}

	private void updateCourseVideo(CourseMediaRequest courseMediaDto) {
		CourseMediaModel courseVideoDb = courseMediaRepository.getCourseMediaById(courseMediaDto.getCourseMediaId());
		if (courseVideoDb != null) {
			courseVideoDb.setCourseLink(courseMediaDto.getCourseLink());
			courseVideoDb.setCourseId(courseMediaDto.getCourseId());
			courseVideoDb.setDate(courseMediaDto.getDate());
			courseVideoDb.setTitle(courseMediaDto.getTitle());
			courseVideoDb.setDescription(courseMediaDto.getDescription());

			courseMediaRepository.save(courseVideoDb);
			httpStatus = HttpStatus.OK;
			message = "Course Video updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Course Video is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteCourseVideo(CourseMediaRequest courseMediaDto) {
		CourseMediaModel courseVideoDb = courseMediaRepository.getCourseMediaById(courseMediaDto.getCourseMediaId());
		if (courseVideoDb != null) {
			courseMediaRepository.deleteById(courseMediaDto.getCourseMediaId());
			httpStatus = HttpStatus.OK;
			message = "Course Video delete sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Course Video is not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
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
					parameterSectionA.setCourseId(rating.getCourseId().getCoursesId());
					parameterSectionA.setCourseName(rating.getCourseId().getCoursesName());
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
					parameterSectionB.setCourseId(rating.getCourseId().getCoursesId());
					parameterSectionB.setCourseName(rating.getCourseId().getCoursesName());
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
		newAudio.setAudioType(audioManagementDto.getAudioType());
		newAudio.setAudioFile(audioManagementDto.getAudioFile());
		newAudio.setAudioTitle(audioManagementDto.getAudioTitle());
		newAudio.setAudioDesc(audioManagementDto.getAudioDesc());
		newAudio.setAudioDuration(audioManagementDto.getAudioDuration());
		newAudio.setMetakey(audioManagementDto.getMetakey());
		newAudio.setIsActive(audioManagementDto.getActive());
		audioManagementRepository.save(newAudio);
		message = "Audio details added sucessfully";
		LOG.info(message);
		response = new Response(message, httpStatus.value(), null);
	}

	private void updateAudio(AudioManagementRequest audioManagementDto) {
		AudioManagementModel audioDb = audioManagementRepository.getAudioById(audioManagementDto.getId());
		if (audioDb != null) {
			audioDb.setCourseId(audioManagementDto.getCourseId());
			audioDb.setAudioCategoryId(audioManagementDto.getAudioCategoryId());
			audioDb.setUploadCategory(audioManagementDto.getUploadCategory());
			audioDb.setAudioType(audioManagementDto.getAudioType());
			audioDb.setAudioFile(audioManagementDto.getAudioFile());
			audioDb.setAudioTitle(audioManagementDto.getAudioTitle());
			audioDb.setAudioDesc(audioManagementDto.getAudioDesc());
			audioDb.setAudioDuration(audioManagementDto.getAudioDuration());
			audioDb.setMetakey(audioManagementDto.getMetakey());
			audioDb.setIsActive(audioManagementDto.getActive());
			audioManagementRepository.save(audioDb);
			message = "audio file updated successfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "audio file not found";
			httpStatus = HttpStatus.NOT_FOUND;
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

	// create Album

	public Object manageAlbum(String operation, CreateAlbumRequest albumDto) {
		try {
			if (operation.equals(Constants.ADD)) {
				addAlbum(albumDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateAlbum(albumDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteAlbum(albumDto);
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

	private void addAlbum(CreateAlbumRequest albumDto) {
		CreateAlbumModel listNew = albumRepository.getAlbumById(albumDto.getAlbumId());
		if (listNew == null) {
			CreateAlbumModel album = new CreateAlbumModel();
			album.setAlbumName(albumDto.getAlbumName());
			album.setCreatedDate(generalUtils.getCurrentDate());
			album.setIsActive("Y");
			albumRepository.save(album);
			message = "new courses  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "course is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateAlbum(CreateAlbumRequest albumDto) {
		CreateAlbumModel album = albumRepository.getAlbumById(albumDto.getAlbumId());
		if (album != null) {
			album.setAlbumName(albumDto.getAlbumName());
			album.setUpdatedDate(generalUtils.getCurrentDate());
			albumRepository.save(album);
			message = "Album updated successfully";
			httpStatus = HttpStatus.OK;
			response = new Response(message, httpStatus.value(), message);
		} else {
			message = "Album not found";
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteAlbum(CreateAlbumRequest albumDto) {
		CreateAlbumModel album = albumRepository.getAlbumById(albumDto.getAlbumId());
		if (album != null) {
			albumRepository.delete(album);
			message = "Album deleted successfully";
			httpStatus = HttpStatus.OK;
			response = new Response(message, httpStatus.value(), message);
		} else {
			message = "Album not found";
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(message, httpStatus.value(), message);
		}
	}

}
