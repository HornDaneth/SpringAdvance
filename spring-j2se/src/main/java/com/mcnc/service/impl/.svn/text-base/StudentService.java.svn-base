package com.mcnc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcnc.dao.StudentDAO;
import com.mcnc.dto.Student;
import com.mcnc.service.api.IStudentService;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	public boolean addStudent(Student stud) {
		return studentDAO.addStudent(stud);
	}
	
	public List<Student> getStudentList() {
		return studentDAO.getStudentList();
	}

	public Student getStudentById(int studentId){
		return studentDAO.getStudentById(studentId);
	}
	
	
	public boolean updateStudent(Student stud) {
		return studentDAO.updateStudent(stud);
	}
	
	public boolean deleteStudentById(int studentId) {
		return studentDAO.deleteStudentById(studentId);
	}
}
