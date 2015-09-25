package com.mcnc.mybatis.service;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.mybatis.dto.StudentDTO;
import com.mcnc.mybatis.service.StudentService;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "/appcontext-test-jndi.xml" )
public class StudentServiceJndiTest {
	@Autowired @Qualifier("studentServiceImpl")
	StudentService service;
	
	@BeforeClass
	public static void initialize() {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.xbean.spring.jndi.SpringInitialContextFactory");
		try {
			new InitialContext();
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}
	
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
