package com.Beautosite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeveloperAndSkills {
 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
 private String developer;
 private String skills;
 private String  location;
 private String availibility;
public int getId() {
	return id;
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
public void setId(int id) {
	this.id = id;
}
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
@Override
public String toString() {
	return "DeveloperAndSkills [id=" + id + ", developer=" + developer + ", skills=" + skills + ", location=" + location
			+ ", availibility=" + availibility + "]";
}
 
}
