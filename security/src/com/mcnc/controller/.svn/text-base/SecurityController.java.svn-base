package com.mcnc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SecurityController {
 
    @RequestMapping ("/index")
    public String helloWorld( ModelMap model,HttpServletRequest request) {
    	/*SecurityContextImpl sci=(SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");*/
        String message = "Hi";
        model.addAttribute("welcome", message );
        return "main";
    }
    
    @RequestMapping ("/login")
    public String login(){
    	return "login";
    }
    @RequestMapping ("/logout")
    public String logout(){
    	return "login";
    }
    
}