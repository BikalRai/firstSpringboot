package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {
	
	private final StudentService studentService;
	
	
	
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}



	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		
		Student response = studentService.addStudent(student);
		return response;
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

}
