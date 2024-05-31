package com.Beautosite.dto;

public class DeveloperAndSkillsDto {
	private String developer;
	 private String skills;
	 private String  location;
	 private String availibility;
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAvailibility() {
		return availibility;
	}
	public void setAvailibility(String availibility) {
		this.availibility = availibility;
	}
	@Override
	public String toString() {
		return "DeveloperAndSkillsDto [developer=" + developer + ", skills=" + skills + "]";
	}
	
}
