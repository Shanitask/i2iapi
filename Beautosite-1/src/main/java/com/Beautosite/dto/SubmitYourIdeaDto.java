package com.Beautosite.dto;

import org.springframework.web.multipart.MultipartFile;

public class SubmitYourIdeaDto {
	
	public String firstName;
	public String country;
	public String emailAddress;
	public String contactNumber;
	public String alternateContactNumber;
	public String domain;
	public String ideaStage;
	public String describeYourIdea;
	public MultipartFile attachmentUpload;
	public String organisationName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}
	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getIdeaStage() {
		return ideaStage;
	}
	public void setIdeaStage(String ideaStage) {
		this.ideaStage = ideaStage;
	}
	public String getDescribeYourIdea() {
		return describeYourIdea;
	}
	public void setDescribeYourIdea(String describeYourIdea) {
		this.describeYourIdea = describeYourIdea;
	}
	public MultipartFile getAttachmentUpload() {
		return attachmentUpload;
	}
	public void setAttachmentUpload(MultipartFile attachmentUpload) {
		this.attachmentUpload = attachmentUpload;
	}
	public String getOrganisationName() {
		return organisationName;
	}
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	@Override
	public String toString() {
		return "SubmitYourIdeaDto [firstName=" + firstName + ", country=" + country + ", emailAddress=" + emailAddress
				+ ", contactNumber=" + contactNumber + ", alternateContactNumber=" + alternateContactNumber
				+ ", domain=" + domain + ", ideaStage=" + ideaStage + ", describeYourIdea=" + describeYourIdea
				+ ", attachmentUpload=" + attachmentUpload + ", organisationName=" + organisationName + "]";
	}
	}
