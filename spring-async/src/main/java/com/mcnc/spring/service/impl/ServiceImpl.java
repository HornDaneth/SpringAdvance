package com.mcnc.spring.service.impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.mcnc.spring.service.IService;
@Service
public class ServiceImpl implements IService{

	public String getSyncText() {
		String result = null;
		
		try {
			System.out.println("Code: Requesting...");
			Thread.sleep(3000);
			result = "Responded";
			System.out.println("Code: ".concat(result));
		} catch (Exception e) {
		}
		
		return result;
	}

	@Async
	public Future<String> getAsyncText() {
		return new AsyncResult<String>(this.getSyncText());
	}

	
}
