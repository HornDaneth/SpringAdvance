package com.test.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-main-context.xml")
public class TestCreateStudent {

	@Autowired
	private StudentService studentService;
	@Test
	public void test() {
		
		assertNotNull(studentService);
		
//		Student student=new Student();
//		student.setAddress("hello");
//		student.setTel("hello");
//		student.setName("hello");
		
		//studentService.create(student);
		
		List<Student> students = studentService.getList();
		
		for(Student obj:students)
		{
			System.out.println(obj.getName());
		}
	}

}
