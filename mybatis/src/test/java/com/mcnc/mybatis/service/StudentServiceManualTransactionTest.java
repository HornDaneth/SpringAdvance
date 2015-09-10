package com.mcnc.mybatis.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mcnc.mybatis.dto.StudentDTO;
import com.mcnc.mybatis.exception.BusinessException;
import com.mcnc.mybatis.service.StudentService;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "/appcontext-test.xml" )
public class StudentServiceManualTransactionTest {
	@Autowired @Qualifier("studentServiceImpl")
	StudentService service;
	
	@Autowired
	DataSourceTransactionManager manager;
	
	
	@Test @Transactional
	public void testCreate() throws BusinessException{
		StudentDTO stud = new  StudentDTO();
		stud.setId(3);
		stud.setName("Neary");
		boolean create = service.create(stud);
		assertTrue(create);
		if(create){
			DefaultTransactionDefinition dtxd = new DefaultTransactionDefinition();
			dtxd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			manager.rollback(manager.getTransaction(dtxd));
		}
	}
	
	
	@Test
	public void testGetStudentList() {
		List<StudentDTO> studs = service.getStudents();
		System.out.println( studs );
	}
	
	@Test
	public void testDelete(){
		boolean deleteById = service.deleteById(3);
		assertTrue(deleteById);
	}


}
