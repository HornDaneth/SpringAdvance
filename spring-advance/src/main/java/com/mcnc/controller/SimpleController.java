package com.mcnc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcnc.service.StudentService;

@org.springframework.stereotype.Controller
public class SimpleController {
	private static Logger logger= LoggerFactory.getLogger(SimpleController.class);
	
	@Autowired
	StudentService studService;

	@RequestMapping ("/hello")
    public String hello( ModelMap model) {
 
        String message = "Hello World, " + studService.getStudent().getName();
        model.addAttribute("test", message);
        return "test";
    }

}