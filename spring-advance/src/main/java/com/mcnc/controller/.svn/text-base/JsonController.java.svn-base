package com.mcnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcnc.dto.User;
@Controller
public class JsonController {

    @RequestMapping( value="/user", method=RequestMethod.POST, consumes="application/json" )  
    public @ResponseBody User saveUser( @RequestBody User user ) {  
    	return user;  
    }  

}
