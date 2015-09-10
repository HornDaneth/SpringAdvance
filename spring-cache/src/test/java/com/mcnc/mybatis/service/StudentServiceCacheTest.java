package com.mcnc.mybatis.service;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.mybatis.dto.StudentDTO;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "/appcontext.cache-test.xml" )
public class StudentServiceCacheTest {
	@Autowired @Qualifier("studentServiceImpl")
	StudentService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
	}
	
	@Test
	public void getStudentList() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			List<StudentDTO> students = service.getStudents();
			System.out.println(students);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime); //368
	}

}
