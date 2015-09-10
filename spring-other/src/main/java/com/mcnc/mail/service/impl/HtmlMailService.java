package com.mcnc.mail.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mcnc.mail.service.api.IMailService;


@Service( "htmlMailService" )
public class HtmlMailService extends  SimpleMailService implements IMailService{

	public void sendMail( String to, String subject, String body ) throws MessagingException {
	
		MimeMessage message = super.mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper( message, false, "UTF-8"); 
		helper.setFrom( super.getSenderAddress() );
		helper.setTo( new InternetAddress( to ) ); 
		helper.setSubject( subject ); 
		helper.setText( body, true ); 
		
		super.mailSender.send( message );
	}
}
