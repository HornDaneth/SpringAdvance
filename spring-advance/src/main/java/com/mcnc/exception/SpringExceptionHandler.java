package com.mcnc.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@ControllerAdvice
public class SpringExceptionHandler extends SimpleMappingExceptionResolver{
	@ExceptionHandler
	public @ResponseBody ExceptionMessage String(Throwable throwable){
		return ExceptionMessageBuilder.build(throwable);
	}
}