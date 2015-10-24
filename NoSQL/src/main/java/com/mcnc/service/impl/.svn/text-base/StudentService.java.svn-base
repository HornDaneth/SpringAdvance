package com.mcnc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mcnc.dao.StudentDAO;
import com.mcnc.dto.StudentDTO;
import com.mcnc.dto.SubjectDTO;
import com.mcnc.service.api.IStudentService;
@Repository
public class StudentService implements IStudentService{
	
	@Autowired 
	private  StudentDAO studentDAO;
	
	@Autowired
	private MongoOperations mongoOperations;
	

	public boolean insert( StudentDTO stud ) {
		StudentDTO result = studentDAO.save( stud );
		return result != null ? true : false;
	}

	@Override
	public List<StudentDTO> getStudentsByName(String name) {
		return studentDAO.findByName(name);
	}
	
	public List<StudentDTO> getStudents() {
		return studentDAO.findAll();
	}

	public StudentDTO getStudentById(String id) {
		return studentDAO.findOne( id );
	}

	public StudentDTO getStudent(StudentDTO stud) {
		return studentDAO.findOne( stud ) ;
	}
	
	public Page<StudentDTO> getStudentsWithPagination( Pageable pageable) {
		return studentDAO.findAll( pageable );
	}
	
	
	
	
	public void removeStudentById(String id) {
		studentDAO.delete( id );
	}

	@Override
	public void removeAll() {
		studentDAO.deleteAll();
	}



	@Override
	public void updateStudentAddress(StudentDTO stud) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(stud.getId()));
		
		Update update = new Update();
		update.set("address.city", stud.getAddress().getCity());
		update.set("address.country", stud.getAddress().getCountry());
		
		mongoOperations.findAndModify(query, update, StudentDTO.class);
	}
	
	@Override
	public void updateStudentSubject(String studentId, SubjectDTO subject) {
		
		Query query = new Query();
		query.addCriteria(new Criteria().andOperator(
			Criteria.where("_id").is(studentId),
			Criteria.where("subjects").elemMatch(Criteria.where("subId").is(subject.getSubId()))
		));
		
		
		Update update = new Update().set("subjects.$.subDec", subject.getSubDec());
		
		mongoOperations.findAndModify(query, update, StudentDTO.class);
	}


}
