package com.mcnc.service.more;

import org.codehaus.groovy.runtime.MethodClosure;

public class Caller {
	public void execute(MethodClosure methodClosure){
		methodClosure.call(5, 2 ,3 );
	}
}
