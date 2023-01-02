package com.traditional.yoga.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator {

	private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBERS = "0123456789";
	private static final String SYMBOLS = "@$!%*?&";

	private static final int PASSWORD_LENGTH = 12;

	public String generatePassword() {
		StringBuilder password = new StringBuilder();
		Random random = new Random();

		// Include at least one lowercase character
		password.append(LOWERCASE_CHARS.charAt(random.nextInt(LOWERCASE_CHARS.length())));

		// Include at least one uppercase character
		password.append(UPPERCASE_CHARS.charAt(random.nextInt(UPPERCASE_CHARS.length())));

		// Include at least one number
		password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

		// Include at least one symbol
		password.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));

		// Fill the remaining characters with random characters
		for (int i = password.length(); i < PASSWORD_LENGTH; i++) {
			String charCategory = getRandomCharCategory(random);
			password.append(charCategory.charAt(random.nextInt(charCategory.length())));
		}

		return shuffleString(password.toString(), random);
	}

	private String getRandomCharCategory(Random random) {
		int rand = random.nextInt(4);
		if (rand == 0) {
			return LOWERCASE_CHARS;
		} else if (rand == 1) {
			return UPPERCASE_CHARS;
		} else if (rand == 2) {
			return NUMBERS;
		} else {
			return SYMBOLS;
		}
	}

	private String shuffleString(String string, Random random) {
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int randIndex = random.nextInt(chars.length);
			char temp = chars[i];
			chars[i] = chars[randIndex];
			chars[randIndex] = temp;
		}
		return new String(chars);
	}
}
