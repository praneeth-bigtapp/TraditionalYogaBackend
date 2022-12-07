package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.CoursesListRequest;
import com.traditional.yoga.dto.request.OnlineExamReqest;
import com.traditional.yoga.dto.request.TaskRequest;
import com.traditional.yoga.dto.request.TestimoalRequest;
import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.TaskModel;
import com.traditional.yoga.model.TestimonalsModel;
import com.traditional.yoga.model.onlineexamsModel;
import com.traditional.yoga.repository.CategoryRepository;
import com.traditional.yoga.repository.CoursesListRepository;
import com.traditional.yoga.repository.LevelofTestRepository;
import com.traditional.yoga.repository.OnlineExamRepository;
import com.traditional.yoga.repository.TaskRepository;
import com.traditional.yoga.repository.TestimonalRepository;
import com.traditional.yoga.repository.TypeofTestRepository;

@Service
public class CoursesandOnlineexamService {

	private static final Logger LOG = LoggerFactory.getLogger(CourseManagementService.class);

	@Autowired
	CoursesListRepository coursesListRepository;

	@Autowired
	TypeofTestRepository typeofTestRepository;

	@Autowired
	LevelofTestRepository levelofTestRepository;

	@Autowired
	OnlineExamRepository onlineExamRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TestimonalRepository testimonalRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	public Object getAll(String operationType) {
		LOG.info("Fetching courses List related {} data", operationType);
		try {
			if (operationType.equals("coursesList")) {
				httpStatus = HttpStatus.OK;
				return coursesListRepository.findAll();
			} else if (operationType.equals("categoryList")) {
				httpStatus = HttpStatus.OK;
				return categoryRepository.findAll();
			}
			else if (operationType.equals("typeoftest")) {
				httpStatus = HttpStatus.OK;
				return typeofTestRepository.findAll();
			} else if (operationType.equals("leveloftest")) {
				httpStatus = HttpStatus.OK;
				return levelofTestRepository.findAll();
			} else if (operationType.equals("onlineexam")) {
				httpStatus = HttpStatus.OK;
				return onlineExamRepository.findAll();
			}else if (operationType.equals("task")) {
				httpStatus = HttpStatus.OK;
				return taskRepository.findAll();
			} else if (operationType.equals("testimonal")) {
				httpStatus = HttpStatus.OK;
				return testimonalRepository.findAll();
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

	public Object managecourses(String operation, CoursesListRequest courseListDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("add")) {
				addcourses(courseListDto);
			} else if (operation.equals("")) {
//				onlineexams(onlineexamDto);
			} else if (operation.equals("active")) {
//				activeUsers(userDto);
			} else if (operation.equals("delete")) {
//				deleteUsers(userDto);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding courses";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addcourses(CoursesListRequest courseListDto) {
		CourseListModel ListNew = coursesListRepository.getcoursesListById(courseListDto.getCoursesId());
		if (ListNew == null) {
			CourseListModel newlist = new CourseListModel();

			newlist.setCoursesName(courseListDto.getCoursesName());
			newlist.setCategorieId(courseListDto.getCategorieId());
			newlist.setDescription(courseListDto.getDescription());
			newlist.setStartDate(courseListDto.getStartDate());
			newlist.setEndDate(courseListDto.getEndDate());
			newlist.setApplicationClouserDate(courseListDto.getApplicationClouserDate());
			coursesListRepository.save(newlist);
			message = "new courses  added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "course  is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	public Object onlineexams(String operation, OnlineExamReqest onlineexamDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("add")) {
				onlineexams(onlineexamDto);
			} else if (operation.equals("")) {

			} else if (operation.equals("active")) {
//				activeUsers(userDto);
			} else if (operation.equals("delete")) {
//				deleteUsers(userDto);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding courses";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void onlineexams(OnlineExamReqest onlineexamDto) {
		onlineexamsModel examNew = onlineExamRepository.getexamdetailsById(onlineexamDto.getExamsId());
		if (examNew == null) {
			onlineexamsModel examList = new onlineexamsModel();

			examList.setCourseId(onlineexamDto.getCourseId());
			examList.setTestId(onlineexamDto.getTestId());
			examList.setNameofTest(onlineexamDto.getNameofTest());
			examList.setLevelId(onlineexamDto.getLevelId());
			examList.setFileUpload(onlineexamDto.getFileUpload());
			examList.setDescription(onlineexamDto.getDescription());
			onlineExamRepository.save(examList);
			message = "new exam sheet is   added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "course  is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}
	
	
	
	
	
	
	public Object managetask(String operation, TaskRequest taskDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("add")) {
				addTask(taskDto);
			} else if (operation.equals("")) {

			} else if (operation.equals("active")) {
//				activeUsers(userDto);
			} else if (operation.equals("delete")) {
//				deleteUsers(userDto);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding courses";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}
	
	private void addTask(TaskRequest taskDto) {
		TaskModel tasknew = taskRepository.getTaskById(taskDto.getTaskId());
		if (tasknew == null) {
			TaskModel tasklist = new TaskModel();
			tasklist.setCoursesId(taskDto.getCoursesId());
			tasklist.setTaskName(taskDto.getTaskName());
			tasklist.setDescription(taskDto.getDescription());
			tasklist.setMediafile(taskDto.getMediafile());
			tasklist.setDueDate(taskDto.getDueDate());
			tasklist.setIsActive("Y");
			taskRepository.save(tasklist);
			message = "new task added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "task already exists";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}
	
	
	public Object manageTestimonal(String operation, TestimoalRequest testimonalDto) {
		
		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("add")) {
				addTestimonal(testimonalDto);
			} else if (operation.equals("")) {

			} else if (operation.equals("active")) {
//				activeUsers(userDto);
			} else if (operation.equals("delete")) {
//				deleteUsers(userDto);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding courses";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}
		
	private void addTestimonal(TestimoalRequest testimonalDto) {
		TestimonalsModel testimonalnew = testimonalRepository.getTestmonialsById(testimonalDto.getTestimonalId());
		if (testimonalnew == null) {
			TestimonalsModel testimonallist = new TestimonalsModel();
//			
			testimonallist.setContent(testimonalDto.getContent());
			testimonallist.setGivenByName(testimonalDto.getGivenByName());
			testimonallist.setVideo_link(testimonalDto.getVideo_link());
			testimonallist.setDescription(testimonalDto.getDescription());
			testimonallist.setIsActive("Y");
			testimonalRepository.save(testimonallist);
			message = "new testimonial is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "task already exists";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}
}
