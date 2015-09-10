package com.mcnc.spring.controller;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.spring.service.IService;

@RestController
@RequestMapping("/tasks")
public class Controller {
	
	Logger logger =  LoggerFactory.getLogger(Controller.class);

	@Autowired 
	private IService service;
    
	@RequestMapping ("/async")
    public String sendAsyncMessage() {
		Future<String> asyncText = service.getAsyncText();
		return "send";
	}
	
	
	@RequestMapping ("/sync")
    public String sendSyncMessage() {
		return service.getSyncText();
	}

}