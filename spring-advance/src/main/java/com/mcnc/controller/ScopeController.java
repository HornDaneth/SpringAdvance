package com.mcnc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcnc.scope.ScopeService;

@Controller
@RequestMapping("/scope")
public class ScopeController {
	@Autowired 
	private ScopeService scopeService;

	@RequestMapping("/set")
	public @ResponseBody Boolean set(){
		scopeService.setData("hello");
		return true;
	}
	
	
	@RequestMapping("/get")
	public @ResponseBody String get(){
		return scopeService.getData();
	}
}
