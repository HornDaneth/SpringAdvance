package com.mcnc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mcnc.dto.StudentDTO;
public interface StudentDAO extends MongoRepository< StudentDTO, String > {
	
	@Query("{ 'name' : ?0 }")
	List<StudentDTO> findByName(String name);
	
	@Query( "?0" )
	public StudentDTO findOne( StudentDTO stud );

}
