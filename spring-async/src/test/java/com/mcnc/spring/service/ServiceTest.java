package com.mcnc.spring.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testcontext-root.xml")
public class ServiceTest {
	
	@Autowired
	private IService service;

	@Test
	public void testSync() {
		String syncText = service.getSyncText();
		System.out.println(syncText);
	}
	
	
	@Test
	public void testASync() throws InterruptedException, ExecutionException {
		Future<String> asyncText = service.getAsyncText();
		System.out.println("Passed");
		
		// get & wait response
		System.out.println(asyncText.get());
	}

}
