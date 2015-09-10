package com.mcnc.ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcnc.ad.dto.DepartmentTree;
import com.mcnc.ad.dto.User;
import com.mcnc.ad.service.LdapUsersTreeService;
import com.mcnc.ad.service.UserService;

@Controller
@RequestMapping("/ad")
public class UserController {
	
	@Autowired UserService userService;
	@Autowired LdapUsersTreeService treeService;
	
    @RequestMapping ("/users")
    public @ResponseBody List< User > getList( ) {
    	return  userService.getAllUsers();
    }
    
    @RequestMapping( "/tree/index" )
    public String getTreePage(){
    	return "tree";
    }
    
    @RequestMapping( "/tree" )
    public @ResponseBody DepartmentTree getTree(){
    	return treeService.constructDepartmentTree();
    }
    
}