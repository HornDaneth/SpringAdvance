package com.mcnc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mcnc.dto.Student;
import com.mcnc.service.api.IStudentService;

@Configuration
@ComponentScan(basePackages = {"com.mcnc"})
public class Application {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		IStudentService studentService = context.getBean(IStudentService.class);
		
		
		// add new student
		studentService.addStudent(new Student(1, "Dara"));
		
		// show list
		List<Student> studentList = studentService.getStudentList();
		System.out.println(studentList);
	}
}
