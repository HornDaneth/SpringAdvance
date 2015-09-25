package com.mcnc.mybatis.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.mybatis.dto.StudentDTO;
import com.mcnc.mybatis.exception.BusinessException;
import com.mcnc.mybatis.service.StudentService;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "/appcontext-test.xml" )
public class StudentServiceTransactionTest {
	@Autowired @Qualifier("studentServiceTransactionImpl")
	StudentService service;
	
	@Test
	public void testInsert() {
		StudentDTO stud = new StudentDTO();
		stud.setId(3);
		stud.setName("sok");
		
		try {
			boolean create = service.create(stud);
			assertTrue(create);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testList(){
		List<StudentDTO> students = service.getStudents();
		System.out.println(students);
	}
	
	@Test
	public void testDelete(){
		boolean deleteById = service.deleteById(3);
		assertTrue(deleteById);
	}

}
