package com.mcnc.mybatis.service;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.mybatis.dao.extension.BaseDAO;
import com.mcnc.mybatis.dao.extension.ChildDAO;
import com.mcnc.mybatis.dto.StudentDTO;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( value = "/appcontext-test.xml" )
public class DAOExtensionTest {
	@Autowired @Qualifier("baseDAO")
	BaseDAO baseDao;
	
	@Autowired @Qualifier("childDAO")
	ChildDAO childDao;
	
	@Test
	public void baseDaoTest(){
		List<StudentDTO> students = baseDao.getStudents();
		System.out.println(students);
	}
	
	@Test
	public void childDaoTest(){
		List<StudentDTO> students = childDao.getStudents();
		System.out.println(students);
		
		StudentDTO studentById = childDao.getStudentById(1);
		System.out.println(studentById);
	}

}
