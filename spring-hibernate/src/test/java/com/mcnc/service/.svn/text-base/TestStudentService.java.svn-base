package com.mcnc.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.dto.StudentDTO;
import com.mcnc.service.api.IStudentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-servlet.xml")
public class TestStudentService {
	@Autowired IStudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
	}
	
	@Test
	public void testInsert(){
		StudentDTO stud = new StudentDTO();
		stud.setId("1");
		stud.setName("dara");
		
		boolean create = studentService.create(stud );
		assertTrue(create);
	}
	
	@Test
	public void testGetStudents() {
		List<StudentDTO> students = studentService.getStudents();
		assertTrue(students.size() > 0);
		System.out.println(students);
	}
	
	@Test
	public void testGetById(){
		String id = "1";
		StudentDTO studentById = studentService.getStudentById(id );
		assertNotNull(studentById);
		System.out.println(studentById);
	}
	
	@Test
	public void testUpdate(){
		StudentDTO stud = new StudentDTO();
		stud.setId("1");
		stud.setName("sasa");
		boolean update = studentService.update(stud);
		assertTrue(update);
		
	}
	
	
	@Test
	public void testDeletById(){
		String id = "1";
		boolean deleteStudentById = studentService.deleteStudentById(id);
		assertTrue(deleteStudentById);
	}

}
