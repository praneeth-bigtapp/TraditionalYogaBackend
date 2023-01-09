package com.traditional.yoga.dto.response;

import com.traditional.yoga.dto.Response;

public class DashBoardOverallResponse {

	private int regCount;
	private int donationAmount;
	private int courseCount;
	private int subscribersCount;
	private Response response;

	public int getRegCount() {
		return regCount;
	}

	public void setRegCount(int regCount) {
		this.regCount = regCount;
	}

	public int getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(int donationAmount) {
		this.donationAmount = donationAmount;
	}

	public int getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}

	public int getSubscribersCount() {
		return subscribersCount;
	}

	public void setSubscribersCount(int subscribersCount) {
		this.subscribersCount = subscribersCount;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}
