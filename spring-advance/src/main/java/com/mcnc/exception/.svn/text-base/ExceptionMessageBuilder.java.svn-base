package com.mcnc.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

public abstract class ExceptionMessageBuilder {
	public static final String EXCEPTION_ATTRIBUTE  		= "javax.servlet.error.exception";
	public static final String SPRING_EXCEPTION_ATTRIBUTE  	= "org.springframework.web.servlet.DispatcherServlet.EXCEPTION";
	public static final String EXCEPTION_MESSAGE			= "javax.servlet.error.message";
	public static final String STATUS_CODE_ATTRIBUTE  		= "javax.servlet.error.status_code";
	
	public static ExceptionMessage build(HttpServletRequest request){
		
		// look up throwable object
		Throwable throwable = (Throwable) request.getAttribute(EXCEPTION_ATTRIBUTE); // from Servlet
		if(throwable == null) {
			throwable = (Throwable) request.getAttribute(SPRING_EXCEPTION_ATTRIBUTE); // from Spring
		}
		// look up error code
		Integer statusCode = (Integer) request.getAttribute(STATUS_CODE_ATTRIBUTE);

		// look up error msg
		String msg  = (String) request.getAttribute(EXCEPTION_MESSAGE);
		
		// create response object
		ExceptionMessage exceptionMessage = ExceptionMessageBuilder.build(statusCode, throwable);
		if( exceptionMessage.getDescription() == null ) {
			exceptionMessage.setDescription(msg);;
		}
		return exceptionMessage;
	}
	
	
	public static ExceptionMessage build(Throwable throwable){
		return ExceptionMessageBuilder.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), throwable);
	}
	
	
	public static ExceptionMessage build(Integer statusCode, Throwable throwable){
		ExceptionMessage exceptionMessage = new ExceptionMessage();
		
		if(statusCode != null) {
			exceptionMessage.setCode(statusCode);
		}
		else {
			exceptionMessage.setCode(HttpStatus.BAD_REQUEST.value());
			exceptionMessage.setDescription(HttpStatus.BAD_REQUEST);
			exceptionMessage.setType(ClassUtils.getShortName(Exception.class));
			return exceptionMessage;
		}
		
		if(throwable != null){
			
			Object Message = null;
			
			if(throwable instanceof BindException) {
				BindingResult bindingResult = ((BindException) throwable).getBindingResult();
				if(bindingResult.hasErrors()){
					Message = bindingResult.getAllErrors();
				}
			}
			else {
				Message = throwable.getMessage();
			}
			
			exceptionMessage.setType(ClassUtils.getShortName(throwable.getClass()));
			exceptionMessage.setDescription(Message);
			exceptionMessage.setCause(throwable.getCause());
			exceptionMessage.setException(throwable.getStackTrace());
		}
		
		return exceptionMessage;
	}

}
