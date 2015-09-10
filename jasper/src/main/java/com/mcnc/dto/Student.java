package com.mcnc.dto;

public class Student {
	private String id;
	private String name;
	

	public Student() {
		super();
	}
	
	public Student(String _id, String name) {
		super();
		this.id = _id;
		this.name = name;
	}

	
	
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
