package com.mcnc.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{
	
	/**
	 * URL: http://localhost:8080/
	 * @return
	 */
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
}
