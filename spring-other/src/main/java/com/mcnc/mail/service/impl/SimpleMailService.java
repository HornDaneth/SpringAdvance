package com.mcnc.mail.service.impl;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.mcnc.mail.service.api.IMailService;

/**
 * This class is used to send Email with simple content
 *
 */

@Service( "simpleMailService" )
public class SimpleMailService implements IMailService{
	
	@Autowired
    protected JavaMailSender mailSender;
	
	public void sendMail( String to, String subject, String body ) throws MessagingException {
		
		// Prepares Email
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom( this.getSenderAddress() );
		message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        
        // Send Email
        mailSender.send( message );
	}
	
	protected String getSenderAddress(){
		return ( ( JavaMailSenderImpl ) mailSender ).getUsername();
	}

}
