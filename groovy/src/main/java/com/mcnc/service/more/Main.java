package com.mcnc.service.more;

import org.codehaus.groovy.runtime.MethodClosure;

public class Main {
	public static void main(String[] args){
		
		Caller caller = new Caller();
		
		// For static method:
		MethodClosure methodClosure = new MethodClosure(CallBack.class, "sum");
		caller.execute(methodClosure);
		
		// For object instance
		CallBack callBack = new CallBack();
		methodClosure = new MethodClosure(callBack, "show");
		caller.execute(methodClosure);
		
	}
}
