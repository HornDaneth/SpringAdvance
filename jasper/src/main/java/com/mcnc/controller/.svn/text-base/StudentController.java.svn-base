package com.mcnc.controller;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.dto.Student;
import com.mcnc.report.constraint.ReportType;
import com.mcnc.service.api.IStudentService;

@Controller
public class StudentController {
	@Autowired 
	private IStudentService studentService;
	
	/**
	 * URL: http://localhost:8080/jasper/students.pdf
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping( "/students.{type}" )
	public String getStudentListView(@PathVariable ReportType type, Model model){
		List< Student > items = studentService.getStudents();
		JRDataSource ds = new JRBeanCollectionDataSource( items ); 
		model.addAttribute( "datasource" , ds );
		
		return type.name() + "Report"; 
	}
}
