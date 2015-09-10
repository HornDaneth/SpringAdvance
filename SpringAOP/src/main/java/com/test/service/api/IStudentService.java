package com.test.service.api;

import java.util.List;

import com.test.dto.Student;

public interface IStudentService {
	public List<Student> getStudentById(Student st);
}
