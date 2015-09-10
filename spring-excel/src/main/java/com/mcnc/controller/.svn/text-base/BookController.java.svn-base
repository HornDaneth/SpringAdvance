package com.mcnc.controller;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.dto.Book;
import com.mcnc.service.api.IBookService;

@Controller
public class BookController {
	Logger logger =  LoggerFactory.getLogger(BookController.class);

	@Autowired 
		IBookService service;
	
	/**
	 * URL: http://localhost:8080/spring-excel/api/books/download
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping ("/api/books/download")
    public String hello(Model model, HttpServletResponse response) {
		response.setHeader("Content-Disposition", "inline; filename=\"students.xls\"");
		
		List<Book> books = service.getBooks();
		model.addAttribute("books", books);
		
        return "bookExcelView";
    }

}