package com.mcnc.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.dto.StudentDTO;
import com.mcnc.service.api.IStudentService;

@RestController("/api/students")
public class StudentController {
	Logger logger =  LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping
	public List<StudentDTO> getStudents(){
		return studentService.getStudents();
	}
	

}