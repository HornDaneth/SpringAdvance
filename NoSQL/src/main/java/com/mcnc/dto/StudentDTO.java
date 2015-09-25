package com.mcnc.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "students" )
public class StudentDTO {
	
	public StudentDTO(){
		
	}
	
	public StudentDTO(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public StudentDTO(String id, String name, AddressDTO address){
		this(id, name);
		this.address = address;
	}
	
	public StudentDTO(String id, String name, AddressDTO address, List<SubjectDTO> subjects){
		this(id, name, address);
		this.subjects = subjects;
	}
	
	@Id
	private String id;
	
	private String name;
	
	private AddressDTO address;
	
	private List<SubjectDTO> subjects;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	public List<SubjectDTO> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectDTO> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", address=" + address + ", subjects=" + subjects + "]";
	}

	
} 
