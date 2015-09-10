package com.mcnc.mybatis.service;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.mybatis.dto.StudentDTO;
import com.mcnc.mybatis.service.StudentService;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "/appcontext-test.xml" )
public class StudentServiceTest {
	@Autowired @Qualifier("studentServiceImpl")
	StudentService service;
	
	
	@Test
	public void getStudentList() {
		List<StudentDTO> studs = service.getStudents();
		System.out.println( studs );
	}
	
	@Test
	public void getStudentById(){
		int id = 1;
		StudentDTO stud = service.getStudentById( id );
		System.out.println( stud );
		
	}

}
