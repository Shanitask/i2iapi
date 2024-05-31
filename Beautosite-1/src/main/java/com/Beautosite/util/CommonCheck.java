package com.Beautosite.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonCheck {
	
	/*
	 * public boolean validatePhoneNumber(String str) { boolean result = false;
	 * String s = str.trim(); if (s == null || s.isEmpty() || s.length() <=10) {
	 * result = true; } return result; }
	 */
	public boolean validatePhoneNumber(String str) {
		boolean validateResult = false;
		String s = str.trim();
		if (s == null || s.isEmpty() || s.length() < 10 || s.length() > 12) {
			validateResult = true;
		} else if (s.length() == 11) {
			char c = s.charAt(0);

			if (c != '0') {
				validateResult = true;
			}
		} else {

			Pattern p = Pattern.compile("[^0-9]");
			Matcher m = p.matcher(s);
			boolean b = m.find();
			if (b == true) {
				validateResult = true;
			}
		}
		return validateResult;
	}
	public boolean validateStringValues(String reqParamValue) {
		boolean result = false;

		if (reqParamValue == null || reqParamValue.equals("") || reqParamValue.equals(" "))
			result = true;

		return result;
	}
}