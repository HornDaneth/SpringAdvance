package com.mcnc.service.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mcnc.dto.StudentDTO;
import com.mcnc.dto.SubjectDTO;
public interface IStudentService {
	public boolean insert( StudentDTO stud );
	public List< StudentDTO > getStudents();
	public List<StudentDTO> getStudentsByName(String name);
	public StudentDTO getStudentById( String id );
	public StudentDTO getStudent( StudentDTO stud );
	public Page< StudentDTO > getStudentsWithPagination( Pageable pageable );
	public void removeStudentById( String id);
	public void removeAll();
	public void updateStudentAddress( StudentDTO stud );
	public void updateStudentSubject(String studentId, SubjectDTO subject);
}
