package org.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.mcnc.dto.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/JsonTest.xml")
public class JsonTest {
	 @Autowired private RestTemplate restTemplate; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String jsonStringUser = "{"  
		        + "\"userName\":\"Test\"," 
		        + "\"score\":[98,99]" 
		        + "}";  
		  
        HttpHeaders headers = new HttpHeaders();  
        headers.setContentType( MediaType.APPLICATION_JSON );  
  
        @SuppressWarnings({ "rawtypes", "unchecked" })
		HttpEntity request= new HttpEntity( jsonStringUser, headers );  
        User returnedUser = restTemplate.postForObject( "http://localhost:8080/springmvcadvance/user.do", request, User.class );  
        assertNotNull( returnedUser.getUserName());    
        System.out.println("Name :" + returnedUser.getUserName());
        System.out.println("Math :" + returnedUser.getScore()[0]);
        System.out.println("C++ :" + returnedUser.getScore()[1]);
  
    }  
		   

}
