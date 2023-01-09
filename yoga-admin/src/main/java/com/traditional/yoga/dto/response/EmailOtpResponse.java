package com.traditional.yoga.dto.response;

import com.traditional.yoga.dto.Response;

public class EmailOtpResponse {

	private String otp;
	private Response response;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}
