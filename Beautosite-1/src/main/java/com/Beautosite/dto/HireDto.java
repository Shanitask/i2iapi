package com.Beautosite.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HireDto {
	
	
	private int id;
	private String referanceKey;
	private String firstName;
	private String lastName;
	private String country;
	private String emailId;
	private String  contactNumber;
	private String alterNateContactNumber;
	private String address;
	private String workLink;
	private MultipartFile file;
	
}