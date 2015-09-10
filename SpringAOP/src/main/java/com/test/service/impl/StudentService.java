package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.test.dao.StudentDAO;
import com.test.dto.Student;
import com.test.service.api.IStudentService;

public class StudentService implements IStudentService{
	
	@Autowired StudentDAO studentDao;
	@Autowired ApplicationContext applicationContext;
	
	
	public List<Student> getStudentById( Student st ) {
		return studentDao.getStudentById(st);
	}
	
}
