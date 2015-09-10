package com.mcnc.mybatis.dao;

import java.util.List;

import com.mcnc.mybatis.dto.StudentDTO;

public interface StudentDAO {
	public int create(StudentDTO stud);
	List< StudentDTO > getStudents();
	StudentDTO getStudentById(int id);
	public int deleteById(int id);
}
