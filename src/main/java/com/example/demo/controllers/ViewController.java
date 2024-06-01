package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;

@Controller
public class ViewController {
	
	private final StudentService studentService;
	
		public ViewController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute(new Student());
		
		
		return "index";
	}
	
	@PostMapping("/")
	public String addStudent(@ModelAttribute Student student, Model model) {
		Student res = studentService.addStudent(student);
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		return "index";
	}
	
}
