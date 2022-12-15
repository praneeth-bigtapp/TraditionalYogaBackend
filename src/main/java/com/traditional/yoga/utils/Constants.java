package com.traditional.yoga.utils;

public class Constants {
	
	private Constants() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}
	
//	Operations
	public static final String ADD = "add";
	public static final String SAVE = "save";
	public static  final String UPDATE="update";
	public static final String ACTIVE = "active";
	public static final String DELETE = "delete";
	
//	General Messages
	public static final String USER = "User";
	public static final String ROLE = "Role";
	public static final String MENU = "Menu";
	public static final String OPERATION = "Operation";
	public static final String ALREADY_EXIST = "Already exist";
	public static final String DOES_NOT_EXIST = "Doesn't exist";
	public static final String EXCEPTION = "Exception in";
	public static final String ALERT = "alert";
	
	
	
//	Error Message
	public static final String OPERATION_ERROR = OPERATION + " " + DOES_NOT_EXIST;
	public static final String USER_ERROR = USER + " " + DOES_NOT_EXIST;
	public static final String USER_EXIST = USER + " " + ALREADY_EXIST;
	public static final String ROLE_ERROR = ROLE + " " + DOES_NOT_EXIST;
	public static final String ROLE_EXIST = ROLE + " " + ALREADY_EXIST;
	public static final String MENU_ERROR = MENU + " " + DOES_NOT_EXIST;
	public static final String MENU_EXIST = MENU + " " + ALREADY_EXIST;
	
//	Website Management
	public static final String BANNER_EXCEPTION = EXCEPTION + " banner creation";
	public static final String ALERT_EXCEPTION = EXCEPTION + " alert creation";
	public static final String DOES_NOT_EXISTS=ALERT+""+DOES_NOT_EXIST;
	
}
