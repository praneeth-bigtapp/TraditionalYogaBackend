package com.traditional.yoga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.dto.request.AddCoursemateialRequest;
import com.traditional.yoga.dto.request.CoursesListRequest;
import com.traditional.yoga.dto.request.MaterialCategoryRequest;
import com.traditional.yoga.dto.request.OnlineExamReqest;
import com.traditional.yoga.dto.request.PraticeDocumentRequest;
import com.traditional.yoga.dto.request.PraticeImageRequest;
import com.traditional.yoga.dto.request.PraticeMediaRequest;
import com.traditional.yoga.dto.request.TaskRequest;
import com.traditional.yoga.dto.request.TestimoalRequest;
import com.traditional.yoga.dto.request.UserCoursesRequest;
import com.traditional.yoga.dto.request.VideoAlbumRequest;
import com.traditional.yoga.service.CoursesandOnlineexamService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/courseList", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CoursesListAndOnlineExamController {

	private static final Logger LOG = LoggerFactory.getLogger(CoursesListAndOnlineExamController.class);

	@Autowired
	CoursesandOnlineexamService coursesListService;

	/**
	 * Authentication for Generated Token
	 * 
	 * @param token
	 */
	private void authenticate(String token) {
		LOG.debug(token);
		LOG.info("Validating the Token");
	}

	@GetMapping("/getAll")
	public Object getAllStudentDetails(@RequestHeader("token") String token,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into getAll{} Method", operation);
		return coursesListService.getAll(operation);
	}

	@PostMapping("/coursesList")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody CoursesListRequest courseListDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into coursesList{} Method", operation);
		return coursesListService.manageCourses(operation, courseListDto);
	}

	@PostMapping("/onlineExam")
	public Object onlineexams(@RequestHeader("token") String token, @RequestParam("operation") String operation,
			@RequestBody OnlineExamReqest onlineExamDto) {
		authenticate(token);
		LOG.info("Entering into onlineexam Method");
		return coursesListService.mangeExams(operation, onlineExamDto);
	}

	@PostMapping("/task")
	public Object manageTask(@RequestHeader("token") String token, @RequestBody TaskRequest taskDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into task{} Method", operation);
		return coursesListService.manageTask(operation, taskDto);
	}

	@PostMapping("/testimonal")
	public Object manageTestimonal(@RequestHeader("token") String token, @RequestBody TestimoalRequest testimonalDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into testimonal{} Method", operation);
		return coursesListService.manageTestimonal(operation, testimonalDto);
	}

	@PostMapping("/addMaterial")
	public Object managemateials(@RequestHeader("token") String token, @RequestBody AddCoursemateialRequest materialDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into addMaterial{} Method", operation);
		return coursesListService.manageMateials(operation, materialDto);
	}

	@PostMapping("/addcategoryMaterial")
	public Object managematerialCategory(@RequestHeader("token") String token,
			@RequestBody MaterialCategoryRequest materialcategoryDto, @RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into addMaterial{} Method", operation);
		return coursesListService.managematerialCategory(operation, materialcategoryDto);
	}

	@PostMapping("/praticeMedia")
	public Object praticeMedia(@RequestHeader("token") String token, @RequestBody PraticeMediaRequest mediaDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into praticeMedia{} Method", operation);
		return coursesListService.managemedia(operation, mediaDto);
	}
	
	
	@PostMapping("/praticeImageMedia")
	public Object manageimage(@RequestHeader("token") String token, @RequestBody PraticeImageRequest imageDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into praticeImage{} Method", operation);
		return coursesListService.manageimage(operation, imageDto);
	}

	
	@PostMapping("/praticedocumentMedia")
	public Object manageDocument(@RequestHeader("token") String token, @RequestBody  PraticeDocumentRequest documentDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into praticeDocument{} Method", operation);
		return coursesListService.manageDocument(operation, documentDto);
	}
	
	
	@PostMapping("/mapCourses")
	public Object manageUserCourses(@RequestHeader("token") String token, @RequestBody  UserCoursesRequest userCoursesDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into mapCoursesToUser{} Method", operation);
		return coursesListService.manageUserCourses(operation, userCoursesDto);
	}
	
	
	
	@PostMapping("/mapVideos")
	public Object manageAlbumVideos(@RequestHeader("token") String token, @RequestBody VideoAlbumRequest albumVideoDTO,
			@RequestParam("operation") String operation) {
		authenticate(token);
		LOG.info("Entering into map Videos to Album{} Method", operation);
		return coursesListService.manageAlbumVideos(operation, albumVideoDTO);
	}
}
