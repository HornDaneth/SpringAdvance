package com.mcnc.mail.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.mail.service.api.IMailService;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( "/textcontext-root.xml" )
public class EmailServiceTest {
	
	@Autowired @Qualifier( "htmlMailService" )
	private IMailService htmlMailService;
	
	@Autowired @Qualifier( "simpleMailService" )
	private IMailService simpleMailService;
	

	@Test
	public void testSimpleMail() {
		String to = "sayseakleng@gmail.com";
		String subject = "test";
		String body = "hello";
		try {
			simpleMailService.sendMail(to, subject, body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHtmlMail() {
		
		String to = "sayseakleng@gmail.com";
		String subject = "Test Subject";
		String body = "<b>Test Content</b>";
		try {
			htmlMailService.sendMail(to, subject, body );
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	


}
