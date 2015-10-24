package com.example.student.service;

import java.util.List;

import com.example.student.model.Student;

public interface StudentService {
	
	List<Student> getList();
	Student findStudent(Long id);
	void create(Student student);
	void delete(Long id);
}
