package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.AddCoursemateialRequest;
import com.traditional.yoga.dto.request.CoursesListRequest;
import com.traditional.yoga.dto.request.MaterialCategoryRequest;
import com.traditional.yoga.dto.request.OnlineExamReqest;
import com.traditional.yoga.dto.request.TaskRequest;
import com.traditional.yoga.dto.request.TestimoalRequest;
import com.traditional.yoga.model.AddCoursesMaterialModel;
import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.MaterialCategoryModel;
import com.traditional.yoga.model.TaskModel;
import com.traditional.yoga.model.TestimonalsModel;
import com.traditional.yoga.model.OnlineExamsModel;
import com.traditional.yoga.repository.AddMaterialRepository;
import com.traditional.yoga.repository.CategoryRepository;
import com.traditional.yoga.repository.CoursesListRepository;
import com.traditional.yoga.repository.LevelofTestRepository;
import com.traditional.yoga.repository.MaterialCategoryRepostiory;
import com.traditional.yoga.repository.MediaRepository;
import com.traditional.yoga.repository.OnlineExamRepository;
import com.traditional.yoga.repository.TaskRepository;
import com.traditional.yoga.repository.TestimonalRepository;
import com.traditional.yoga.repository.TypeofTestRepository;

@Service
public class CoursesandOnlineexamService {

	private static final Logger LOG = LoggerFactory.getLogger(CoursesandOnlineexamService.class);

	private static final String NOEXISTMESSAGE = "Operation Doesn't exist";

	private static final String ALERADYEXISTSMESSAGE = "task already exists";

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

	@Autowired
	MediaRepository mediaRepository;

	@Autowired
	MaterialCategoryRepostiory materialCategoryRepostiory;

	@Autowired
	AddMaterialRepository addMaterialRepository;

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
			} else if (operationType.equals("typeoftest")) {
				httpStatus = HttpStatus.OK;
				return typeofTestRepository.findAll();
			} else if (operationType.equals("leveloftest")) {
				httpStatus = HttpStatus.OK;
				return levelofTestRepository.findAll();
			} else if (operationType.equals("onlineexam")) {
				httpStatus = HttpStatus.OK;
				return onlineExamRepository.findAll();
			} else if (operationType.equals("task")) {
				httpStatus = HttpStatus.OK;
				return taskRepository.findAll();
			} else if (operationType.equals("testimonal")) {
				httpStatus = HttpStatus.OK;
				return testimonalRepository.findAll();
			} else if (operationType.equals("mediaType")) {
				httpStatus = HttpStatus.OK;
				return mediaRepository.findAll();
			} else if (operationType.equals("materialCategory")) {
				httpStatus = HttpStatus.OK;
				return materialCategoryRepostiory.findAll();
			} else if (operationType.equals("coursematerial")) {
				httpStatus = HttpStatus.OK;
				return addMaterialRepository.findAll();
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

	public Object manageCourses(String operation, CoursesListRequest courseListDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("add")) {
				addcourses(courseListDto);
			} else {
				message = NOEXISTMESSAGE;
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
		CourseListModel listNew = coursesListRepository.getcoursesListById(courseListDto.getCoursesId());
		if (listNew == null) {
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

	public Object onlineExams(String onlineExamString) {
		ObjectMapper objectMapper = new ObjectMapper();
		OnlineExamReqest onlineExamDto;
		try {
			onlineExamDto = objectMapper.readValue(onlineExamString, OnlineExamReqest.class);
			return mangeExams(onlineExamDto);
		} catch (JsonMappingException e) {
			message = "Exception in JsonMappingException Online Exam";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
			return new ResponseEntity<>(response, httpStatus);
		} catch (JsonProcessingException ep) {
			message = "Exception in JsonProcessingException Online Exam";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(ep.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), ep.getLocalizedMessage());
			return new ResponseEntity<>(response, httpStatus);
		}
	}

	public Object mangeExams(OnlineExamReqest onlineExamDto) {
		this.httpStatus = HttpStatus.OK;
		try {
			addOnlineExams(onlineExamDto);
		} catch (Exception e) {
			message = "Exception in adding exams";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addOnlineExams(OnlineExamReqest onlineexamDto) {
		OnlineExamsModel examNew = onlineExamRepository.getexamdetailsById(onlineexamDto.getExamsId());
		if (examNew == null) {
			OnlineExamsModel examList = new OnlineExamsModel();

			examList.setCourseId(onlineexamDto.getCourseId());
			examList.setTestId(onlineexamDto.getTestId());
			examList.setNameofTest(onlineexamDto.getNameofTest());
			examList.setLevelId(onlineexamDto.getLevelId());
			examList.setFileUpload(onlineexamDto.getFileUpload());
			examList.setDescription(onlineexamDto.getDescription());
			onlineExamRepository.save(examList);
			message = "new exam sheet is added sucessfully";
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
			} else {
				message = NOEXISTMESSAGE;
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
			message = ALERADYEXISTSMESSAGE;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

//	TESTIMONAL////
	public Object manageTestimonal(String operation, TestimoalRequest testimonalDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("add")) {
				addTestimonal(testimonalDto);
			} else if (operation.equals("update")) {
				updateTestimonal(testimonalDto);
			} else {
				message = NOEXISTMESSAGE;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding testimonals";
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
			testimonallist.setVideoLink(testimonalDto.getVideoLink());
			testimonallist.setDescription(testimonalDto.getDescription());
			testimonallist.setIsActive("Y");
			testimonalRepository.save(testimonallist);
			message = "new testimonial is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = ALERADYEXISTSMESSAGE;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	private void updateTestimonal(TestimoalRequest testimonalDto) {
		TestimonalsModel testimonalnew = testimonalRepository.getTestmonialsById(testimonalDto.getTestimonalId());

		if (testimonalnew != null) {
			TestimonalsModel testimonalcheck = testimonalRepository.getTestmonialsBycontent(testimonalDto.getContent());

			if (testimonalcheck == null) {
				TestimonalsModel testimonallist = new TestimonalsModel();
//				
				testimonallist.setContent(testimonalDto.getContent());
				testimonallist.setGivenByName(testimonalDto.getGivenByName());
				testimonallist.setVideoLink(testimonalDto.getVideoLink());
				testimonallist.setDescription(testimonalDto.getDescription());
				testimonallist.setIsActive("Y");
				testimonalRepository.save(testimonallist);
				message = " testimonial is Updated sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = ALERADYEXISTSMESSAGE;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

		}

	}

	/// Add Material Categorys/////

	public Object managematerialCategory(String operation, MaterialCategoryRequest materialcategoryDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("add")) {
				addcategorymaterial(materialcategoryDto);
			} else {
				message = NOEXISTMESSAGE;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding material to category";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addcategorymaterial(MaterialCategoryRequest materialcategoryDto) {
		MaterialCategoryModel materialnew = materialCategoryRepostiory
				.getotherById(materialcategoryDto.getMaterialCategoryId());
		if (materialnew != null) {
			MaterialCategoryModel materiallist = new MaterialCategoryModel();
			materiallist.setCategoryName(materialcategoryDto.getCategoryName());
			materiallist.setIsActive("Y");
			materialCategoryRepostiory.save(materiallist);
			message = "new category is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = ALERADYEXISTSMESSAGE;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	/// ADD MATERIAL COURSES///////
	public Object managemateials(String operation, AddCoursemateialRequest materialDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals("add")) {
				addmaterials(materialDto);
			} else {
				message = NOEXISTMESSAGE;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in adding materials";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void addmaterials(AddCoursemateialRequest materialDto) {
		AddCoursesMaterialModel materialnew = addMaterialRepository.getmaterialById(materialDto.getCourseMaterialId());
		if (materialnew == null) {
			AddCoursesMaterialModel materialList = new AddCoursesMaterialModel();
//			
			materialList.setCoursesId(materialDto.getCoursesId());
			materialList.setAddCategory(materialDto.getAddCategory());
			materialList.setAddDescription(materialDto.getAddDescription());
			materialList.setMaterialCategoryId(materialDto.getMaterialCategoryId());
			materialList.setMediaId(materialDto.getMediaId());
			materialList.setVideoLink(materialDto.getVideoLink());
			materialList.setFileUpload(materialDto.getFileUpload());
			materialList.setMessage(materialDto.getMessage());
			materialList.setIsActive("Y");
			addMaterialRepository.save(materialList);
			message = "material to courses is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "material  already exists";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}
}
