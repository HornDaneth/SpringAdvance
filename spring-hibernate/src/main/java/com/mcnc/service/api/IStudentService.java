package com.mcnc.service.api;

import java.util.List;

import com.mcnc.dto.StudentDTO;

public interface IStudentService {
	public boolean create(StudentDTO stud);
	public List<StudentDTO> getStudents();
	public StudentDTO getStudentById(String id);
	public boolean update(StudentDTO stud);
	public boolean deleteStudentById(String id);
}
