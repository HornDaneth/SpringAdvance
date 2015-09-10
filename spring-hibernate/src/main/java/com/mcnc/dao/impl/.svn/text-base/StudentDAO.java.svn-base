package com.mcnc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcnc.dao.api.IStudentDAO;
import com.mcnc.dto.StudentDTO;
import com.mcnc.util.EntityUtils;
@Repository
@Transactional
public class StudentDAO implements IStudentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int create(StudentDTO stud) {
		try {
			sessionFactory.getCurrentSession().persist(stud);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<StudentDTO> getStudents() {
		@SuppressWarnings("unchecked")
		List<StudentDTO> list = sessionFactory.getCurrentSession()
				.createCriteria(StudentDTO.class).list();
		return list;
	}

	@Override
	public StudentDTO getStudentById(String id) {
		String filter = String.format("from %s where id = :id", EntityUtils.toEntityName(StudentDTO.class));
		
		StudentDTO stud = (StudentDTO) sessionFactory.getCurrentSession()
				.createQuery(filter)
				.setParameter("id", id)
				.uniqueResult();
		return stud;
	}

	@Override
	public int update(StudentDTO stud) {
		try {
			sessionFactory.getCurrentSession().update(stud);;
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int deleteStudentById(String id) {
		try {
			StudentDTO stud  = new StudentDTO();
			stud.setId(id);
			sessionFactory.getCurrentSession().delete(stud);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
