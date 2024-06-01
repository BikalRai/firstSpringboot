package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;

@RestController
public class StudentRestController {
	
	private final StudentService studentService;
	
	
	
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}



	@PostMapping("/api/v1/students")
	public Student addStudent(@RequestBody Student student) {
		
		Student response = studentService.addStudent(student);
		return response;
	}

}
