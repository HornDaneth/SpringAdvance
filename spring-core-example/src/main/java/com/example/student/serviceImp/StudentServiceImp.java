package com.example.student.serviceImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.student.dao.StudentDao;
import com.example.student.model.Student;
import com.example.student.service.StudentService;

//@Service
@Transactional
public class StudentServiceImp implements StudentService{

	//@Autowired
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getList() {
		return (List<Student>)studentDao.getList();
	}

	@Override
	public Student findStudent(Long id) {
		return null;
	}

	@Override
	public void create(Student student) {
		studentDao.create(student);		
	}

	@Override
	public void delete(Long id) {
		studentDao.delete(id);
	}

}
