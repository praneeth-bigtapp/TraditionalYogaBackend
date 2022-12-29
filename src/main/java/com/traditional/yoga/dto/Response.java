package com.traditional.yoga.dto;

public class Response {

	private String message;
	private int statusCode;
	private String errorMessage;

	public Response() {
		super();
	}

	public Response(String message, int statusCode, String i ) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.errorMessage = i;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
