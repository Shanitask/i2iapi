package com.Beautosite.dto;




public class HiringResponse {
	private String code;
	private String message;
	private String referenceKey;
	private String email;
	public static final String PDF="ONLY_PDF_ACCEPTED";
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReferenceKey() {
		return referenceKey;
	}
	public void setReferenceKey(String referenceKey) {
		this.referenceKey = referenceKey;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static String getPdf() {
		return PDF;
	}
	

}
