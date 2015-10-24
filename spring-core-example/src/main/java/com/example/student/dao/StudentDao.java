package com.example.student.dao;

import java.util.List;


import com.example.student.model.Student;

public interface StudentDao{
	List<Student> getList();
	Student findStudent(Long id);
	void create(Student student);
	void delete(Long id);
}
