package com.mcnc.exception;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonServletErrorController{
	@RequestMapping("/exceptions/json")
	public ExceptionMessage getExeptionDetail(HttpServletRequest request){
		ExceptionMessage msg = ExceptionMessageBuilder.build(request);
		return msg;
	}
}