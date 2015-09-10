package com.mcnc.tile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcnc.tile.constraint.View;
import com.mcnc.tile.dto.ContactDTO;
@Controller
public class ViewController {
	@RequestMapping( "/index" )
	public String getIndexPage( Model model ){
		model.addAttribute( "command" , new ContactDTO() );
		return View.CONTACT.getValue();
	}
	
	@RequestMapping( "/submit" )
	public @ResponseBody ContactDTO doSubmit( @ModelAttribute ContactDTO cont ){
		return cont;
	}
}
