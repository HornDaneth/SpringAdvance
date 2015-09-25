package com.mcnc.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.mybatis.dto.StudentDTO;
import com.mcnc.mybatis.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired @Qualifier("studentServiceImpl")
	StudentService studentService;
	
	@RequestMapping
	public List<StudentDTO> getStudents() {
		return studentService.getStudents();
	}
	
	@RequestMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
}
