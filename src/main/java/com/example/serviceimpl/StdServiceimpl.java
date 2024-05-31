package com.example.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.model.Student;
import com.example.repository.StdRepo;
import com.example.service.StdService;


@Service
public class StdServiceimpl implements StdService {

private StdRepo  studentRepository;

public StdServiceimpl(StdRepo studentRepository) {
	super();
	this.studentRepository = studentRepository;
}
@Override
public List<Student> getAllStudents() {
	return studentRepository.findAll();
}
@Override
public Student saveStudent(Student student) {
	return studentRepository.save(student);
}
@Override
public Student getStudentById(int id) {
	return studentRepository.getById(id);
}
@Override
public Student updateStudent(Student student) {
	return studentRepository.save(student);
}
@Override
public void deleteStudentById(int id) {
	studentRepository.deleteById(id);
}

}
