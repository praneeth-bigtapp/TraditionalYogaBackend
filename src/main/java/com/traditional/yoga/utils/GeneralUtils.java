package com.traditional.yoga.utils;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class GeneralUtils {

	public String getCurrentDate() {
		LocalDate localDate = LocalDate.now();
		return localDate.toString();
	}
}
