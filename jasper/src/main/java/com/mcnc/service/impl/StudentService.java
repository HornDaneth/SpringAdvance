package com.mcnc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mcnc.dto.Student;
import com.mcnc.service.api.IStudentService;

@Service
public class StudentService implements IStudentService {
	public List< Student > getStudents(){
		List< Student > students = new ArrayList< Student >();
		students.add( new Student( "1", "data") );
		students.add( new Student( "2", "sasa") );
		return students;
	}
}
