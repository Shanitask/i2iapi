package com.Beautosite.dto;

import java.util.Date;

public class BeautoSiteDto {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;
	private String briefForTheMeeting;
	private String budget;
	private String selectOffice;
	private String date;
	private String time;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	public String getBriefForTheMeeting() {
		return briefForTheMeeting;
	}



	public void setBriefForTheMeeting(String briefForTheMeeting) {
		this.briefForTheMeeting = briefForTheMeeting;
	}



	public String getBudget() {
		return budget;
	}



	public void setBudget(String budget) {
		this.budget = budget;
	}



	public String getSelectOffice() {
		return selectOffice;
	}



	public void setSelectOffice(String selectOffice) {
		this.selectOffice = selectOffice;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	@Override
	public String toString() {
		return "BeautoSiteDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", briefForTheMeeting=" + briefForTheMeeting + ", budget="
				+ budget + ", selectOffice=" + selectOffice + ", date=" + date + ", time=" + time + "]";
	}



	
}
