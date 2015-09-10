package com.test.dto;


public class Student{
	private int ID;
	private String Name;
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	
	public String toString(){
		return ("(ID:" + getId() + ", Name:" + getName() + ")");
	}

	
}