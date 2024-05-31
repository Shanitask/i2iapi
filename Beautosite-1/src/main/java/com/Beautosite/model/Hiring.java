package com.Beautosite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Hiring
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String referanceKey;
	private String firstName;
	private String lastName;
	private String country;
	private String emailId;
	private String contactNumber;
	private String alterNateContactNumber;
	private String address;
	private String workLink;
	private String fileName;
	
	}