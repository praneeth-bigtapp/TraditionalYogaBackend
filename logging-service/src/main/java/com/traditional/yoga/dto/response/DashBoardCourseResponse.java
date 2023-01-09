package com.traditional.yoga.dto.response;

import com.traditional.yoga.dto.Response;

public class DashBoardCourseResponse {

	private int enrolledUsers;
	private int activeUsers;
	private int droppedUsers;
	private int mentors;
	private int cheifMentors;
	private Response response;

	public int getEnrolledUsers() {
		return enrolledUsers;
	}

	public void setEnrolledUsers(int enrolledUsers) {
		this.enrolledUsers = enrolledUsers;
	}

	public int getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(int activeUsers) {
		this.activeUsers = activeUsers;
	}

	public int getDroppedUsers() {
		return droppedUsers;
	}

	public void setDroppedUsers(int droppedUsers) {
		this.droppedUsers = droppedUsers;
	}

	public int getMentors() {
		return mentors;
	}

	public void setMentors(int mentors) {
		this.mentors = mentors;
	}

	public int getCheifMentors() {
		return cheifMentors;
	}

	public void setCheifMentors(int cheifMentors) {
		this.cheifMentors = cheifMentors;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}
