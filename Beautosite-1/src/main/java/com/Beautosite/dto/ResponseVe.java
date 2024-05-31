package com.Beautosite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class ResponseVe {
	String responseCode;
	String responsemessage;
	public static final String PDF="ONLY_PDF_ACCEPTED";
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponsemessage() {
		return responsemessage;
	}
	public void setResponsemessage(String responsemessage) {
		this.responsemessage = responsemessage;
	}
	

	

}
