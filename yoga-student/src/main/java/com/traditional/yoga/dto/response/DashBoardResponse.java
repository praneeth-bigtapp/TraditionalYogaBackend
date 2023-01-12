package com.traditional.yoga.dto.response;

import com.traditional.yoga.dto.ChiefMentorDetails;
import com.traditional.yoga.dto.GratitudeMessages;
import com.traditional.yoga.dto.MentorDetails;
import com.traditional.yoga.dto.Notifications;
import com.traditional.yoga.dto.PerformanceReport;

public class DashBoardResponse {

	private MentorDetails mentor;
	private ChiefMentorDetails chiefMentorDetails;
	private int gratitudeSubmitDate;
	private PerformanceReport performanceReport;
	private GratitudeMessages gratitudeMessages;
	private Notifications notifications;

	public MentorDetails getMentor() {
		return mentor;
	}

	public void setMentor(MentorDetails mentor) {
		this.mentor = mentor;
	}

	public ChiefMentorDetails getChiefMentorDetails() {
		return chiefMentorDetails;
	}

	public void setChiefMentorDetails(ChiefMentorDetails chiefMentorDetails) {
		this.chiefMentorDetails = chiefMentorDetails;
	}

	public int getGratitudeSubmitDate() {
		return gratitudeSubmitDate;
	}

	public void setGratitudeSubmitDate(int gratitudeSubmitDate) {
		this.gratitudeSubmitDate = gratitudeSubmitDate;
	}

	public PerformanceReport getPerformanceReport() {
		return performanceReport;
	}

	public void setPerformanceReport(PerformanceReport performanceReport) {
		this.performanceReport = performanceReport;
	}

	public GratitudeMessages getGratitudeMessages() {
		return gratitudeMessages;
	}

	public void setGratitudeMessages(GratitudeMessages gratitudeMessages) {
		this.gratitudeMessages = gratitudeMessages;
	}

	public Notifications getNotifications() {
		return notifications;
	}

	public void setNotifications(Notifications notifications) {
		this.notifications = notifications;
	}

}
