package com.traditional.yoga.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class GeneralUtils {

	/**
	 * Get Current Date Time
	 * 
	 * @return String
	 */
	public String getCurrentDate() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return dtf.format(now);
	}
	
	/**
	 * For Encoding the String
	 * 
	 * @param strToEncode
	 * @return String
	 */
	public String enCrypt(String strToEncode) {
		return Base64.getEncoder().encodeToString(strToEncode.getBytes());
	}


	/**
	 * For Decoding the encrypted String
	 * 
	 * @param strToDecode
	 * @return String
	 */
	public String deCrypt(String strToDecode) {
		byte[] decodedBytes = Base64.getDecoder().decode(strToDecode);
		return new String(decodedBytes);
	}


}
