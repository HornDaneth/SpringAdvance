package com.mcnc.dao.api;

import java.util.List;

import com.mcnc.dto.StudentDTO;

public interface IStudentDAO {
	public int create(StudentDTO stud);
	public List<StudentDTO> getStudents();
	public StudentDTO getStudentById(String id);
	public int update(StudentDTO stud);
	public int deleteStudentById(String id);
}
