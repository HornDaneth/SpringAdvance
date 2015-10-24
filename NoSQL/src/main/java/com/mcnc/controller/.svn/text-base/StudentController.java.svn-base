package com.mcnc.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.dto.StudentDTO;
import com.mcnc.service.api.IStudentService;

@RestController( "/api/students" )
public class StudentController {
	
	@Autowired
		private IStudentService studentService;

	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List< StudentDTO > getStudents(){
		return studentService.getStudents();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody boolean addStudent(){
		String id = UUID.randomUUID().toString();
		String name = UUID.randomUUID().toString() + "Name";
		StudentDTO stud = new StudentDTO( id, name );
		return studentService.insert( stud );
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody StudentDTO addStudentById( @PathVariable String id ){
		return studentService.getStudentById( id );
	}
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean removeStudentById( @PathVariable String id ){
		studentService.removeStudentById( id );
		return true;
	}
}
