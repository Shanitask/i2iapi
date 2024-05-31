package com.Beautosite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class SubmitYourIdea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String id;
	public String firstName;
	public String country;
	public String emailAddress;
	public String contactNumber;
	public String alternateContactNumber;
	public String domain;
	public String ideaStage;
	public String describeYourIdea;
	public String attachmentName;
	public String organisationName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getOrganisationName() {
		return organisationName;
	}
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	@Override
	public String toString() {
		return "SubmitYourIdea [id=" + id + ", firstName=" + firstName + ", country=" + country + ", emailAddress="
				+ emailAddress + ", contactNumber=" + contactNumber + ", alternateContactNumber="
				+ alternateContactNumber + ", domain=" + domain + ", ideaStage=" + ideaStage + ", describeYourIdea="
				+ describeYourIdea + ", attachmentName=" + attachmentName + ", organisationName=" + organisationName
				+ "]";
	}
	}
