package com.mcnc.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.dto.AddressDTO;
import com.mcnc.dto.StudentDTO;
import com.mcnc.dto.SubjectDTO;
import com.mcnc.service.api.IStudentService;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( "/appcontext-root.xml" )
public class StudentServiceTest {
	@Autowired
		private IStudentService studentService;
	String id = "001";
	String name = "";
	AddressDTO address;
	List<SubjectDTO> subjects;
	
	
	@Before
	public void initVars(){
		name = id + "Name";
		
		address = new AddressDTO();
		address.setCity("PP");
		address.setCountry("KH");
		
		subjects = new ArrayList<SubjectDTO>();
		SubjectDTO subject = new SubjectDTO();
		subject.setSubId("1");
		subject.setSubDec("AA");
		subjects.add(subject);
		
		subject = new SubjectDTO();
		subject.setSubId("2");
		subject.setSubDec("BB");
		subjects.add(subject);
		
	}

	
	@Test
	public void addNewStudent(){
		
		
		StudentDTO stud = new StudentDTO(id, name, address, subjects);
		studentService.insert( stud );
		
		StudentDTO studentById = studentService.getStudentById( id );
		System.out.println( "after add:" + studentById );
	}

	
	@Test
	public void getStudentsByName() {
		List<StudentDTO> studentsByName = studentService.getStudentsByName(name);
		System.out.println(studentsByName);
	}
	
	
	@Test
	public void getSudentByIdAndName(){
		StudentDTO stud = new StudentDTO(id, name);
		StudentDTO student = studentService.getStudent( stud );
		System.out.println( student );
	}

	@Test
	public void getSudentsByPagination(){
		Sort sort = new Sort( Sort.Direction.ASC, "name" );
		
		PageRequest pageable = new PageRequest( 0, 10, sort );
		
		Page<StudentDTO> studentsWithPagination = studentService.getStudentsWithPagination( pageable );
		System.out.println( studentsWithPagination );
	}
	
	@Test
	public void getStudents() {
		List<StudentDTO> students = studentService.getStudents();
		System.out.println(students);
	}
	
	
	
	@Test
	public void removeId(){
		
		studentService.removeStudentById( id );
		
		StudentDTO studentById = studentService.getStudentById( id );
		System.out.println( "after delete:" + studentById );
	}
	
	@Test
	public void deleteAll() {
		studentService.removeAll();
	}
	
	
	@Test
	public void updateAddress() {
		address.setCity("Phnom Penh");
		address.setCountry("Cambodia");
		StudentDTO stud = new StudentDTO(id, null, address);
		studentService.updateStudentAddress(stud);
		
		StudentDTO studentById = studentService.getStudentById( id );
		System.out.println( "after update:" + studentById );
		
	}
	
	@Test
	public void updateSubject() {
		SubjectDTO subject = new SubjectDTO();
		subject.setSubId("2");
		subject.setSubDec("Programming");
		
		studentService.updateStudentSubject(id, subject);
		
		StudentDTO studentById = studentService.getStudentById( id );
		System.out.println( "after update:" + studentById );
	}

}
