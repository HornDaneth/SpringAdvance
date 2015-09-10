package com.test.SpringMyBatisMVC;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/mybatis/source-config.xml"})
public class StudentServiceTest {
	
	@Autowired
	StudentService stud;
	
	Student student;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		student=new Student();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		assertNotNull("Object initialized fail!",stud);
		assertNotSame("No data available!", stud.getStudentById(student).size(), 0);
		System.out.println("Fetched all record:" +stud.getStudentById(student));
		student.setId(1);
		System.out.println("Fetched by ID=1:" + stud.getStudentById(student));
	}

}
