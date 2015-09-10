package com.test.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.Student;
import com.test.service.api.IStudentService;

@Controller
public class StudentController {
	@Autowired IStudentService studentService;
	

	//@ModelAttribute String st, @RequestParam String projectID, ModelMap model, HttpSession session, HttpServletRequest request)throws Exception{}

	
	@RequestMapping("/search")
	public String form(HttpSession session) {
  
		session.setAttribute("test", "Student List");
		
	
		return "Search";
	}
	
	@RequestMapping("/result")
	
	public String Search(@ModelAttribute Student stud,ModelMap model,HttpSession session) throws Exception {
		List<Student> students= studentService.getStudentById(stud);
		model.addAttribute("students",students);
		model.addAttribute("headerValue",session.getAttribute("test"));
		return "Result";
	}
}