package com.traditional.yoga.utils;

public class StudentConstants {

	private StudentConstants() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}

//	Operations
	public static final String ADD = "add";
	public static final String SAVE = "save";
	public static final String UPDATE = "update";
	public static final String ACTIVE = "active";
	public static final String DEACTIVE = "deactive";
	public static final String DELETE = "delete";
	public static final String VIEW = "view";
	public static final String CERTIFICATION = "certification";
	

//	General Messages
	public static final String USER = "User";
	public static final String ROLE = "Role";
	public static final String MENU = "Menu";
	public static final String OPERATION = "Operation";
	public static final String TYPE = "Type";
	public static final String ALREADY_EXIST = "Already exist";
	public static final String DOES_NOT_EXIST = "Doesn't exist";
	public static final String EXCEPTION = "Exception in";
	public static final String ALERT = "alert";
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String FALSE = "false";

//	Error Message
	public static final String OPERATION_ERROR = OPERATION + " " + DOES_NOT_EXIST;
	public static final String UNKNOWN_OPERATION = "Unknown " + OPERATION;
	public static final String TYPE_ERROR = TYPE + " " + DOES_NOT_EXIST;
	public static final String USER_ERROR = USER + " " + DOES_NOT_EXIST;
	public static final String USER_EXIST = USER + " " + ALREADY_EXIST;
	public static final String ROLE_ERROR = ROLE + " " + DOES_NOT_EXIST;
	public static final String ROLE_EXIST = ROLE + " " + ALREADY_EXIST;
	public static final String MENU_ERROR = MENU + " " + DOES_NOT_EXIST;
	public static final String MENU_EXIST = MENU + " " + ALREADY_EXIST;

//	Email OTP Verification
	public static final int OTP_LENGTH = 6;
	public static final String OTP_SUBJECT = "Traditional Yoga Email Verification";

//	ADD course Material
	public static final String EXCEPTION_MATERIALS = "Exception in adding materials";
	public static final String MATERIAL_ADD = "material to courses is added sucessfully";
	public static final String MATERIAL_EXEPTION = "material to courses is added sucessfully";
	public static final String MATERIAL_EXISTS = "material  already exists";
	
	
	
}
