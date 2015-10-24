package com.example.student.daoImp;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.student.dao.StudentDao;
import com.example.student.model.Student;
@Repository
public class StudentDaoImp implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	@Override
	public List<Student> getList() {
		return (List<Student>)getCurrentSession().createCriteria(Student.class).list();	
	}

	@Override
	public Student findStudent(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Student student) {
		getCurrentSession().save(student);
	}

	@Override
	public void delete(Long id) {
		getCurrentSession().delete(id);
	}
	
}
