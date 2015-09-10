package com.mcnc.service;

import com.mcnc.dto.Student;

public class StudentService {
	
	public void start(){
		System.out.println("Start student service");
	}
	
	public void stop(){
		System.out.println("Stop student service");
	}
	
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		System.out.println("Set student service property");
		this.student = student;
	}

}
