package com.mcnc.service.impl
import com.mcnc.dto.Student
import com.mcnc.service.api.IScoreService

public class HighSchoolScoreService implements IScoreService{
	
	private Student student = new Student()
	private def adjustValue

	public Student getStudent() {
		return student
	}

	public void setStudent(Student  student) {
		println "Set:" + student
		adjustValue = 0
		student.setScore(student.getScore() + adjustValue)
		this.student = student
	}

	public String getGrade() {
		if(student.getScore()>49)
			return "A"
		else
			return "B"
	}

}
