package com.mcnc.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcnc.upload.dto.FileUpload;

@Controller
public class FileUploadController {
	
	
	@RequestMapping("index.do")
	public String getUploadPage(){
		return "index";
	}
	
	
	@RequestMapping(value="upload.do", method = RequestMethod.POST)
	public @ResponseBody String upload(FileUpload fileUpload){
		
		String response = String.format("File 1: %s, File 2: %s, Description: %s", fileUpload.getFile1().getOriginalFilename(), 
				fileUpload.getFile2().getOriginalFilename(), fileUpload.getDescription() );
		
		return response;
		
	}

}
