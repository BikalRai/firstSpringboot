package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepo;
	
	
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public List<Student> getStudents () {
		return studentRepo.findAll();
	}
	
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	
	
	
	
	
	

}
