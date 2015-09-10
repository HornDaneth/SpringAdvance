package com.mcnc.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcnc.dao.api.IStudentDAO;
import com.mcnc.dto.StudentDTO;
import com.mcnc.service.api.IStudentService;

@Service
public class StudentService implements IStudentService{
	@Autowired
	private IStudentDAO studentDAO;
	
	@Override
	public boolean create(StudentDTO stud) {
		return studentDAO.create(stud) > 0;
	}

	@Override
	public List<StudentDTO> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	public StudentDTO getStudentById(String id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	public boolean update(StudentDTO stud) {
		return studentDAO.update(stud) > 0;
	}

	@Override
	public boolean deleteStudentById(String id) {
		return studentDAO.deleteStudentById(id) > 0;
	}


}
