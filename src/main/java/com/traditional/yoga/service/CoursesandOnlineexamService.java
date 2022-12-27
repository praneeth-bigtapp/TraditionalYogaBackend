package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.request.AddCoursemateialRequest;
import com.traditional.yoga.dto.request.CoursesListRequest;
import com.traditional.yoga.dto.request.MaterialCategoryRequest;
import com.traditional.yoga.dto.request.OnlineExamReqest;
import com.traditional.yoga.dto.request.PraticeDocumentRequest;
import com.traditional.yoga.dto.request.PraticeImageRequest;
import com.traditional.yoga.dto.request.PraticeMediaRequest;
import com.traditional.yoga.dto.request.TaskRequest;
import com.traditional.yoga.dto.request.TestimoalRequest;
import com.traditional.yoga.model.AddCoursesMaterialModel;
import com.traditional.yoga.model.CourseListModel;
import com.traditional.yoga.model.MaterialCategoryModel;
import com.traditional.yoga.model.OnlineExamsModel;
import com.traditional.yoga.model.PraticeDocumentModel;
import com.traditional.yoga.model.PraticeImageModel;
import com.traditional.yoga.model.PraticeMediaModel;
import com.traditional.yoga.model.TaskModel;
import com.traditional.yoga.model.TestimonalsModel;
import com.traditional.yoga.repository.AddMaterialRepository;
import com.traditional.yoga.repository.CategoryRepository;
import com.traditional.yoga.repository.CoursesListRepository;
import com.traditional.yoga.repository.LevelofTestRepository;
import com.traditional.yoga.repository.MaterialCategoryRepostiory;
import com.traditional.yoga.repository.MediaRepository;
import com.traditional.yoga.repository.OnlineExamRepository;
import com.traditional.yoga.repository.PraticeDocumentRepository;
import com.traditional.yoga.repository.PraticeImageRepository;
import com.traditional.yoga.repository.PraticeMediaRepository;
import com.traditional.yoga.repository.TaskRepository;
import com.traditional.yoga.repository.TestimonalRepository;
import com.traditional.yoga.repository.TypeofTestRepository;
import com.traditional.yoga.utils.Constants;
import com.traditional.yoga.utils.GeneralUtils;

@Service
public class CoursesandOnlineexamService {

	private static final Logger LOG = LoggerFactory.getLogger(CoursesandOnlineexamService.class);

	@Autowired
	GeneralUtils generalUtils;

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

	/// new

	@Autowired
	PraticeMediaRepository praticeMediaRepository;

	@Autowired
	PraticeImageRepository praticeImageRepository;

	@Autowired
	PraticeDocumentRepository praticeDocumentRepository;

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
			} else if (operationType.equals("praticeMedia")) {
				httpStatus = HttpStatus.OK;
				return praticeMediaRepository.findAll();
			} else if (operationType.equals("praticeImageMedia")) {
				httpStatus = HttpStatus.OK;
				return praticeImageRepository.findAll();
			} else if (operationType.equals("praticeDocumentMedia")) {
				httpStatus = HttpStatus.OK;
				return praticeDocumentRepository.findAll();
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

			if (operation.equals(Constants.ADD)) {
				addcourses(courseListDto);
			} else if (operation.equals(Constants.UPDATE)) {
				updatecourses(courseListDto);
			} else if (operation.equals(Constants.DELETE)) {
				deletecourses(courseListDto);
			} else {
				message = Constants.OPERATION_ERROR;
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
			message = "course is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	// delete courses

	private void deletecourses(CoursesListRequest courseListDto) {
		CourseListModel listNew = coursesListRepository.getcoursesListById(courseListDto.getCoursesId());
		if (listNew != null) {
			coursesListRepository.deleteById(listNew.getCoursesId());
			message = "courses  is  deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "courses Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	// update courses /////
	private void updatecourses(CoursesListRequest courseListDto) {
		CourseListModel listNew = coursesListRepository.getcoursesListById(courseListDto.getCoursesId());
		if (listNew != null) {
			CourseListModel check = coursesListRepository.getcoursesListBycoursesName(courseListDto.getCoursesName());
			CourseListModel check1 = coursesListRepository.getcoursesListBydescription(courseListDto.getDescription());
			CourseListModel check2 = coursesListRepository.getcoursesListBystartdate(courseListDto.getStartDate());
			CourseListModel check3 = coursesListRepository.getcoursesListByenddate(courseListDto.getEndDate());
			CourseListModel check4 = coursesListRepository
					.getcoursesListByclouserdate(courseListDto.getApplicationClouserDate());

			if (check == null || check1 == null || check2 == null || check3 == null || check4 == null) {
				listNew.setCoursesName(courseListDto.getCoursesName());
				listNew.setCategorieId(courseListDto.getCategorieId());
				listNew.setDescription(courseListDto.getDescription());
				listNew.setStartDate(courseListDto.getStartDate());
				listNew.setEndDate(courseListDto.getEndDate());
				listNew.setApplicationClouserDate(courseListDto.getApplicationClouserDate());
				coursesListRepository.save(listNew);
				message = "courses updated  sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Updated quote is already exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

		} else {
			message = "quote Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	// Manage Exam ////

	public Object mangeExams(String operation, OnlineExamReqest onlineExamDto) {
		this.httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(Constants.ADD)) {
				addOnlineExams(onlineExamDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateOnlineExams(onlineExamDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteOnlineExams(onlineExamDto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
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
			message = "exam sheet is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateOnlineExams(OnlineExamReqest onlineexamDto) {
		OnlineExamsModel examSheetDb = onlineExamRepository.getexamdetailsById(onlineexamDto.getExamsId());
		if (examSheetDb != null) {
			examSheetDb.setCourseId(onlineexamDto.getCourseId());
			examSheetDb.setTestId(onlineexamDto.getTestId());
			examSheetDb.setNameofTest(onlineexamDto.getNameofTest());
			examSheetDb.setLevelId(onlineexamDto.getLevelId());
			examSheetDb.setFileUpload(onlineexamDto.getFileUpload());
			examSheetDb.setDescription(onlineexamDto.getDescription());
			onlineExamRepository.save(examSheetDb);
			message = "exam sheet is updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "exam sheet is " + Constants.DOES_NOT_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteOnlineExams(OnlineExamReqest onlineexamDto) {
		OnlineExamsModel examNew = onlineExamRepository.getexamdetailsById(onlineexamDto.getExamsId());
		if (examNew != null) {
			onlineExamRepository.deleteById(onlineexamDto.getExamsId());
			message = "exam sheet is deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "exam sheet is " + Constants.DOES_NOT_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	public Object manageTask(String operation, TaskRequest taskDto) {
		this.httpStatus = HttpStatus.OK;
		try {
			if (operation.equals(Constants.ADD)) {
				addTask(taskDto);
			} else if (operation.equals(Constants.UPDATE)) {
				updateTask(taskDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteTask(taskDto);
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

	private void addTask(TaskRequest taskDto) {
		TaskModel tasknew = taskRepository.getTaskById(taskDto.getTaskId());
		if (tasknew == null) {
			TaskModel tasklist = new TaskModel();
			tasklist.setCoursesId(taskDto.getCoursesId());
			tasklist.setDateOfAssigement(taskDto.getDateOfAssigement());
			tasklist.setTaskName(taskDto.getTaskName());
			tasklist.setDescription(taskDto.getDescription());
			tasklist.setMediafile(taskDto.getMediafile());
			tasklist.setDueDate(taskDto.getDueDate());
			tasklist.setIsActive(Constants.YES);
			taskRepository.save(tasklist);
			message = "new task added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Task " + Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	private void updateTask(TaskRequest taskDto) {
		TaskModel taskDb = taskRepository.getTaskById(taskDto.getTaskId());
		if (taskDb != null) {
			taskDb.setCoursesId(taskDto.getCoursesId());
			taskDb.setDateOfAssigement(taskDto.getDateOfAssigement());
			taskDb.setTaskName(taskDto.getTaskName());
			taskDb.setDescription(taskDto.getDescription());
			taskDb.setMediafile(taskDto.getMediafile());
			taskDb.setDueDate(taskDto.getDueDate());
			taskDb.setIsActive(Constants.YES);
			taskRepository.save(taskDb);

			message = "task is updated sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "task Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void deleteTask(TaskRequest taskDto) {
		TaskModel deleteTask = taskRepository.getTaskById(taskDto.getTaskId());
		if (deleteTask != null) {
			taskRepository.deleteById(deleteTask.getTaskId());
			message = "task is  deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "task Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

//	TESTIMONAL////
	public Object manageTestimonal(String operation, TestimoalRequest testimonalDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals(Constants.ADD)) {
				addTestimonal(testimonalDto);
			} else if (operation.equals(Constants.UPDATE)) {
				updateTestimonal(testimonalDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteTestimonal(testimonalDto);
			} else if (operation.equals("active")) {
				activeTestimonal(testimonalDto);
			} else if (operation.equals("deactive")) {
				deactiveTestimonal(testimonalDto);
			} else {
				message = Constants.OPERATION_ERROR;
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

	// ADD testimonal///
	private void addTestimonal(TestimoalRequest testimonalDto) {
		TestimonalsModel testimonalnew = testimonalRepository.getTestmonialsById(testimonalDto.getTestimonalId());
		if (testimonalnew == null) {
			TestimonalsModel testlist = new TestimonalsModel();

			testlist.setContent(testimonalDto.getContent());
			testlist.setGivenByName(testimonalDto.getGivenByName());
			testlist.setVideoLink(testimonalDto.getVideoLink());
			testlist.setDescription(testimonalDto.getDescription());
			testlist.setCreatedDate(generalUtils.getCurrentDate());
			testlist.setIsActive("Y");

			testimonalRepository.save(testlist);
			message = "new testimonial is added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Testimoal " + Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	/// update////

	private void updateTestimonal(TestimoalRequest testimonalDto) {
		TestimonalsModel testimonalnew = testimonalRepository.getTestmonialsById(testimonalDto.getTestimonalId());
		if (testimonalnew != null) {
			testimonalnew.setContent(testimonalDto.getContent());
			testimonalnew.setGivenByName(testimonalDto.getGivenByName());
			testimonalnew.setVideoLink(testimonalDto.getVideoLink());
			testimonalnew.setDescription(testimonalDto.getDescription());
			testimonalnew.setUpdateDate(generalUtils.getCurrentDate());
			testimonalRepository.save(testimonalnew);

			message = "Testimonial is updated successfully";
			LOG.info(message);
			response = new Response(message, HttpStatus.OK.value(), null);
		}

		else {
			message = "testimonial is already exists";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	// Delete//

	private void deleteTestimonal(TestimoalRequest testimonalDto) {
		TestimonalsModel testimonalnew = testimonalRepository.getTestmonialsById(testimonalDto.getTestimonalId());
		if (testimonalnew != null) {
			testimonalRepository.deleteById(testimonalnew.getTestimonalId());
			message = "Testimonal deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Testimonal Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	// active the testimonial//

	private void activeTestimonal(TestimoalRequest testimonalDto) {
		TestimonalsModel testimonal = testimonalRepository.getTestmonialsById(testimonalDto.getTestimonalId());
		if (testimonal != null) {
			testimonal.setIsActive("Y");
			testimonalRepository.save(testimonal);
			message = "Testimonal is activated successfully";
			LOG.info(message);
			response = new Response(message, HttpStatus.OK.value(), null);
		} else {
			message = "Testimonal does not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	// deactive the testimonial////

	private void deactiveTestimonal(TestimoalRequest testimonalDto) {
		TestimonalsModel testimonal = testimonalRepository.getTestmonialsById(testimonalDto.getTestimonalId());
		if (testimonal != null) {
			testimonal.setIsActive("N");
			testimonalRepository.save(testimonal);
			message = "Testimonal is deactivated successfully";
			LOG.info(message);
			response = new Response(message, HttpStatus.OK.value(), null);
		} else {
			message = "Testimonal does not exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	/// Add Material Categorys/////

	public Object managematerialCategory(String operation, MaterialCategoryRequest materialcategoryDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals(Constants.ADD)) {
				addcategorymaterial(materialcategoryDto);
			} else {
				message = Constants.OPERATION_ERROR;
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
			message = "Category Material " + Constants.ALREADY_EXIST;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}

	}

	/// ADD MATERIAL COURSES///////
	public Object managemateials(String operation, AddCoursemateialRequest materialDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals(Constants.ADD)) {
				addmaterials(materialDto);
			} else {
				message = Constants.OPERATION_ERROR;
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
		AddCoursesMaterialModel materialnew = addMaterialRepository.getMaterialById(materialDto.getCourseMaterialId());
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

	// pratice-Media

	public Object managemedia(String operation, PraticeMediaRequest mediaDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals(Constants.ADD)) {
				addMedia(mediaDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateMedia(mediaDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteMedia(mediaDto.getMediaId());
			} else {
				message = Constants.OPERATION_ERROR;
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

	private void addMedia(PraticeMediaRequest mediaDto) {
		PraticeMediaModel mediaNew = praticeMediaRepository.getmediaById(mediaDto.getMediaId());
		if (mediaNew == null) {
			PraticeMediaModel mediaList = new PraticeMediaModel();
			mediaList.setCourseId(mediaDto.getCourseId());
			mediaList.setPraticeDate(mediaDto.getPraticeDate());
			mediaList.setPraticeTime(mediaDto.getPraticeTime());
			mediaList.setVideoLink(mediaDto.getVideoLink());
			mediaList.setVideoTitle(mediaDto.getVideoTitle());
			mediaList.setDurationVideo(mediaDto.getDurationVideo());
			mediaList.setMetaKeyword(mediaDto.getMetaKeyword());
			mediaList.setFileUpload(mediaDto.getFileUpload());
			mediaList.setDescription(mediaDto.getDescription());
			mediaList.setInstruction(mediaDto.getInstruction());
			mediaList.setCreatedDate(generalUtils.getCurrentDate());
			mediaList.setIsActive("Y");
			praticeMediaRepository.save(mediaList);
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

	private void updateMedia(PraticeMediaRequest mediaDto) {
		PraticeMediaModel media = praticeMediaRepository.getmediaById(mediaDto.getMediaId());
		if (media == null) {
			message = "media with ID " + mediaDto.getMediaId() + " not found";
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(message, httpStatus.value(), message);
		} else {
			media.setCourseId(mediaDto.getCourseId());
			media.setPraticeDate(mediaDto.getPraticeDate());
			media.setPraticeTime(mediaDto.getPraticeTime());
			media.setVideoLink(mediaDto.getVideoLink());
			media.setVideoTitle(mediaDto.getVideoTitle());
			media.setDurationVideo(mediaDto.getDurationVideo());
			media.setMetaKeyword(mediaDto.getMetaKeyword());
			media.setFileUpload(mediaDto.getFileUpload());
			media.setDescription(mediaDto.getDescription());
			media.setInstruction(mediaDto.getInstruction());
			media.setUpdateDate(generalUtils.getCurrentDate());
			media.setIsActive("Y");
			praticeMediaRepository.save(media);
			message = "media updated successfully";
			httpStatus = HttpStatus.OK;
			response = new Response(message, httpStatus.value(), null);
		}
	}

	private void deleteMedia(int mediaId) {
		PraticeMediaModel media = praticeMediaRepository.getmediaById(mediaId);
		if (media == null) {
			message = "media with ID " + mediaId + " not found";
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(message, httpStatus.value(), message);
		} else {
			praticeMediaRepository.delete(media);
			message = "media deleted successfully";
			httpStatus = HttpStatus.OK;
			response = new Response(message, httpStatus.value(), null);
		}
	}

	public Object manageimage(String operation, PraticeImageRequest imageDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals(Constants.ADD)) {
				addImage(imageDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateImage(imageDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteImage(imageDto.getImageId());
			} else {
				message = Constants.OPERATION_ERROR;
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

	private void addImage(PraticeImageRequest imageDto) {
		PraticeImageModel imageNew = praticeImageRepository.getimageById(imageDto.getImageId());
		if (imageNew == null) {
			PraticeImageModel imageList = new PraticeImageModel();
			imageList.setCourseId(imageDto.getCourseId());
			imageList.setImageTitle(imageDto.getImageTitle());
			imageList.setUploadFile(imageDto.getUploadFile());
			imageList.setDescription(imageDto.getDescription());
			imageList.setCreatedDate(generalUtils.getCurrentDate());
			imageList.setIsActive("Y");
			praticeImageRepository.save(imageList);
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

	private void updateImage(PraticeImageRequest imageDto) {
		PraticeImageModel image = praticeImageRepository.getimageById(imageDto.getImageId());
		if (image == null) {
			message = "No image found with the given ID.";
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(message, httpStatus.value(), message);
		} else {
			image.setCourseId(imageDto.getCourseId());
			image.setImageTitle(imageDto.getImageTitle());
			image.setUploadFile(imageDto.getUploadFile());
			image.setDescription(imageDto.getDescription());
			image.setUpdateDate(generalUtils.getCurrentDate());
			image.setIsActive("Y");
			praticeImageRepository.save(image);
			message = "Image updated successfully.";
			response = new Response(message, httpStatus.value(), null);
		}
	}

	private void deleteImage(int imageId) {
		PraticeImageModel image = praticeImageRepository.getimageById(imageId);
		if (image == null) {
			message = "No image found with the given ID.";
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(message, httpStatus.value(), message);
		} else {
			praticeImageRepository.delete(image);
			message = "Image deleted successfully.";
			response = new Response(message, httpStatus.value(), null);
		}
	}

	public Object manageDocument(String operation, PraticeDocumentRequest documentDto) {

		this.httpStatus = HttpStatus.OK;
		try {

			if (operation.equals(Constants.ADD)) {
				addDocument(documentDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateDocument(documentDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteDocument(documentDto.getDocumentId());
			} else {
				message = Constants.OPERATION_ERROR;
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

	private void addDocument(PraticeDocumentRequest documentDto) {
		PraticeDocumentModel documentNew = praticeDocumentRepository.getdocumentById(documentDto.getDocumentId());
		if (documentNew == null) {
			PraticeDocumentModel documentList = new PraticeDocumentModel();
			documentList.setCourseId(documentDto.getCourseId());
			documentList.setDocumentTitle(documentDto.getDocumentTitle());
			documentList.setUploadFile(documentDto.getUploadFile());
			documentList.setDescription(documentDto.getDescription());
			documentList.setCreatedDate(generalUtils.getCurrentDate());
			documentList.setIsActive("Y");
			praticeDocumentRepository.save(documentList);
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

	private void updateDocument(PraticeDocumentRequest documentDto) {
		PraticeDocumentModel document = praticeDocumentRepository.getdocumentById(documentDto.getDocumentId());
		if (document == null) {
			message = "No document found with the given ID.";
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(message, httpStatus.value(), message);
		} else {
			document.setCourseId(documentDto.getCourseId());
			document.setDocumentTitle(documentDto.getDocumentTitle());
			document.setUploadFile(documentDto.getUploadFile());
			document.setDescription(documentDto.getDescription());
			document.setUpdateDate(generalUtils.getCurrentDate());
			document.setIsActive("Y");
			praticeDocumentRepository.save(document);
			message = "Document updated successfully.";
			response = new Response(message, httpStatus.value(), null);
		}
	}

	private void deleteDocument(int documentId) {
		PraticeDocumentModel document = praticeDocumentRepository.getdocumentById(documentId);
		if (document == null) {
			message = "No document found with the given ID.";
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(message, httpStatus.value(), message);
		} else {
			praticeDocumentRepository.delete(document);
			message = "Document deleted successfully.";
			response = new Response(message, httpStatus.value(), null);
		}
	}

}
