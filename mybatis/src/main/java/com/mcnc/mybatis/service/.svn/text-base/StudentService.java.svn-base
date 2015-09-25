package com.mcnc.mybatis.service;

import java.util.List;

import com.mcnc.mybatis.dto.StudentDTO;
import com.mcnc.mybatis.exception.BusinessException;

public interface StudentService {
	
	public boolean create(StudentDTO stud) throws BusinessException;
	
	List< StudentDTO > getStudents();
	
	StudentDTO getStudentById(int id);
	
	public boolean deleteById(int id);
	
}
