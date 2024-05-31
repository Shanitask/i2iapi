package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.model.Student;


@Service
public interface StdService {
    List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(int id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(int id);

	//String storeFile(MultipartFile image);



	
}



