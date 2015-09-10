package com.mcnc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.mcnc.dto.Student;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/appcontext-new-client.xml")
public class RestClientTest {
	@Autowired
	RestTemplate restTemplate;

	@Test
	public void test() {
		Student[] forObject = restTemplate.getForObject("http://localhost:8080/restful/api/students", Student[].class);
		for (Student student : forObject) {
			System.out.println(student);
		}
	}

}
