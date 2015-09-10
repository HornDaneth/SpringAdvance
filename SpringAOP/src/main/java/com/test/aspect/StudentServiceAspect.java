package com.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class StudentServiceAspect {
	
	public void beforeMethod() {
		System.out.println("Before the method call");
	}
	
	public void afterMethod(JoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		Class declaringType = signature.getDeclaringType();
		String declaringTypeName = signature.getDeclaringTypeName();
		
		System.out.println("After the method call");
	}
}
