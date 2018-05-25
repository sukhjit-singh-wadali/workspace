package com.walnut.utils;

import java.util.regex.Pattern;


public class Validation {

	public boolean isValidateName(String name) {
		String regex = "^[a-zA-Z0-9]+$";
		Pattern patternName = Pattern.compile(regex);
		if (patternName.matcher(name).matches() && name.length() > 5) {
			return true;
		} else {

			return false;
		}
	}

	public boolean isValidateEmail(String email) {
		// String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
		Pattern patternEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (patternEmail.matcher(email).find()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidatePass(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";
		return password.matches(pattern);
	}

}