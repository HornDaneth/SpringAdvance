package com.mcnc.spring.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.spring.service.IService;

@org.springframework.stereotype.Controller
public class Controller {
	
	Logger logger =  LoggerFactory.getLogger(Controller.class);

	@Autowired 
	private IService service;
    
	@RequestMapping ("/home.do")
    public String hello( Model model) {
		logger.debug("* Request on this method");
        model.addAttribute("hello", "Hello");
        model.addAttribute("name", service.getText());
        
        return "home";
    }

}