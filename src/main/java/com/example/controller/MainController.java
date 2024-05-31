package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StdService;
@RestController
public class MainController {
	@Autowired
	private StdService studentService;

	
	@PostMapping("/students")
	public String saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
	        
			return "savedataSuccessfully";
	        
	
	
}
}